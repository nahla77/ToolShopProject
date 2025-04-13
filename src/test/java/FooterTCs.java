import DriverFactory.Driver;
import Pages.FooterSection;
import org.testng.annotations.*;

public class FooterTCs {
    public ThreadLocal<Driver> driver;
    private FooterSection footerSection;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://practicesoftwaretesting.com/");
        footerSection = new FooterSection(driver.get());

    }
    @Test
    public void testFooterElements() {
        footerSection.assertAllFooterElements();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
