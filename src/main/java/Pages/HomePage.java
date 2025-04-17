package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
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
    By AddToCartButton = By.id("btn-add-to-cart");
    By clickOnCombinationPliers = By.xpath("//img[@alt='Combination Pliers']");
    By ShopCartButton=By.id("lblCartCount");
    By SigninLink = By.xpath("//a[@href=\"/auth/login\"]");

    /****************************************Assertion*******************************************/
    @Step("CheckThatURLofHomePageIsCorrect")
    public HomePage CheckThatURLofHomePageIsCorrect(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://practicesoftwaretesting.com/");
        return this;
    }
    @Step("checkThatContactLinkShouldBeDisplayed")
    public HomePage checkThatContactLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(ContactLink));
        return this;
    }

    /**********************Actions**************************************************************/
    @Step("clickOnCombinationPliersIcon")
    public HomePage clickOnCombinationPliersIcon() {
        new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clickOnCombinationPliers))
                .click();

        return new HomePage(driver);
    }
    @Step("ClickOnSigninLink")
    public RegistrationPage ClickOnSigninLink(){
        driver.element().click(SigninLink);
        return new RegistrationPage(driver);
    }
    @Step("clickOnShoppingCartIconAction")
    public ShoppingCart clickOnShoppingCartIconAction() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ShopCartButton));
driver.element().click(ShopCartButton);


        return new ShoppingCart(driver);
    }
    @Step("ClickOnAddToCartButtonAction")
    public HomePage ClickOnAddToCartButtonAction() {
       driver.element().click(AddToCartButton);

        return this;
    }

    //moataz
    @Step("CheckThatHandToolsPageIsLoadedSuccessfully")
    public HandToolPage CheckThatHandToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(HandTools);
        return new HandToolPage(driver);
    }
    @Step("CheckThatPowerToolsPageIsLoadedSuccessfully")
    public PowerToolPage CheckThatPowerToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(PowerTools);
        return new PowerToolPage(driver);
    }
    @Step("CheckThatOtherToolsPageIsLoadedSuccessfully")
    public OtherPage CheckThatOtherToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(Other);
        return new OtherPage(driver);
    }
    @Step("CheckThatSpecialToolsPageIsLoadedSuccessfully")
    public SpecialToolPage CheckThatSpecialToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(SpecialTools);
        return new SpecialToolPage(driver);
    }
    @Step("CheckThatRentalsToolsPageIsLoadedSuccessfully")
    public RentalsPage CheckThatRentalsToolsPageIsLoadedSuccessfully(){
        driver.element().click(Categories);
        driver.element().click(Rentals);
        return new RentalsPage(driver);
    }
    @Step("clickOnContactLink")
    public ContactPage clickOnContactLink(){
        driver.element().click(ContactLink);
        return new ContactPage(driver);
    }
    //Asmaa
    @Step("verifyAllLinksAreWorking")
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
