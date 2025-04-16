package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.testng.Assert;

public class RentalsPage {

    private Driver driver;
    public RentalsPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************Assertion*******************************************/
    @Step("CheckThatUrlOfRentalsToolsPageIsCorrect")
    public RentalsPage CheckThatUrlOfRentalsToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/rentals");
        return this;
    }

}
