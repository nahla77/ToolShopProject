package ElementActions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class elementActions {

    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    public elementActions(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) this.driver;
    }

    public elementActions click(By locator) {
        System.out.println("Click on: " + locator.toString());

        try {
            driver.findElement(locator).click();
        } catch (ElementClickInterceptedException | NoSuchElementException |
                 StaleElementReferenceException | TimeoutException exception) {
            ScrollToElement(locator);
            ClickUsingJavaScript(locator);
        }
        return this;
    }

    public elementActions ClickUsingJavaScript(By locator) {
        System.out.println("click on " + locator.toString() + " Using JavaScript");
        javascriptExecutor.executeScript("arguments[0].click();", driver.findElement(locator));
        return this;
    }

    public elementActions type(By locator, String text) {
        clearField(locator);
        System.out.println("Fill field: " + locator.toString() + " with: " + text);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public elementActions clearField(By locator) {
        System.out.println("Clear field with locator: " + locator.toString());
        driver.findElement(locator).clear();
        return this;
    }

    public elementActions ScrollToElement(By locator) {
        System.out.println("Scrolling to element " + locator.toString());
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        return this;
    }

    public elementActions selectByIndex(By locator, int index) {
        System.out.println("Selecting Option " + index + " from dropdown: " + locator.toString());
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }

    public elementActions selectByValue(By locator, String value) {
        System.out.println("Selecting Value: " + value + " from dropdown: " + locator.toString());
        new Select(driver.findElement(locator)).selectByValue(value);
        return this;
    }

    public String getTextOf(By locator) {
        System.out.println("Getting text from locator: " + locator.toString());
        return driver.findElement(locator).getText();
    }

    public Boolean isDisplayed(By locator) {
        System.out.println("Checking " + locator.toString().split(":", 2)[1] + " if Displayed");
        return driver.findElement(locator).isDisplayed();
    }

    public Boolean isSelected(By locator) {
        System.out.println("Checking " + locator.toString().split(":", 2)[1] + " if Selected");
        return driver.findElement(locator).isSelected();
    }

    public Boolean isClickable(By locator) {
        System.out.println("Checking " + locator.toString().split(":", 2)[1] + " if Clickable");
        return driver.findElement(locator).isEnabled();
    }

    public List<WebElement> findElements(By allLinks) {
        return driver.findElements(allLinks);
    }
}