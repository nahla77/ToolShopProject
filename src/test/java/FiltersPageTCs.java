import BrowserActions.browserActions;
import DriverFactory.Driver;
import Pages.FiltersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class FiltersPageTCs {

    public ThreadLocal<Driver> driver;
    private FiltersPage filtersPage;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        browserActions browserActions = driver.get().browser().navigateToURL("https://practicesoftwaretesting.com/");
        filtersPage = new FiltersPage((Driver) driver.get());
    }

    @Test(priority = 1)
    public void filterByCategoryHammer() {
        filtersPage
                .checkThatURLIsCorrect("https://practicesoftwaretesting.com/")
                .filterByCategory("Hammer")
                .checkThatResultsContain("hammer");
    }

    @Test(priority = 2)
    public void filterByCategoryHandSaw() {
          filtersPage
                .filterByCategory("Hand Saw")
                .checkThatResultsContain("saw");
    }


    @Test(priority = 3)
    public void filterByCategoryWrench() {
        filtersPage
                .filterByCategory("Wrench")
                .checkThatResultsContain("wrench");
    }

    @Test(priority = 4)
    public void filterByCategoryScrewdriver() {
        filtersPage
                .filterByCategory("Screwdriver")
                .checkThatResultsContain("screwdriver");
    }

    @Test(priority = 5)
    public void filterByCategoryPliers() {
        filtersPage
                .filterByCategory("Pliers")
                .checkThatResultsContain("pliers");
    }

    @Test(priority = 6)
    public void filterByCategoryChisels() {
        filtersPage
                .filterByCategory("Chisels")
                .checkThatResultsContain("chisel");
    }

    @Test(priority = 7)
    public void filterByCategoryMeasures() {
        filtersPage
                .filterByCategory("Measures")
                .checkThatResultsContain("measure");
    }
    @Test(priority = 8)
    public void filterByCategoryPowerTools() {
        filtersPage
                .filterByCategory("Grinder")
                .assertNoResultsAreShown()
                .filterByCategory("Sander")
                .checkThatResultsContain("Sander")
                .clickOnSawFilter()
                .checkThatResultsContain("Saw")
                .filterByCategory("Drill")
                .checkThatResultsContain(" Drill")
        ;
    }
    @Test(priority = 9)
    public void filterByCategoryOther(){
        filtersPage
                .filterByBrand("Tool Belts")
                .checkThatResultsContain("toolbelt")
                .filterByCategory("Storage Solutions")
                .checkThatResultsContain("Tool")
                .filterByCategory("Workbench")
                .filterByCategory("Safety Gear")
                .checkThatResultsContain("Protection")
                .filterByCategory("Fasteners")
                .checkThatResultsContain("Nuts");
    }

    @Test(priority = 10)
    public void filterByBrand(){
        filtersPage.filterByBrand("ForgeFlex Tools")
                .checkThatResultsContain("Hammer")
                .filterByBrand(" MightyCraft Hardware")
        ;


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}


