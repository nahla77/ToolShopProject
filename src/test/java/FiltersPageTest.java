import DriverFactory.Driver;
import Pages.FiltersPage;
import org.testng.annotations.*;
import utilities.PropertiesManager;

public class FiltersPageTest {

    public ThreadLocal<Driver> driver;
    private FiltersPage filtersPage;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test(priority = 1)
    public void filterByCategoryHammer() {
        new FiltersPage(driver.get())
                .checkThatURLIsCorrect("https://practicesoftwaretesting.com/")
                .filterByCategory("Hammer")
                .checkThatResultsContain("hammer");
    }

    @Test(priority = 2)
    public void filterByCategoryHandSaw() {
        new FiltersPage(driver.get())
                .filterByCategory("Hand Saw")
                .checkThatResultsContain("saw");
    }


    @Test(priority = 3)
    public void filterByCategoryWrench() {
        new FiltersPage(driver.get())
                .filterByCategory("Wrench")
                .checkThatResultsContain("wrench");
    }

    @Test(priority = 4)
    public void filterByCategoryScrewdriver() {
        new FiltersPage(driver.get())
                .filterByCategory("Screwdriver")
                .checkThatResultsContain("screwdriver");
    }

    @Test(priority = 5)
    public void filterByCategoryPliers() {
        new FiltersPage(driver.get())
                .filterByCategory("Pliers")
                .checkThatResultsContain("pliers");
    }

    @Test(priority = 6)
    public void filterByCategoryChisels() {
        new FiltersPage(driver.get())
                .filterByCategory("Chisels")
                .checkThatResultsContain("chisel");
    }

    @Test(priority = 7)
    public void filterByCategoryMeasures() {
        new FiltersPage(driver.get())
                .filterByCategory("Measures")
                .checkThatResultsContain("measure");
    }
    @Test(priority = 8)
    public void filterByCategoryPowerTools() {
        new FiltersPage(driver.get())
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
        new FiltersPage(driver.get())
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
        new FiltersPage(driver.get()).filterByBrand("ForgeFlex Tools")
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


