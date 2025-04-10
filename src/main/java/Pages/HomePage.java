package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HomePage {
    private Driver driver;
    public HomePage(Driver driver) {
        this.driver = driver;
    }

    By Categories = (By.cssSelector("a[data-test='nav-categories']"));
    By HandTools = (By.cssSelector("a[data-test='nav-hand-tools']"));
    By PowerTools = (By.cssSelector("a[data-test='nav-power-tools']"));
    By Other = (By.cssSelector("a[data-test='nav-other']"));
    By SpecialTools = (By.cssSelector("a[data-test='nav-special-tools']"));
    By Rentals = (By.cssSelector("a[data-test='nav-rentals']"));
    By ContactLink = (By.xpath("//a[@href=\"/contact\"]"));

    /****************************************Assertion*******************************************/

    public HomePage CheckThatURLofHomePageIsCorrect(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://practicesoftwaretesting.com/");
        return this;
    }
    public HomePage checkThatContactLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(ContactLink));
        return this;
    }

    /**********************Actions**************************************************************/


    public HandToolPage CheckThatHandToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(HandTools);
        return new HandToolPage(driver);
    }

    public PowerToolPage CheckThatPowerToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(PowerTools);
        return new PowerToolPage(driver);
    }
    public OtherPage CheckThatOtherToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(Other);
        return new OtherPage(driver);
    }
    public SpecialToolPage CheckThatSpecialToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(SpecialTools);
        return new SpecialToolPage(driver);
    }
    public RentalsPage CheckThatRentalsToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(Rentals);
        return new RentalsPage(driver);
    }
    public ContactPage clickOnContactLink(){
        driver.element().click(ContactLink);
        return new ContactPage(driver);
    }
    public HomePage verifyAllLinksAreWorking() {
        List<WebElement> allLinks = driver.browser().findElements(By.tagName("a"));

        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");

            if (url == null || url.isEmpty() || url.startsWith("javascript")) {

                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    Assert.assertTrue(responseCode < 400, "Broken link found: " + url + " (code: " + responseCode + ")");

                } catch (Exception e) {
                    Assert.fail("Exception while checking link: " + url + " → " + e.getMessage());
                }
            }

            System.out.println(" All links are valid.");
            return this;
        }
        return null;
    }


}
