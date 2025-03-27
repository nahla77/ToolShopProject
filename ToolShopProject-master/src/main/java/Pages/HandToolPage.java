package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HandToolPage {
    private Driver driver;

    public HandToolPage(Driver driver) {
        this.driver = driver;
    }


    /****************************************Assertion*******************************************/

    public HandToolPage CheckThatUrlOfHandToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/hand-tools");
        return this;
    }

    /**********************Actions**************************************************************/



}
