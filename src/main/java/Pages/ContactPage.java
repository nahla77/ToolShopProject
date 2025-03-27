package Pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactPage {
    private Driver driver;

    public ContactPage(Driver driver) {
        this.driver = driver;
    }

    //Locator
    By contactFormTitle = By.xpath("//h3[contains(text(),'Contact')]");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By emailAddress = By.id("email");
    By Subject = By.id("subject");
    By message = By.id("message");
    By attachment = By.id("attachment");
    By sendButton = By.xpath("//input[@type=\"submit\"]");
    By ThanksMessage = By.xpath("//div[contains(@class, 'alert-success')]");
    String filePath = System.getProperty("user.dir") + "\\src\\testfiles\\testfile.txt";
    String InvalidFilePath = System.getProperty("user.dir") + "\\src\\testfiles\\InvalidTestFile.txt";
    By firstNameAlert = By.id("first_name_alert");
    By lastNameAlert = By.id("last_name_alert");
    By emailAddressAlert = By.id("email_alert");
    By SubjectAlert = By.id("subject_alert");
    By messageAlert = By.id("message_alert");
    By attachmentAlert = By.id("attachment_alert");

    /****************************************Assertions*******************************************/

    public ContactPage CheckThatUrlOfContactPageIsCorrect() {

        String url2 = driver.browser().getCurrentURL();
        Assert.assertEquals(url2, "https://practicesoftwaretesting.com/contact");
        return this;
    }

    public ContactPage checkThatContactPageShouldBeLoadedSuccessfully() {
        System.out.println("Current URL: " + driver.browser().getCurrentURL());
        System.out.println("Actual text found: " + driver.element().getTextOf(contactFormTitle));
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        WebElement contactHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(contactFormTitle));
        System.out.println("Actual text found: " + contactHeader.getText());
        //Assert.assertEquals(driver.element().getTextOf(contactFormTitle), "Contact");
        //Assert.assertTrue(driver.element().isDisplayed(contactFormTitle), "Error message not displayed");

        //Assert.assertTrue(driver.browser().getCurrentURL().contains("/contact"));
        return this;
    }
    public ContactPage checkThatThanksMessageIsDisplayedSuccessfully(){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ThanksMessage));
//        System.out.println("تم العثور على الرسالة: " + successMessage.getText());
        Assert.assertTrue(driver.element().isDisplayed(ThanksMessage), "Thanks message not displayed");

        return this;
    }
    public ContactPage verifyErrorMessage() {
        Assert.assertTrue(driver.element().isDisplayed(firstNameAlert), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(lastNameAlert), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(emailAddressAlert), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(SubjectAlert), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(messageAlert), "Error message not displayed");
        Assert.assertTrue(driver.element().isDisplayed(attachmentAlert), "Error message not displayed");
        return this;
    }

    /****************************************Actions*******************************************/
    public ContactPage fillInContactPageForm() {
        driver.get().findElement(firstName).sendKeys("Layan");
        driver.get().findElement(lastName).sendKeys("Aser");
        driver.get().findElement(emailAddress).sendKeys("lele@gmail.com");
        driver.element().selectByValue(Subject,"customer-service");
        driver.get().findElement(message).sendKeys("welcome in tool shop demo automation testing HELLO IN JAVA HELLO IN ");
        driver.get().findElement(attachment).sendKeys(filePath);
        return this;
    }
    public ContactPage fillInContactFormWithInValidData(){
        driver.get().findElement(firstName).sendKeys("");
        driver.get().findElement(lastName).sendKeys("");
        driver.get().findElement(emailAddress).sendKeys("invalid-email");
        //driver.element().selectByValue(Subject,"");
        driver.get().findElement(message).sendKeys("This is a test message. ");
        driver.get().findElement(attachment).sendKeys(InvalidFilePath);
        return this;

    }
    public ContactPage clickOnsendButton() {
        //driver.element().scrollToElement(createAccountButton);
        driver.element().click(sendButton);
        return this;
    }


}
