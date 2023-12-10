package org.seleniumframework.com.tests;

import org.seleniumframework.com.api.CartApi;
import org.seleniumframework.com.api.SignUpApi;
import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.objects.Product;
import org.seleniumframework.com.objects.User;
import org.seleniumframework.com.pages.CheckoutPage;
import org.seleniumframework.com.utils.FakerUtils;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(description = "Login during checkout test")
    public void loginDuringCheckout() throws Exception {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        checkoutPage.
                clickHereToLoginLink().
                login(user);
        assertThat(checkoutPage.getProductName()).contains(product.getName());
    }
}
