package org.seleniumframework.com.tests;

import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.objects.BillingAddress;
import org.seleniumframework.com.objects.Product;
import org.seleniumframework.com.objects.User;
import org.seleniumframework.com.pages.CartPage;
import org.seleniumframework.com.pages.CheckoutPage;
import org.seleniumframework.com.pages.HomePage;
import org.seleniumframework.com.pages.StorePage;
import org.seleniumframework.com.utils.ConfigLoader;
import org.seleniumframework.com.utils.JacksonUtils;
import org.testng.Assert;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {

//    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StorePage storePage = new HomePage(getDriver()).
                load().
                getMyHeader().navigateToStoreUsingMenu()
                .search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.getProductThumbnail().clickAddToCartBtn(product.getName());
        CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckoutPage checkoutPage = cartPage.
                checkout().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

//    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        User user = new User(ConfigLoader.getInstance().getUsername(),
                ConfigLoader.getInstance().getPassword());

        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu().
                search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.getProductThumbnail().clickAddToCartBtn(product.getName());
        CartPage cartPage = storePage.getProductThumbnail().clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickHereToLoginLink();

        checkoutPage.
                login(user).
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
