import DriverFactory.Driver;
import Pages.Languagetest;
import org.testng.annotations.*;
import utilities.PropertiesManager;

import static Pages.Languagetest.*;

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
        new Languagetest(driver.get()).clickLanguageDropdown()
                .selectLanguage(DN_options)
                .assertSortLabelTextIs("Sortieren");
    }
    @Test
    public void testSwitchToEnglish(){
        new Languagetest(driver.get()).clickLanguageDropdown()
                .selectLanguage(EN_options)
                .assertSortLabelTextIs("Sort");
    }
    @Test
    public void testSwitchToSpanish(){
        new Languagetest(driver.get()).clickLanguageDropdown()
                .selectLanguage(ES_options)
                .assertSortLabelTextIs("Ordenar");
    }
    @Test
    public void testSwitchToFrench(){
        new Languagetest(driver.get()).clickLanguageDropdown()
                .selectLanguage(FR_options)
                .assertSortLabelTextIs("Trier");
    }
    @Test
    public void testSwitchToDutch() {
        new Languagetest(driver.get())
                .clickLanguageDropdown()
                .selectLanguage(NL_options)
                .assertSortLabelTextIs("Sorteren");
    }
    @Test
    public void testSwitchToTurkish(){
        new Languagetest(driver.get()).clickLanguageDropdown()
                .selectLanguage(TR_options)
                .assertSortLabelTextIs("Sırala");
    }
    @Test
    public void testFrenchLanguagePersistsAfterRefresh() {
        new Languagetest(driver.get())
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
