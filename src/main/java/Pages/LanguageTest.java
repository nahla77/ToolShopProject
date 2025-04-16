package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LanguageTest {
    private Driver driver;

    public LanguageTest(Driver driver) {
        this.driver = driver;
    }

    //locators
    By languageDropdown = By.id("language");
    //عشان اقدر استدعيها في صغحة التيست public static final
    public static final By DN_options = By.xpath("//a[@data-test=\"lang-de\"]");
    public static final By EN_options = By.xpath("//a[@data-test=\"lang-en\"]");
    public static final   By ES_options = By.xpath("//a[@data-test=\"lang-es\"]");
    public static final  By FR_options = By.xpath("//a[@data-test=\"lang-fr\"]");
    public static final By NL_options = By.xpath("//a[@data-test=\"lang-nl\"]");
    public static final By TR_options = By.xpath("//a[@data-test=\"lang-tr\"]");
    By SortText = By.className("grid-title");


    /****************************************Actions*******************************************/

    public LanguageTest clickLanguageDropdown(){
    driver.element().click(languageDropdown);
    return this;
}
    public LanguageTest selectLanguage(By languageOption) {
        driver.element().click(languageOption);
        return this;
    }


/****************************************Assertions*******************************************/
public String getSortText() {
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SortText));
    return element.getText();// بترجع النص الموجود
}
//Assertion on word "sort"
public LanguageTest assertSortLabelTextIs(String expectedText) {
        String actual = getSortText(); // بيجيب النص من h4.grid-title
        Assert.assertEquals(actual.trim(), expectedText, " Sort label text is not as expected");
        return this;
    }
public LanguageTest verifyLanguagePersistsAfterRefresh(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SortText));
        String beforeRefresh = getSortText();

        // نعمل ريفريش
        driver.get().navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(SortText));
        String afterRefresh = getSortText();

        // نتأكد إن النص ما اتغيرش بعد الريفريش
        Assert.assertEquals(afterRefresh.trim(), expectedText,
                "Language setting did not persist after refresh!");

        return this;
    }

}

