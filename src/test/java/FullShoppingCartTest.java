import DriverFactory.Driver;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.PropertiesManager;

import java.time.Duration;

public class FullShoppingCartTest {
    public ThreadLocal<Driver> driver;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test
    public void demoTest()
    {
        new HomePage(driver.get()).clickOnCombinationPliersIcon().ClickOnAddToCartButtonAction()
                .clickOnShoppingCartIconAction().CheckThatDefinitionOfTheStepsShouldBeDisplayed()
                .CheckThatItemsFieldShouldBeDisplayed().CheckThatItemsStringTitleShouldBeDisplayed()
                .CheckThatItemsFieldShouldBeDisplayed().CheckThatQuantityStringHeaderShouldBeDisplayed()
                .CheckThatQuantityFieldShouldBeDisplayed().CheckThatPriceStringHeaderShouldBeDisplayed()
                .CheckThatPriceFieldShouldBeDisplayed().CheckThatTotalStringHeaderShouldBeDisplayed()
                .CheckThatTotalFieldShouldBeDisplayed().clickOnProceedToCheckoutButton()
                .clickOnRegisterYourAccountButton().fillIncheckoutRegisterPage().clickOnRegisterClickButton()
                .CheckThatLoginStringHeaderShouldBeDisplayed().fillInCheckoutLoginPage()
                .clickOnLoginButton().clickOnHomeIcon().clickOnCombinationPliersIcon().ClickOnAddToCartButtonAction()
                .clickOnShoppingCartIconAction().clickOnProceedToCheckoutButton().fillInCheckoutLoginPage().clickOnLoginButton().clickOnProceedSecondButton()
                .fillInCheckoutBillingAddressPage().clickOnProceedThirdButton()
                .fillInPaymentField().clickOnConfirmButton().CheckThatPaymentSuccessfulMsgShouldBeDisplayed();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
