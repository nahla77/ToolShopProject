package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverFactory extends DriverAbstract{
    @Override
    public WebDriver StartDriver() {
        driver = new EdgeDriver();
        return driver;
    }
}
