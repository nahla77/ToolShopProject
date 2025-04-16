package DriverFactory;

import BrowserActions.browserActions;
import ElementActions.elementActions;
import listeners.Webdriver.DriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import static utilities.PropertiesManager.webConfig;

public class Driver {

    private ThreadLocal<WebDriver> driver;

    public Driver(){
        String driverType = webConfig.getProperty("BrowserType");
        WebDriver undecoratedDriver = getDriver(driverType).StartDriver();
        assert undecoratedDriver != null;

        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(WebDriver.class,
                new DriverListener(undecoratedDriver)).decorate(undecoratedDriver));


        System.out.println("Starting the execution via " + driverType + " driver");
        driver.get().manage().window().maximize();

        if(!webConfig.getProperty("BaseURL").isEmpty()) {
            driver.get().navigate().to(webConfig.getProperty("BaseURL"));
        }

    }

    public Driver(String driverType){
        WebDriver undecoratedDriver = getDriver(driverType).StartDriver();
        assert undecoratedDriver != null;

        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(WebDriver.class,
                new DriverListener(undecoratedDriver)).decorate(undecoratedDriver));

        System.out.println("Starting the execution via " + driver + " driver");
        driver.get().manage().window().maximize();

        if(!webConfig.getProperty("BaseURL").isEmpty()) {
            driver.get().navigate().to(webConfig.getProperty("BaseURL"));
        }

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

    public WebDriver get(){
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
