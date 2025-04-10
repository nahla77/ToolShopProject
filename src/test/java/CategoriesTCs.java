import DriverFactory.Driver;
import Pages.HomePage;
import org.testng.annotations.*;

public class CategoriesTCs {

    public ThreadLocal<Driver> driver;
    private HomePage homePage;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://practicesoftwaretesting.com/");
    }

    @Test(priority = 1)
    public void handTools() {
        new HomePage(driver.get()).CheckThatURLofHomePageIsCorrect()
                .CheckThatHandToolsPageIsLoadedSuccessfully()
                .CheckThatUrlOfHandToolsPageIsCorrect();
    }

    @Test(priority = 2)
    public void powerTools() {
        new HomePage(driver.get()).CheckThatURLofHomePageIsCorrect()
                .CheckThatPowerToolsPageIsLoadedSuccessfully()
                .CheckThatUrlOfPowerToolsPageIsCorrect();

    }


    @Test(priority = 3)
    public void other() {
        new HomePage(driver.get()).CheckThatURLofHomePageIsCorrect()
                .CheckThatOtherToolsPageIsLoadedSuccessfully()
                .CheckThatUrlOfOtherToolsPageIsCorrect();
    }

    @Test(priority = 4)
    public void specialTools() {
        new HomePage(driver.get()).CheckThatURLofHomePageIsCorrect()
                .CheckThatSpecialToolsPageIsLoadedSuccessfully()
                .CheckThatUrlOfSpecialToolsPageIsCorrect();;

    }

    @Test(priority = 5)
    public void rentals() {
        new HomePage(driver.get()).CheckThatURLofHomePageIsCorrect()
                .CheckThatRentalsToolsPageIsLoadedSuccessfully()
                .CheckThatUrlOfRentalsToolsPageIsCorrect();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}