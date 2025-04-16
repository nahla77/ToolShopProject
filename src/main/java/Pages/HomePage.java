package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
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
    By clickOnShoppingCartIcon = By.xpath("//a[@data-test='nav-cart']");
    By clickOnCombinationPliers = By.xpath("//img[@alt='Combination Pliers']");
    By ClickOnAddToCartButton= By.xpath("//button[@data-test='add-to-cart']");
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
    public HomePage clickOnCombinationPliersIcon() {
        new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clickOnCombinationPliers))
                .click();

        return new HomePage(driver);
    }

    public ShoppingCart clickOnShoppingCartIconAction() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
        By cartIconLocator = By.xpath("//a[@data-test='nav-cart']");

        // 1. انتظار اختفاء أي توست أو overlay بيغطي العنصر
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'toast') or contains(@class,'overlay')]")));
            System.out.println("Toast أو Overlay اختفى");
        } catch (Exception e) {
            System.out.println("لم يظهر Toast أو Overlay");
        }

        // 2. انتظار العنصر يكون ظاهر وقابل للضغط
        WebElement cartIcon = wait.until(ExpectedConditions.presenceOfElementLocated(cartIconLocator));
        wait.until(ExpectedConditions.elementToBeClickable(cartIconLocator));

        // 3. Scroll إليه للتأكد من أنه داخل الشاشة
        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].scrollIntoView(true);", cartIcon);

        // 4. حاول تضغط بشكل طبيعي، ولو فشل جرب JavaScript click
        try {
            cartIcon.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("الزر متغطي، هيتم استخدام JavaScript للضغط.");
            ((JavascriptExecutor) driver.get()).executeScript("arguments[0].click();", cartIcon);
        }

        System.out.println("تم الضغط على أيقونة السلة");

        return new ShoppingCart(driver);
    }
    public HomePage ClickOnAddToCartButtonAction() {
        By addToCartBtn = By.xpath("//button[@data-test='add-to-cart']");

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        System.out.println("Scorlling to element" + addToCartBtn);
        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].scrollIntoView(true);", driver.get().findElement(addToCartBtn));

        driver.get().findElement(addToCartBtn).click();

        return this;
    }

    //moataz
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
    //Asmaa
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
//    public HomePage verifyAllLinksAreWorkingWell() {
//        List<WebElement> allLinks = driver.browser().findElements(By.tagName("a"));
//        for (WebElement link : allLinks) {
//            String url = link.getAttribute("href");
//
//            if (url != null && !url.isEmpty() && !url.startsWith("javascript")) {
//                try {
//                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//                    connection.setRequestMethod("HEAD");
//                    connection.connect();
//
//                    int responseCode = connection.getResponseCode();
//                    Assert.assertTrue(responseCode < 400, " Broken link found: " + url + " (code: " + responseCode + ")");
//                } catch (Exception e) {
//                    Assert.fail(" Exception while checking link: " + url + " → " + e.getMessage());
//                }
//            }
//        }
//
//        System.out.println(" All links are valid.");
//        return this;
//
//    }

}
