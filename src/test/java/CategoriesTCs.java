import Pages.CategoriesPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class CategoriesTCs {

    WebDriver driver ;
    private CategoriesPages categoriesPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicesoftwaretesting.com");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void handTools() {
        categoriesPage =new CategoriesPages(driver);
        categoriesPage.CheckThatHandToolsPageIsLoadedSuccessfully();
        categoriesPage.CheckThatUrlOfHandToolsPageIsCorrect();

    }

    @Test(priority = 2)
    public void powerTools() {
        categoriesPage =new CategoriesPages(driver);
        categoriesPage.CheckThatPowerToolsPageIsLoadedSuccessfully();
        categoriesPage.CheckThatUrlOfPowerToolsPageIsCorrect();

    }


    @Test(priority = 3)
    public void other() {
        categoriesPage =new CategoriesPages(driver);
        categoriesPage.CheckThatOtherToolsPageIsLoadedSuccessfully();
        categoriesPage.CheckThatUrlOfOtherToolsPageIsCorrect();
    }

    @Test(priority = 4)
    public void specialTools() {
        categoriesPage =new CategoriesPages(driver);
        categoriesPage.CheckThatSpecialToolsPageIsLoadedSuccessfully();
        categoriesPage.CheckThatUrlOfSpecialToolsPageIsCorrect();

    }

    @Test(priority = 5)
    public void rentals() {
        categoriesPage =new CategoriesPages(driver);
        categoriesPage.CheckThatRentalsToolsPageIsLoadedSuccessfully();
        categoriesPage.CheckThatUrlOfRentalsToolsPageIsCorrect();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
