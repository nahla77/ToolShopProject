import DriverFactory.Driver;
import Pages.FooterSection;
import org.testng.annotations.*;
import utilities.PropertiesManager;

public class FooterTest {
    public ThreadLocal<Driver> driver;
    private FooterSection footerSection;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test
    public void testFooterElements() {

        new FooterSection(driver.get()).assertAllFooterElements();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
