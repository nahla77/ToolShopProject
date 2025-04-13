package Pages;

import DriverFactory.Driver;
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
   public void assertFooterIsDisplayed() {
       Assert.assertTrue(driver.element().isDisplayed(footer), "Footer is not visible");
   }
    public void assertGitHubLinkVisibleAndCorrect() {
        Assert.assertTrue(driver.element().isDisplayed(githubLink), "GitHub link is not visible");
        Assert.assertEquals(
                driver.get().findElement(githubLink).getAttribute("href"),
                "https://github.com/testsmith-io/practice-software-testing",
                "GitHub link href is incorrect"
        );
    }
    public void assertPrivacyPolicyVisible() {
        Assert.assertTrue(driver.element().isDisplayed(privacyPolicyLink), "Privacy Policy link is not visible");
    }
    public void assertDemoTextVisible() {
        Assert.assertTrue(driver.element().isDisplayed(demoText), "Demo text is not visible");
    }
    //Actions
    public void scrollToFooter() {
        driver.element().ScrollToElement(footer); // أو By.tagName("app-footer") لو تفضلتي
    }
    //all method
    public void assertAllFooterElements() {
        scrollToFooter();
        assertFooterIsDisplayed();
        assertGitHubLinkVisibleAndCorrect();
        assertPrivacyPolicyVisible();
        assertDemoTextVisible();
    }




}
