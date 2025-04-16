import DriverFactory.Driver;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.*;
import utilities.PropertiesManager;

public class Registration_LoginTest {
    public ThreadLocal<Driver> driver;

    @BeforeMethod

    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }
    @Test(priority = 1)
    public void UserCanRegistreSuccessfully(){
        new HomePage(driver.get()).ClickOnSigninLink()
                .ClickOnRegistrationFormLink()
                .fillRegisterFormWithValidCredintial()
                .clickOnRegisterButton()
                .AssertThatUserRedirectToLoginPageAfterSuccessfulRegistration();
    }
    @Test(priority = 2)
    public void UserCanLoginSuccessfully(){
        new LoginPage(driver.get()).ClickOnSigninLink()
                .fillInLoginPage()
                .clickOnLoginButton()
                .AssertThatUserLoginSuccessfully();
    }
    @Test(priority = 3)
    public void ClickONForgetPasswordLink(){
        new LoginPage(driver.get())
                .ClickOnSigninLink()
                .ClickOnForgetPasswordLink();

    }
    @Test(priority = 4)
    public void fillRegistrationFormWithIncorrectData(){
        new HomePage(driver.get()).ClickOnSigninLink()
                .ClickOnRegistrationFormLink()
                .fillRegisterFormWithInvalidCredintial()
                .clickOnRegisterButton()
                .verifyErrorMessage();
    }
    @Test(priority = 5)
    public void UserCannotLoginSuccessfully() {
        new LoginPage(driver.get())
                .ClickOnSigninLink()
                .CheckThatLoginStringHeaderShouldBeDisplayed()
                .fillInLoginPageWithInvaildData()
                .clickOnLoginButton()
                .verifyErrorMessage();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
