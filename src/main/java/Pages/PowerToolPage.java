package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.testng.Assert;

public class PowerToolPage {

    private Driver driver;

    public PowerToolPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/
    @Step("CheckThatUrlOfPowerToolsPageIsCorrect")
    public PowerToolPage CheckThatUrlOfPowerToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/power-tools");
        return this;
    }

}
