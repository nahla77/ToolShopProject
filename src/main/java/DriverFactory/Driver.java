package DriverFactory;

import BrowserActions.browserActions;
import ElementActions.elementActions;
import org.openqa.selenium.WebDriver;

public class Driver {

    private ThreadLocal<WebDriver> driver;

    public Driver(String driverType){
        driver = new ThreadLocal<>();
        driver.set(getDriver(driverType).StartDriver());
        System.out.println("Starting the execution via "+ driver + "driver");
        this.driver.get().manage().window().maximize();

    }




    private DriverAbstract getDriver(String driver){
        switch (driver.toUpperCase()){
            case "CHROME":{
                return new ChromeDriverFactory();
            }
            case "FIREFOX":{
                return new FirefoxDriverFactory();
            }
            case "EDGE":{
                return new EdgeDriverFactory();
            }
            default:{
                throw new IllegalStateException("Unexpected Value:"+ driver);
            }
        }
    }

    public WebDriver get(String url){
        return this.driver.get();
    }

    public void Quit(){
        driver.get().quit();
    }

    public elementActions element() {
        return new elementActions(driver.get());
    }

    public browserActions browser() {
        return new browserActions(driver.get());
    }
}