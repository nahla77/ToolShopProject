package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LanguagePage {
    private Driver driver;

    public LanguagePage(Driver driver) {
        this.driver = driver;
    }

    //locators
    By languageDropdown = By.id("language");
    //عشان اقدر استدعيها في صغحة التيست public static final
    public static final By DN_options = By.xpath("//a[@data-test=\"lang-de\"]");
    public static final By EN_options = By.xpath("//a[@data-test=\"lang-en\"]");
    public static final By ES_options = By.xpath("//a[@data-test=\"lang-es\"]");
    public static final By FR_options = By.xpath("//a[@data-test=\"lang-fr\"]");
    public static final By NL_options = By.xpath("//a[@data-test=\"lang-nl\"]");
    public static final By TR_options = By.xpath("//a[@data-test=\"lang-tr\"]");
    By SortText = By.className("grid-title");


    /****************************************Actions*******************************************/
    @Step("clickLanguageDropdown")

    public LanguagePage clickLanguageDropdown() {
        driver.element().click(languageDropdown);
        return this;
    }

    @Step("selectLanguage")
    public LanguagePage selectLanguage(By languageOption) {
        driver.element().click(languageOption);
        return this;
    }


    /****************************************Assertions*******************************************/
    @Step("getSortText")
    public String getSortText() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SortText));
        return element.getText();// بترجع النص الموجود
    }

    //Assertion on word "sort"
    @Step("assertSortLabelTextIs")
    public LanguagePage assertSortLabelTextIs(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));

        // استنى لحد ما النص يتغير للي إحنا عايزينه
        boolean textChanged = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h4.grid-title"), expectedText));

        Assert.assertTrue(textChanged, " Text did not update to expected language");

        String actual = getSortText();
        Assert.assertEquals(actual.trim(), expectedText, " Sort label text is not as expected");
        return this;
    }

    @Step("verifyLanguagePersistsAfterRefresh")
    public LanguagePage verifyLanguagePersistsAfterRefresh(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SortText));
        String beforeRefresh = getSortText();

        // نعمل ريفريش
        driver.get().navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(SortText));
        String afterRefresh = getSortText();

        // نتأكد إن النص ما اتغيرش بعد الريفريش
        Assert.assertEquals(afterRefresh.trim(), expectedText, "Language setting did not persist after refresh!");

        return this;
    }

}

