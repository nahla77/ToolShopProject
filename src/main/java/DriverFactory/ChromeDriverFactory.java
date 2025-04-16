package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utilities.PropertiesManager.webConfig;

public class ChromeDriverFactory extends DriverAbstract {

    @Override
    public WebDriver StartDriver() {
        ChromeOptions options = new ChromeOptions();
        if(webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        return driver;
    }

}