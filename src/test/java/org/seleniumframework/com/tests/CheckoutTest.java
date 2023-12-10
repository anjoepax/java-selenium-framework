package org.seleniumframework.com.tests;

import org.seleniumframework.com.api.CartApi;
import org.seleniumframework.com.api.SignUpApi;
import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.objects.BillingAddress;
import org.seleniumframework.com.objects.Product;
import org.seleniumframework.com.objects.User;
import org.seleniumframework.com.pages.CheckoutPage;
import org.seleniumframework.com.utils.FakerUtils;
import org.seleniumframework.com.utils.JacksonUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest extends BaseTest {

    @Test(description = "Guest checkout using direct bank transfer test")
    public void GuestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();

        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);
        injectCookiesToBrowser(cartApi.getCookies());

        checkoutPage.load().
        setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        assertThat(checkoutPage.getNotice()).isEqualTo("Thank you. Your order has been received.");
    }

    @Test(description = "Login and checkout using direct bank transfer test")
    public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi(signUpApi.getCookies());
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(signUpApi.getCookies());
        checkoutPage.load();
        checkoutPage.setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
        assertThat(checkoutPage.getNotice()).isEqualTo("Thank you. Your order has been received.");
    }
}
