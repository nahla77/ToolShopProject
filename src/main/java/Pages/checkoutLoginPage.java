package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class checkoutLoginPage {
    private Driver driver;
    By LoginStringHeader=By.xpath("//h3[text()='Login']");
    By LoginButton= By.xpath("//input[@data-test='login-submit']");
    By EmailAddressField= By.xpath("//input[@data-test='email']");
    By PasswordField= By.xpath("//input[@data-test='password']");
    By HomeIcon=By.xpath("//a[@href='/' and contains(@class, 'nav-link')]");
    public checkoutLoginPage(Driver driver)
    {
        this.driver = driver;

    }
    /*****************************ASSERTIONS*******************/

    @Step("CheckThatLoginStringHeaderShouldBeDisplayed")
    public checkoutLoginPage CheckThatLoginStringHeaderShouldBeDisplayed() {
        Assert.assertTrue(
                new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(LoginStringHeader))
                        .isDisplayed(),
                " Login header is not displayed!"
        );
        return this;
    }


    /*****************************Actions********************/
    @Step("fillInCheckoutLoginPage")
    public checkoutLoginPage fillInCheckoutLoginPage() {
        driver.get().findElement(EmailAddressField).sendKeys(TestData.registeredEmail);


        driver.get().findElement(PasswordField).sendKeys("Sa-901234");

        return this;
    }
    @Step("clickOnLoginButton")
    public checkoutLoginPage clickOnLoginButton()
    {
        driver.element().click(LoginButton);
        return new checkoutLoginPage(driver);
    }
    @Step("clickOnHomeIcon")
    public HomePage clickOnHomeIcon()
    {
        driver.element().click(HomeIcon);
        return new HomePage(driver);
    }
}
