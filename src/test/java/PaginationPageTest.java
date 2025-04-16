import DriverFactory.Driver;
import Pages.PaginationPage;
import org.testng.annotations.*;
import utilities.PropertiesManager;

public class PaginationPageTCs {
    public ThreadLocal<Driver> driver;
    private PaginationPage paginationPage;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test(priority = 1)
    public void userCanNavigateToPage2() {
        new PaginationPage(driver.get())
                .clickOnPageNumber("2")
                .checkThatPageIsActive("2")
                .checkThatProductsAreVisible();
    }

    @Test(priority = 2)
    public void userCanNavigateToPage3() {
        new PaginationPage(driver.get())
                .clickOnPageNumber("3")
                .checkThatPageIsActive("3")
                .checkThatProductsAreVisible();
    }
    @Test(priority = 3)
    public void userCanNavigateToPage4() {
        new PaginationPage(driver.get())
                .clickOnPageNumber("4")
                .checkThatPageIsActive("4")
                .checkThatProductsAreVisible();
    }
    @Test(priority = 4)
    public void userCanNavigateToPage5() {
        new PaginationPage(driver.get())
                .clickOnPageNumber("5")
                .checkThatPageIsActive("5")
                .checkThatProductsAreVisible();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.get().Quit();
    }
}

