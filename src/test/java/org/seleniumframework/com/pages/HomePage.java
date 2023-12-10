package org.seleniumframework.com.pages;

import org.openqa.selenium.WebDriver;
import org.seleniumframework.com.base.BasePage;
import org.seleniumframework.com.pages.components.MyHeader;
import org.seleniumframework.com.pages.components.ProductThumbnail;

public class HomePage extends BasePage {
    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;

    public HomePage(WebDriver driver) {
        super(driver);
        myHeader = new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }
}
