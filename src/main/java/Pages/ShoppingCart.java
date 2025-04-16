package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCart {
    //private WebDriver driver;
    private Driver driver;
    private WebDriverWait wait;
    public ShoppingCart(Driver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
    }
    By definitionOfTheSteps= By.xpath("//ul[@class='steps-4 steps-indicator']");
    By ItemsStringHeader = By.xpath("//th[@scope='col' and text()='Item']");
    String ItemsStringTitle="Item";
    By ItemsField=By.xpath("//span[@data-test='product-title']");
    String ItemFieldName= "Combination Pliers";
    By QuantityStringHeader = By.xpath("//th[normalize-space(text())='Quantity']");
    String QuantityStringTitle="Quantity";
    By QuantityField = By.xpath("//input[contains(@id, 'quantity')]"); //replaced
    By priceStingHeader = By.xpath("//th[@scope='col' and text()='Price']");
    String priceStringTitle="Price";
    By priceField= By.xpath("//span[@data-test='product-price']");
    By TotalStringHeader=By.xpath("//th[@scope='col' and text()='Total']");
    String TotalStringTitle="Total";
    By TotalField=By.xpath("//span[@data-test='line-price']");
    By deleteButton=By.xpath("//a[@class='btn btn-danger']");
    By ProceedToCheckoutButton=By.xpath("//button[@data-test='proceed-1']");
    By registerYourAccountButton=By.xpath("//a[@data-test='register-link']");
    By proceedSecondButton = By.xpath("//button[@data-test='proceed-2']");
    By LoginButton= By.xpath("//input[@data-test='login-submit']");
    By EmailAddressField= By.xpath("//input[@data-test='email']");
    By PasswordField= By.xpath("//input[@data-test='password']");

    /*****************************ASSERTIONS*******************/
    public ShoppingCart CheckThatDefinitionOfTheStepsShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

        try {
            WebElement stepsElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//ul[@class='steps-4 steps-indicator']")));

            Assert.assertTrue(stepsElement.isDisplayed(), " عنصر الخطوات غير ظاهر");
            System.out.println(" عنصر الخطوات ظاهر بنجاح");
        } catch (Exception e) {
            System.out.println(" عنصر الخطوات غير موجود أصلاً!");
            throw e; // إعادة رمي الاستثناء عشان التست يفشل فعلاً لو العنصر مش موجود
        }

        return this;
    }

    public ShoppingCart CheckThatItemsStringTitleShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(ItemsStringHeader), ItemsStringTitle);
        return this;
    }
    ///   /////////////////////
    public ShoppingCart CheckThatItemsFieldShouldBeDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));

        try {
            WebElement itemElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(ItemsField)
            );

            String actualText = itemElement.getText().trim();

            Assert.assertTrue(
                    actualText.contains(ItemFieldName),
                    "Expected item name not found in actual text: " + actualText
            );

        } catch (TimeoutException e) {
            Assert.fail("Item field not found within the wait time.");
        }

        return this;
    }

    public ShoppingCart CheckThatQuantityStringHeaderShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element()
                .getTextOf(QuantityStringHeader), QuantityStringTitle);
        return this;
    }
    public ShoppingCart CheckThatQuantityFieldShouldBeDisplayed()
    {
        Assert.assertTrue(driver.element().isDisplayed(QuantityField));
        return this;
    }
    public ShoppingCart CheckThatPriceStringHeaderShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element()
                .getTextOf(priceStingHeader), priceStringTitle);
        return this;
    }
    public ShoppingCart CheckThatPriceFieldShouldBeDisplayed()
    {
        Assert.assertTrue(driver.element().isDisplayed(priceField));
        return this;
    }
    public ShoppingCart CheckThatTotalStringHeaderShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element()
                .getTextOf(TotalStringHeader), TotalStringTitle);
        return this;
    }
    public ShoppingCart CheckThatTotalFieldShouldBeDisplayed()
    {
        Assert.assertTrue(driver.element().isDisplayed(TotalField));
        return this;
    }
    /*****************************Actions********************/
    public ShoppingCart clickOnDeleteButton()
    {
        driver.element().click(deleteButton);
        return new ShoppingCart(driver);
    }
    public ShoppingCart clickOnProceedToCheckoutButton()
    {
        driver.element().click(ProceedToCheckoutButton);
        return new ShoppingCart(driver);
    }
    public checkoutRegisterPage clickOnRegisterYourAccountButton()
    {
        driver.element().click(registerYourAccountButton);
        return new checkoutRegisterPage(driver);
    }
    ////////rep
    public CheckoutBillingAddressPage clickOnProceedSecondButton()
    { WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(proceedSecondButton)).click();
        return new CheckoutBillingAddressPage(driver);
    }
    //added
    public ShoppingCart fillInCheckoutLoginPage() {
        driver.get().findElement(EmailAddressField).sendKeys("souad1515@gmail.com");
        driver.get().findElement(PasswordField).sendKeys("Sa-901234");

        return this;
    }
    //added
    public ShoppingCart clickOnLoginButton()
    {
        driver.get().findElement(LoginButton).click();
        return this;
    }
}
