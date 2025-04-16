
import DriverFactory.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.HomePage;
import utilities.PropertiesManager;

public class HomePageTest {

    public ThreadLocal<Driver> driver;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test
    public void testAllLinksOnHomePage() {

         new HomePage(driver.get()).verifyAllLinksAreWorking();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
