package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationPage {
    private Driver driver;

    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    //Locator
    By RegistrationFormLink = By.xpath("//a[@href=\"/auth/register\"]");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By dateOfBirthField = By.id("dob");
    By streetField = By.id("street");
    By postalCodeField = By.id("postal_code");
    By cityField = By.id("city");
    By stateField = By.id("state");
    By countryField = By.id("country");
    By phoneField = By.id("phone");
    By emailAddressField = By.id("email");
    By passwordField = By.id("password");
    By registerClickButton = By.xpath("//button[@data-test='register-submit']");
    By FirstNameError = By.xpath("//div[@data-test=\"first-name-error\"]");
    By LastNameError = By.xpath("//div[@data-test=\"last-name-error\"]");
    By DateOfBirthError = By.xpath("//div[@data-test=\"dob-error\"]");
    By StreetError = By.xpath("//div[@data-test=\"street-error\"]");
    By PostcodeError = By.xpath("//div[@data-test=\"postal_code-error\"]");
    By DateError = By.xpath("//div[@data-test=\"city-error\"]");
    By StateError = By.xpath("//div[@data-test=\"state-error\"]");
    By PhoneError = By.xpath("//div[@data-test=\"phone-error\"]");
    By EmailAddressError = By.xpath("//div[@data-test=\"email-error\"]");
    By PasswordError = By.xpath("//div[@data-test=\"password-error\"]");

    /*****************************ASSERTIONS*******************/
    @Step("AssertThatUserRedirectToLoginPageAfterSuccessfulRegistration")
public RegistrationPage AssertThatUserRedirectToLoginPageAfterSuccessfulRegistration(){
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe("https://practicesoftwaretesting.com/auth/login"));

    String actualUrl = driver.get().getCurrentUrl();
    Assert.assertEquals(actualUrl, "https://practicesoftwaretesting.com/auth/login");
return this;
}
    @Step("verifyErrorMessage")
    public  RegistrationPage verifyErrorMessage() {
        Assert.assertTrue(driver.element().isDisplayed(FirstNameError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(LastNameError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(EmailAddressError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(DateOfBirthError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(StreetError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(PostcodeError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(DateError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(StateError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(PhoneError), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(PasswordError), "Error message not displayed");
        return this;
    }

    /*****************************Actions********************/
    @Step("ClickOnRegistrationFormLink")
    public RegistrationPage ClickOnRegistrationFormLink() {
        driver.element().click(RegistrationFormLink);
        return this;
    }
    @Step("fillRegisterFormWithValidCredintial")
    public RegistrationPage fillRegisterFormWithValidCredintial() {
        driver.get().findElement(firstNameField).sendKeys("eyad");
        driver.get().findElement(lastNameField).sendKeys("eyad");
        driver.get().findElement(dateOfBirthField).sendKeys("22/4/2001");
        driver.get().findElement(streetField).sendKeys("15s");
        driver.get().findElement(postalCodeField).sendKeys("789");
        driver.get().findElement(cityField).sendKeys("Alex");

        Select select = new Select(driver.get().findElement(countryField));
        select.selectByValue("EG");

        driver.get().findElement(stateField).sendKeys("Alex");
        driver.get().findElement(phoneField).sendKeys("014238965");
        String generatedEmail = "user" + System.currentTimeMillis() + "@mail.com";
        driver.get().findElement(emailAddressField).sendKeys(generatedEmail);

// حفظ الإيميل في TestData عشان نستخدمه في تسجيل الدخول
        TestData.registeredEmail = generatedEmail;

        driver.get().findElement(passwordField).sendKeys("Ey-901234");
        return this;
    }
    @Step("fillRegisterFormWithInvalidCredintial")
    public RegistrationPage fillRegisterFormWithInvalidCredintial() {
        driver.get().findElement(firstNameField).sendKeys("");
        driver.get().findElement(lastNameField).sendKeys("");
        driver.get().findElement(dateOfBirthField).sendKeys("22/4/");
        driver.get().findElement(streetField).sendKeys("");
        driver.get().findElement(postalCodeField).sendKeys("");
        driver.get().findElement(cityField).sendKeys("");
        driver.get().findElement(stateField).sendKeys("");
        driver.get().findElement(phoneField).sendKeys("hghhhg");
        driver.get().findElement(emailAddressField).sendKeys("EYAD");
        driver.get().findElement(passwordField).sendKeys("eyad");
        return this;
    }

    @Step("clickOnRegisterButton")
    public RegistrationPage clickOnRegisterButton() {
        //driver.element().scrollToElement(createAccountButton);
        driver.element().click(registerClickButton);
        return this;
    }


}
