package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SpecialToolPage {

    private Driver driver;
    public SpecialToolPage(Driver driver) {
        this.driver = driver;
    }


    By SpecialToolHeader = By.xpath("//h2[@data-test='page-title' and text()='Category: Special Tools']\n");
    String SpecialToolTitle = "Category: Special Tools";

    /****************************************Assertion*******************************************/

    @Step("CheckThatUrlOfSpecialToolsPageIsCorrect")
    public SpecialToolPage CheckThatUrlOfSpecialToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/special-tools");
        return this;
    }

    @Step(" Check That Text Of Special Tools Is Found ")
    public SpecialToolPage CheckThatTextOfSpecialToolsIsFound(){

        Assert.assertEquals(driver.element().getTextOf(SpecialToolHeader), SpecialToolTitle);
        return this;
    }
}
