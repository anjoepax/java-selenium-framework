package org.seleniumframework.com.dataproviders;

import org.seleniumframework.com.objects.Product;
import org.seleniumframework.com.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    @DataProvider(name = "getFeaturedProducts", parallel = false)
    public Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserializeJson("products.json", Product[].class);
    }
}
