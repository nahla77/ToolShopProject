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

    By HandToolHeader = By.xpath("//h2[@data-test='page-title' and text()='Category: Hand Tools']\n");
    String HandToolTitle = "Category: Hand Tools";


    /****************************************Assertion*******************************************/

    @Step("CheckThatUrlOfHandToolsPageIsCorrect")
    public HandToolPage CheckThatUrlOfHandToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/hand-tools");
        return this;
    }

    @Step(" Check That Text Of Hand Tools Is Found ")
    public HandToolPage CheckThatTextOfHandToolsIsFound(){

        Assert.assertEquals(driver.element().getTextOf(HandToolHeader), HandToolTitle);
        return this;
    }





}
