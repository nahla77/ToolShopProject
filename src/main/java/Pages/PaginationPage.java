package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class PaginationPage {
    private Driver driver;

    public PaginationPage(Driver driver) {
        this.driver = driver;
    }

    // Locator for active page
    By activePage = By.xpath("//li[@class='page-item active']/a");
    By productCard = By.cssSelector("a[data-test^='product-']");

    // Action: Click on any page number dynamically
    @Step("clickOnPageNumber")
    public PaginationPage clickOnPageNumber(String number) {
        By pageBtn = By.xpath("//a[text()='" + number + "']");
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pageBtn)).click();
        return this;
    }

    // Assertion: Check that the active page number is as expected
    @Step("checkThatPageIsActive")
    public PaginationPage checkThatPageIsActive(String expectedNumber) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        WebElement current = wait.until(ExpectedConditions.visibilityOfElementLocated(activePage));
        String actualNumber = current.getText();
        Assert.assertEquals(actualNumber, expectedNumber, " Page " + expectedNumber + " is not active as expected!");
        return this;
    }
    @Step("checkThatProductsAreVisible")
    public PaginationPage checkThatProductsAreVisible() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        int count = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productCard)).size();
        Assert.assertTrue(count > 0, " No products found on the current page.");
        return this;
    }

}
