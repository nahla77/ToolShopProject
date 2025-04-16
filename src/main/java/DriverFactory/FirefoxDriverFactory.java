package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static utilities.PropertiesManager.webConfig;

public class FirefoxDriverFactory extends DriverAbstract {
    @Override
    public WebDriver StartDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if(webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        driver = new FirefoxDriver(options);
        return driver;
    }
}
