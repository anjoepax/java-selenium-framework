package org.seleniumframework.com.tests;

import org.seleniumframework.com.base.BaseTest;
import org.seleniumframework.com.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    @Test(description = "Search with partial match test")
    public void searchWithPartialMatch(){
        String searchFor = "Blue";
        StorePage storePage = new StorePage(getDriver()).
                load().
                search(searchFor);
        assertThat(storePage.getTitle()).isEqualTo("Search results: “" + searchFor + "”");
    }
}
