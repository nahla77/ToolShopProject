import DriverFactory.Driver;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class FullShoppingCartTC {
    public ThreadLocal<Driver> driver;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://practicesoftwaretesting.com/");
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
