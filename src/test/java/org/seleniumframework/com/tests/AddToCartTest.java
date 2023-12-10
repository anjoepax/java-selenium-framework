package org.seleniumframework.com.tests;

import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.dataproviders.MyDataProvider;
import org.seleniumframework.com.objects.Product;
import org.seleniumframework.com.pages.CartPage;
import org.seleniumframework.com.pages.HomePage;
import org.seleniumframework.com.pages.StorePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AddToCartTest extends BaseTest {

    @Test(description = "Add to cart from Store page test")
    public void addToCartFromStorePage() throws IOException {
        Product product = new Product(1215);
        CartPage cartPage = new StorePage(getDriver()).load().
                getProductThumbnail().clickAddToCartBtn(product.getName()).
                clickViewCart();
        assertThat(cartPage.getProductName()).isEqualTo(product.getName());
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = MyDataProvider.class,
            description = "Add to cart from Featured products test")
    public void addToCartFeaturedProducts(Product product){
        CartPage cartPage = new HomePage(getDriver()).load().
                getProductThumbnail().
                clickAddToCartBtn(product.getName()).
                clickViewCart();
        assertThat(cartPage.getProductName()).isEqualTo(product.getName());
    }
}
