package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.testng.Assert;

public class SpecialToolPage {

    private Driver driver;
    public SpecialToolPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/

    @Step("CheckThatUrlOfSpecialToolsPageIsCorrect")
    public SpecialToolPage CheckThatUrlOfSpecialToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/special-tools");
        return this;
    }
}
