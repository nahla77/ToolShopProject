package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FiltersPage {

    private Driver driver;

    public FiltersPage(Driver driver) {
        this.driver = driver;
    }

    /*********************** Locators *************************/
    By searchInput = By.id("search");
    By searchButton = By.xpath("//button[text()='Search']");
    By cardTitles = By.cssSelector(".card-title");
    By sawCheckBox = By.xpath("//label[contains(text(), 'Power Tools')]/following::div[contains(., 'Saw')][1]//input") ;

    /********************** Actions ***************************/

    @Step("filterByCategory")
    public FiltersPage filterByCategory(String categoryName) {
        By categoryCheckbox = By.xpath("//label[contains(text(),'" + categoryName + "')]");
        driver.element().click(categoryCheckbox);
        driver.browser().sleep(2000);
        return this;
    }
    @Step("clickOnSawFilter")
    public FiltersPage clickOnSawFilter(){
        driver.element().click(sawCheckBox);
        driver.browser().sleep(2000);
        return this;
    }

    @Step("filterByBrand")
    public FiltersPage filterByBrand(String brandName) {
        By brandCheckbox = By.xpath("//label[contains(text(),'" + brandName + "')]");
        driver.element().click(brandCheckbox);
        driver.browser().sleep(2000);
        return this;
    }

    @Step("searchFor(String keyword)")
    public FiltersPage searchFor(String keyword) {
        driver.element().type(searchInput, keyword);
        driver.element().click(searchButton);
        driver.browser().sleep(2000);
        return this;
    }

    /********************** Assertions ***************************/
    @Step("checkThatURLIsCorrect")
    public FiltersPage checkThatURLIsCorrect(String expectedUrl) {
        String currentUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(currentUrl, expectedUrl);
        return this;
    }
    @Step("checkThatResultsContain")
    public FiltersPage checkThatResultsContain(String keyword) {
        List<WebElement> items = driver.browser().findElements(cardTitles);
        for (WebElement item : items) {
            Assert.assertTrue(item.getText().toLowerCase().contains(keyword.toLowerCase()),
                    "Item doesn't match the keyword: " + item.getText());
        }
        return this;
    }
    @Step("assertNoResultsAreShown")
    public FiltersPage assertNoResultsAreShown() {
        List<WebElement> products = driver.get().findElements(By.cssSelector(".product-name")); // أو الكلاس اللي بيظهر فيه اسم المنتجات

        System.out.println("🔍 Found " + products.size() + " item(s) after filtering.");

        Assert.assertEquals(products.size(), 0, "❌ Expected no results, but some products appeared.");

        return this;
    }

    @Step("checkThatAtLeastOneResultExists")
    public FiltersPage checkThatAtLeastOneResultExists() {
        List<WebElement> items = driver.browser().findElements(cardTitles);
        Assert.assertTrue(items.size() > 0, "No items found.");
        return this;
    }



}

