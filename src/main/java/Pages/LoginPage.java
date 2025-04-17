package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private Driver driver;

    public LoginPage(Driver driver) {
        this.driver = driver;
    }
    //Locator
    By LoginStringHeader=By.xpath("//h3[text()='Login']");
    By emailAddressField = By.id("email");
    By passwordField = By.id("password");
    By LoginButton= By.xpath("//input[@data-test='login-submit']");
By LoginError= By.xpath("//div[@data-test=\"email-error\"]");
    By SigninLink = By.xpath("//a[@href=\"/auth/login\"]");
By ForgetPasswordLink = By.xpath("//a[@data-test=\"forgot-password-link\"]");
    By SetNewPasswordButton= By.xpath("//input[@data-test=\"forgot-password-submit\"]");

    /*****************************ASSERTIONS*******************/
    @Step("CheckThatLoginStringHeaderShouldBeDisplayed")
    public LoginPage CheckThatLoginStringHeaderShouldBeDisplayed() {
        Assert.assertTrue(
                new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(LoginStringHeader))
                        .isDisplayed(),
                " Login header is not displayed!"
        );
        return this;
    }
    @Step("AssertThatUserLoginSuccessfully")
    public LoginPage AssertThatUserLoginSuccessfully(){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://practicesoftwaretesting.com/account"));

        String ActualUrl = driver.get().getCurrentUrl();
        Assert.assertEquals(ActualUrl, "https://practicesoftwaretesting.com/account");
        return this;
    }
    @Step("verifyErrorMessage")
    public  LoginPage verifyErrorMessage() {
        Assert.assertTrue(driver.element().isDisplayed(LoginError), "Error message not displayed");
                return this;
    }
    /*****************************Actions********************/
    @Step("ClickOnSigninLink")
    public LoginPage ClickOnSigninLink(){
        driver.element().click(SigninLink);
        return this;
    }
    @Step("fillInLoginPage")
    public LoginPage fillInLoginPage() {
        System.out.println("Trying to login with email: " + TestData.registeredEmail);
        driver.get().findElement(By.id("email")).sendKeys(TestData.registeredEmail);

        driver.get().findElement(passwordField).sendKeys("Ey-901234");
        return this;
    }

    @Step("fillInLoginPageWithInvaildData")
    public LoginPage fillInLoginPageWithInvaildData() {
        driver.get().findElement(emailAddressField).sendKeys("souad1515.com");
        driver.get().findElement(passwordField).sendKeys("Sa-901234");

        return this;
    }
    @Step("ClickOnForgetPasswordLink")
    public LoginPage ClickOnForgetPasswordLink(){
        driver.element().click(ForgetPasswordLink);
        System.out.println("Trying to login with email: " + TestData.registeredEmail);
        driver.get().findElement(By.id("email")).sendKeys(TestData.registeredEmail);
        driver.element().click(SetNewPasswordButton);
        return this;

    }


    @Step("clickOnLoginButton")
    public LoginPage clickOnLoginButton()
    {
        driver.element().click(LoginButton);
        return this;
    }
}
