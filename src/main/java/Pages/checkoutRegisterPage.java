package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutRegisterPage {
    private Driver driver;
    private WebDriverWait wait;
    By firstNameField = By.xpath("//input[@data-test='first-name']");
    By lastNameField = By.xpath("//input[@data-test='last-name']");
    By dateOfBirthField = By.xpath("//input[@data-test='dob']");
    By streetField = By.id("street");
    By postalCodeField = By.id("postal_code");
    By cityField = By.id("city");/////////rep
    By stateField = By.id("state");
    By countryField = By.id("country");
    By phoneField = By.id("phone");
    By emailAddressField = By.xpath("//*[@id='email']");
    By passwordField = By.xpath("//*[@id='password']");
    By registerClickButton = By.xpath("//button[@data-test='register-submit']");
    By TheLoggedInMSG=By.xpath("//p[contains(text(), 'you are already logged in')]");
    public checkoutRegisterPage(Driver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
    }
    /*****************************Actions********************/
    @Step("fillIncheckoutRegisterPage")
    public checkoutRegisterPage fillIncheckoutRegisterPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("souad");
        driver.get().findElement(lastNameField).sendKeys("a");
        driver.get().findElement(dateOfBirthField).sendKeys("22/4/2001");
        driver.get().findElement(streetField).sendKeys("15s");
        driver.get().findElement(postalCodeField).sendKeys("789");
        driver.get().findElement(cityField).sendKeys("Alex");

        Select select = new Select(driver.get().findElement(countryField));
        select.selectByValue("EG");

        driver.get().findElement(stateField).sendKeys("Alex");
        driver.get().findElement(phoneField).sendKeys("014238965");
        String email = "test" + System.currentTimeMillis() + "@example.com";
        TestData.registeredEmail = email;
        driver.get().findElement(emailAddressField).sendKeys(email);

        //driver.get().findElement(emailAddressField).sendKeys("souad1211@gmail.com");
        driver.get().findElement(passwordField).sendKeys("Sa-901234");
        return this;
    }
    @Step("clickOnRegisterClickButton")
    public checkoutLoginPage clickOnRegisterClickButton() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerClickButton));
        driver.element().click(registerClickButton);



        return new checkoutLoginPage(driver);
    }

}
