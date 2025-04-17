package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OtherPage {

    private Driver driver;
    public OtherPage(Driver driver) {
        this.driver = driver;
    }


    By OtherToolHeader = By.xpath("//h2[@data-test='page-title' and text()='Category: Other']\n");
    String OtherToolTitle = "Category: Other";

    /****************************************Assertion*******************************************/


    @Step("CheckThatUrlOfOtherToolsPageIsCorrect")
    public OtherPage CheckThatUrlOfOtherToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/other");
        return this;
    }

    @Step(" Check That Text Of Other Tools Is Found ")
    public OtherPage CheckThatTextOfOtherToolsIsFound(){

        Assert.assertEquals(driver.element().getTextOf(OtherToolHeader), OtherToolTitle);
        return this;
    }
}
