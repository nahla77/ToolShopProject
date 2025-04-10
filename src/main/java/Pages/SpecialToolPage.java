package Pages;

import DriverFactory.Driver;
import org.testng.Assert;

public class SpecialToolPage {

    private Driver driver;
    public SpecialToolPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/

    public SpecialToolPage CheckThatUrlOfSpecialToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/special-tools");
        return this;
    }
}
