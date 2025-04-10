package Pages;

import DriverFactory.Driver;
import org.testng.Assert;

public class PowerToolPage {

    private Driver driver;

    public PowerToolPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/
    public PowerToolPage CheckThatUrlOfPowerToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/power-tools");
        return this;
    }

}