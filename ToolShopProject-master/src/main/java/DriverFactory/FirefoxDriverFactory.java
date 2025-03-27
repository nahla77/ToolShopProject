package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory extends DriverAbstract {
    @Override
    public WebDriver StartDriver() {
        driver = new FirefoxDriver();
        return driver;
    }
}
