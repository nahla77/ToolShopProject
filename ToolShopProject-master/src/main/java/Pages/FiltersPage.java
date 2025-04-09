package Pages;

import DriverFactory.Driver;
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

    /********************** Actions ***************************/

    public FiltersPage filterByCategory(String categoryName) {
        By categoryCheckbox = By.xpath("//label[contains(text(),'" + categoryName + "')]");
        driver.element().click(categoryCheckbox);
        driver.browser().sleep(2000);
        return this;
    }

    public FiltersPage filterByBrand(String brandName) {
        By brandCheckbox = By.xpath("//label[contains(text(),'" + brandName + "')]");
        driver.element().click(brandCheckbox);
        driver.browser().sleep(2000);
        return this;
    }

    public FiltersPage searchFor(String keyword) {
        driver.element().type(searchInput, keyword);
        driver.element().click(searchButton);
        driver.browser().sleep(2000);
        return this;
    }

    /********************** Assertions ***************************/

    public FiltersPage checkThatURLIsCorrect(String expectedUrl) {
        String currentUrl = driver.browser().getCurrentURL();
        Assert.assertEquals(currentUrl, expectedUrl);
        return this;
    }

    public FiltersPage checkThatResultsContain(String keyword) {
        List<WebElement> items = driver.browser().findElements(cardTitles);
        for (WebElement item : items) {
            Assert.assertTrue(item.getText().toLowerCase().contains(keyword.toLowerCase()),
                    "Item doesn't match the keyword: " + item.getText());
        }
        return this;
    }

    public FiltersPage checkThatAtLeastOneResultExists() {
        List<WebElement> items = driver.browser().findElements(cardTitles);
        Assert.assertTrue(items.size() > 0, "No items found.");
        return this;
    }
}

