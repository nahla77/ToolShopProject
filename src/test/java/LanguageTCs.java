import DriverFactory.Driver;
import Pages.FiltersPage;
import Pages.HomePage;
import Pages.LanguageTest;
import org.testng.annotations.*;

import static Pages.LanguageTest.*;

public class LanguageTCs {
    public ThreadLocal<Driver> driver;
    LanguageTest languageTest;

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://practicesoftwaretesting.com/");
        languageTest = new LanguageTest(driver.get());
    }
    @Test
    public void testSwitchToGerman(){
        languageTest.clickLanguageDropdown()
                .selectLanguage(DN_options)
                .assertSortLabelTextIs("Sortieren");
    }
    @Test
    public void testSwitchToEnglish(){
        languageTest.clickLanguageDropdown()
                .selectLanguage(EN_options)
                .assertSortLabelTextIs("Sort");
    }
    @Test
    public void testSwitchToSpanish(){
        languageTest.clickLanguageDropdown()
                .selectLanguage(ES_options)
                .assertSortLabelTextIs("Ordenar");
    }
    @Test
    public void testSwitchToFrench(){
        languageTest.clickLanguageDropdown()
                .selectLanguage(FR_options)
                .assertSortLabelTextIs("Trier");
    }
    @Test
    public void testSwitchToDutch() {
        languageTest
                .clickLanguageDropdown()
                .selectLanguage(NL_options)
                .assertSortLabelTextIs("Sorteren");
    }
    @Test
    public void testSwitchToTurkish(){
        languageTest.clickLanguageDropdown()
                .selectLanguage(TR_options)
                .assertSortLabelTextIs("Sırala");
    }
    @Test
    public void testFrenchLanguagePersistsAfterRefresh() {
        languageTest
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
