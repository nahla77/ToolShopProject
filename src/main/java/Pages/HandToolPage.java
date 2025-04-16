package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HandToolPage {
    private Driver driver;

    public HandToolPage(Driver driver) {
        this.driver = driver;
    }


    /****************************************Assertion*******************************************/
    @Step("CheckThatUrlOfHandToolsPageIsCorrect")
    public HandToolPage CheckThatUrlOfHandToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/hand-tools");
        return this;
    }

    /**********************Actions**************************************************************/



}
