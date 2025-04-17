import DriverFactory.Driver;
import Pages.HomePage;
import org.testng.annotations.*;
import utilities.PropertiesManager;

public class ContactPageTest {
    public ThreadLocal<Driver> driver;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test(priority = 1)
    public void UserShouldBeNavigatedToContactPage() {
        new HomePage(driver.get())
                .checkThatContactLinkShouldBeDisplayed()
                .clickOnContactLink().checkThatContactPageShouldBeLoadedSuccessfully()
                .CheckThatUrlOfContactPageIsCorrect()
                .fillInContactPageForm()
                .clickOnsendButton()
                .checkThatThanksMessageIsDisplayedSuccessfully();
    }
    @Test(priority = 2)
    public void fillContactFormWithIncorrectData(){
        new HomePage(driver.get())
                .clickOnContactLink()
                .checkThatContactPageShouldBeLoadedSuccessfully()
                .fillInContactFormWithInValidData()
                .clickOnsendButton()
                .verifyErrorMessage();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
