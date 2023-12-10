package org.seleniumframework.com.factory.abstractFactory;

import org.seleniumframework.com.constants.DriverType;

public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(DriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManagerAbstract();
            }
            case FIREFOX -> {
                return new FirefoxDriverManagerAbstract();
            }
            case CHROME_REMOTE -> {
                return new ChromeRemoteDriverManagerAbstract();
            }
            case FIREFOX_REMOTE -> {
                return new FirefoxRemoteDriverManagerAbstract();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
