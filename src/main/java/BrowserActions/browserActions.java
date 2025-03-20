package BrowserActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class browserActions {

    private WebDriver driver;

    public browserActions(WebDriver driver) {
        this.driver = driver;
    }

    /******************************* URL Controlling and Navigation *********************************/
    public browserActions navigateToURL(String url) {
        driver.navigate().to(url);
        return this;
    }

    public browserActions getToURL(String url) {
        driver.get(url);
        return this;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public browserActions navigateForward() {
        driver.navigate().forward();
        return this;
    }

    public browserActions navigateBack() {
        driver.navigate().back();
        return this;
    }

    public browserActions refreshCurrentPage() {
        driver.navigate().refresh();
        return this;
    }

    public browserActions scrollToBottom() {
        new Actions(driver).scrollByAmount(0, 2500).build().perform();
        return this;
    }

    public browserActions scrollToAmount(int width, int height) {
        new Actions(driver).scrollByAmount(width, height).build().perform();
        return this;
    }

    /****************************************** Cookies ****************************************/

    public browserActions addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        return this;
    }


    public browserActions deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
        return this;
    }

    public browserActions deleteCookieWithName(String name) {
        driver.manage().deleteCookieNamed(name);
        return this;
    }

    public browserActions deleteAllCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }
}