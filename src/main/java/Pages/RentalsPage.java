package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RentalsPage {

    private Driver driver;
    public RentalsPage(Driver driver) {
        this.driver = driver;
    }

    By RentalToolHeader = By.xpath("//h1[@data-test='page-title' and text()='Rentals']\n");
    String RentalToolTitle = "Rentals";

    /****************************************Assertion*******************************************/

    @Step("CheckThatUrlOfRentalsToolsPageIsCorrect")
    public RentalsPage CheckThatUrlOfRentalsToolsPageIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/rentals");
        return this;
    }

    @Step(" Check That Text Of Rental Tools Is Found ")
    public RentalsPage CheckThatTextOfRentalToolsIsFound(){

        Assert.assertEquals(driver.element().getTextOf(RentalToolHeader), RentalToolTitle);
        return this;
    }

}
