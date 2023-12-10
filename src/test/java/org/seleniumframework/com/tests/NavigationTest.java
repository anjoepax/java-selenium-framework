package org.seleniumframework.com.tests;

import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.pages.HomePage;
import org.seleniumframework.com.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
}
