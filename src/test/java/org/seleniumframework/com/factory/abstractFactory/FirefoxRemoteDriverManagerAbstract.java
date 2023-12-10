package org.seleniumframework.com.factory.abstractFactory;

import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FirefoxRemoteDriverManagerAbstract extends DriverManagerAbstract {
    @Override
    @SneakyThrows
    protected void startDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
}
