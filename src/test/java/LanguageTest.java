import DriverFactory.Driver;
import Pages.LanguagePage;
import org.testng.annotations.*;
import utilities.PropertiesManager;

import static Pages.LanguagePage.*;

public class LanguageTest {
    public ThreadLocal<Driver> driver;
     private LanguagePage languageTest;

    @BeforeMethod
    public void setup() {
        driver = new ThreadLocal<>();
        PropertiesManager.initializeProperties();
        driver.set(new Driver());
    }

    @Test
    public void testSwitchToGerman(){
        new LanguagePage(driver.get()).clickLanguageDropdown()
                .selectLanguage(DN_options)
                .assertSortLabelTextIs("Sortieren");
    }
    @Test
    public void testSwitchToEnglish(){
        new LanguagePage(driver.get()).clickLanguageDropdown()
                .selectLanguage(EN_options)
                .assertSortLabelTextIs("Sort");
    }
    @Test
    public void testSwitchToSpanish(){
        new LanguagePage(driver.get()).clickLanguageDropdown()
                .selectLanguage(ES_options)
                .assertSortLabelTextIs("Ordenar");
    }
    @Test
    public void testSwitchToFrench(){
        new LanguagePage(driver.get()).clickLanguageDropdown()
                .selectLanguage(FR_options)
                .assertSortLabelTextIs("Trier");
    }
    @Test
    public void testSwitchToDutch() {
        new LanguagePage(driver.get())
                .clickLanguageDropdown()
                .selectLanguage(NL_options)
                .assertSortLabelTextIs("Sorteren");
    }
    @Test
    public void testSwitchToTurkish(){
        new LanguagePage(driver.get()).clickLanguageDropdown()
                .selectLanguage(TR_options)
                .assertSortLabelTextIs("Sırala");
    }
    @Test
    public void testFrenchLanguagePersistsAfterRefresh() {
        new LanguagePage(driver.get())
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
