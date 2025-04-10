import DriverFactory.Driver;
import Pages.ContactPage;
import Pages.HomePage;
import org.testng.annotations.*;

public class ContactPageTCs {
    public ThreadLocal<Driver> driver;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://practicesoftwaretesting.com/");
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
