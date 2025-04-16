import DriverFactory.Driver;
import Pages.FiltersPage;
import Pages.HomePage;
import Pages.LanguageTest;
import org.testng.annotations.*;
import utilities.PropertiesManager;

import static Pages.LanguageTest.*;

public class LanguageTest {
    public ThreadLocal<Driver> driver;
     private LanguageTest languageTest;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test
    public void testSwitchToGerman(){
        new LanguageTest(driver.get()).clickLanguageDropdown()
                .selectLanguage(DN_options)
                .assertSortLabelTextIs("Sortieren");
    }
    @Test
    public void testSwitchToEnglish(){
        new LanguageTest(driver.get()).clickLanguageDropdown()
                .selectLanguage(EN_options)
                .assertSortLabelTextIs("Sort");
    }
    @Test
    public void testSwitchToSpanish(){
        new LanguageTest(driver.get()).clickLanguageDropdown()
                .selectLanguage(ES_options)
                .assertSortLabelTextIs("Ordenar");
    }
    @Test
    public void testSwitchToFrench(){
        new LanguageTest(driver.get()).clickLanguageDropdown()
                .selectLanguage(FR_options)
                .assertSortLabelTextIs("Trier");
    }
    @Test
    public void testSwitchToDutch() {
        new LanguageTest(driver.get())
                .clickLanguageDropdown()
                .selectLanguage(NL_options)
                .assertSortLabelTextIs("Sorteren");
    }
    @Test
    public void testSwitchToTurkish(){
        new LanguageTest(driver.get()).clickLanguageDropdown()
                .selectLanguage(TR_options)
                .assertSortLabelTextIs("Sırala");
    }
    @Test
    public void testFrenchLanguagePersistsAfterRefresh() {
        new LanguageTest(driver.get())
                .clickLanguageDropdown()
                .selectLanguage(FR_options)
                .verifyLanguagePersistsAfterRefresh("Trier");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }

}
