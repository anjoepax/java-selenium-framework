package org.seleniumframework.com.tests;

import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch(){
        String searchFor = "Blue";
        StorePage storePage = new StorePage(getDriver()).
                load().
                search(searchFor);
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
    }
}
