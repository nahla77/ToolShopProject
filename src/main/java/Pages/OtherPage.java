package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.testng.Assert;

public class OtherPage {

    private Driver driver;
    public OtherPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/
    @Step("CheckThatUrlOfOtherToolsPageIsCorrect")
    public OtherPage CheckThatUrlOfOtherToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/other");
        return this;
    }
}
