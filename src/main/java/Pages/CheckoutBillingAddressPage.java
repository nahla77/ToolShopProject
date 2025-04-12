package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutBillingAddressPage {
    private Driver driver;
    By BillingAddressStreet=By.xpath("//input[@formcontrolname='street']");
    By BillingAddressCity=By.xpath("//input[@formcontrolname='city']");
    By BillingAddressState=By.xpath("//input[@formcontrolname='state']");
    By BillingAddressCountry=By.xpath("//input[@formcontrolname='country']");
    By BillingAddressPostCode=By.xpath("//input[@formcontrolname='postal_code']");
    By ProceedThirdButton=By.xpath("//button[@data-test='proceed-3']");
    public CheckoutBillingAddressPage(Driver driver)
    {
        this.driver = driver;

    }
    /*****************************Actions********************/
    public CheckoutBillingAddressPage fillInCheckoutBillingAddressPage() {
        driver.get().findElement(BillingAddressStreet).sendKeys("15s");
        driver.get().findElement(BillingAddressCity).sendKeys("Alex");
        driver.get().findElement(BillingAddressState).sendKeys("Alex");
        driver.get().findElement(BillingAddressCountry).sendKeys("EG");
        driver.get().findElement(BillingAddressPostCode).sendKeys("789");

        return this;
    }
    public ConfirmationPaymentPage clickOnProceedThirdButton()
    {
        driver.element().click(ProceedThirdButton);
        return new ConfirmationPaymentPage(driver);
    }
}
