package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory extends DriverAbstract{
    @Override
    public WebDriver StartDriver() {
        driver= new ChromeDriver();
        return driver;
    }
}
