package org.seleniumframework.com.tests;

import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.pages.HomePage;
import org.seleniumframework.com.pages.StorePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTest extends BaseTest {

    @Test(description = "Navigation test")
    public void NavigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage = new HomePage(getDriver()).
                load().getMyHeader().
                navigateToStoreUsingMenu();
        assertThat(storePage.getTitle()).isEqualTo("Store");
    }
}
