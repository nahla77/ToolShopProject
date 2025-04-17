package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PowerToolPage {

    private Driver driver;

    public PowerToolPage(Driver driver) {
        this.driver = driver;
    }


    By PowerToolHeader = By.xpath("//h2[@data-test='page-title' and text()='Category: Power Tools']\n");
    String PowerToolTitle = "Category: Power Tools";

    /****************************************Assertion*******************************************/


    @Step("CheckThatUrlOfPowerToolsPageIsCorrect")
    public PowerToolPage CheckThatUrlOfPowerToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/power-tools");
        return this;
    }

    @Step(" Check That Text Of Power Tools Is Found ")
    public PowerToolPage CheckThatTextOfPowerToolsIsFound(){

        Assert.assertEquals(driver.element().getTextOf(PowerToolHeader), PowerToolTitle);
        return this;
    }

}
