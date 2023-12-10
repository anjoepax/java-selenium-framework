package org.seleniumframework.com.factory.abstractFactory;

import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeRemoteDriverManagerAbstract extends DriverManagerAbstract {
    @Override
    @SneakyThrows
    protected void startDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
}
