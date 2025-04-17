package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FooterSection {
    private Driver driver;

    public FooterSection(Driver driver) {
        this.driver = driver;
    }

    //Locator
    By footer = By.xpath("//app-footer");
    By githubLink =By.partialLinkText("GitHub repo");
    By privacyPolicyLink = By.linkText("Privacy Policy");
    By demoText = By.xpath("//*[contains(text(),'This is a DEMO application')]");
   /************Assertion*************/
   @Step("assertFooterIsDisplayed")
   public void assertFooterIsDisplayed() {
       Assert.assertTrue(driver.element().isDisplayed(footer), "Footer is not visible");
   }
    @Step("assertGitHubLinkVisibleAndCorrect")
    public void assertGitHubLinkVisibleAndCorrect() {
        Assert.assertTrue(driver.element().isDisplayed(githubLink), "GitHub link is not visible");
        Assert.assertEquals(
                driver.get().findElement(githubLink).getAttribute("href"),
                "https://github.com/testsmith-io/practice-software-testing",
                "GitHub link href is incorrect"
        );
    }
    @Step("assertPrivacyPolicyVisible")
    public void assertPrivacyPolicyVisible() {
        Assert.assertTrue(driver.element().isDisplayed(privacyPolicyLink), "Privacy Policy link is not visible");
    }
    @Step("assertDemoTextVisible")
    public void assertDemoTextVisible() {
        Assert.assertTrue(driver.element().isDisplayed(demoText), "Demo text is not visible");
    }
    //Actions
    @Step("scrollToFooter")
    public void scrollToFooter() {
        driver.element().ScrollToElement(footer); // أو By.tagName("app-footer") لو تفضلتي
    }
    //all method
    @Step("assertAllFooterElements")
    public void assertAllFooterElements() {
        scrollToFooter();
        assertFooterIsDisplayed();
        assertGitHubLinkVisibleAndCorrect();
        assertPrivacyPolicyVisible();
        assertDemoTextVisible();
    }




}
