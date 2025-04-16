package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ConfirmationPaymentPage {
    private Driver driver;
    By paymentField= By.xpath("//select[@data-test='payment-method']");
    By confirmButton= By.xpath("//button[@data-test='finish']");
    By PaymentSuccessfulMsg=By.xpath("//div[@data-test='payment-success-message']");
    String PaymentSuccessfulStringMsg= "Payment was successful";
    public ConfirmationPaymentPage(Driver driver)
    {
        this.driver = driver;

    }
    /*****************************ASSERTIONS*******************/
    @Step("CheckThatPaymentSuccessfulMsgShouldBeDisplayed")
    public ConfirmationPaymentPage CheckThatPaymentSuccessfulMsgShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element()
                .getTextOf(PaymentSuccessfulMsg), PaymentSuccessfulStringMsg);
        return this;
    }
    /*****************************Actions********************/
    @Step("fillInPaymentField")
    public ConfirmationPaymentPage fillInPaymentField() {
        Select select = new Select(driver.get().findElement(paymentField));
        select.selectByValue("cash-on-delivery");

        return this;
    }
    @Step("clickOnConfirmButton")
    public ConfirmationPaymentPage clickOnConfirmButton()
    {
        driver.element().click(confirmButton);
        return new ConfirmationPaymentPage(driver);
    }
}
