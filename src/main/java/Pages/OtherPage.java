package Pages;

import DriverFactory.Driver;
import org.testng.Assert;

public class OtherPage {

    private Driver driver;
    public OtherPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/

    public OtherPage CheckThatUrlOfOtherToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/other");
        return this;
    }
}
