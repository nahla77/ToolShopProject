package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoriesPages {

   private WebDriver driver;

    public CategoriesPages(WebDriver driver) {
        this.driver = driver;
    }

    By Categories = (By.cssSelector("a[data-test='nav-categories']"));
    By HandTools = (By.cssSelector("a[data-test='nav-hand-tools']"));
    By PowerTools = (By.cssSelector("a[data-test='nav-power-tools']"));
    By Other = (By.cssSelector("a[data-test='nav-other']"));
    By SpecialTools = (By.cssSelector("a[data-test='nav-special-tools']"));
    By Rentals = (By.cssSelector("a[data-test='nav-rentals']"));


    /****************************************Assertion*******************************************/

    public void CheckThatUrlOfHandToolsPageIsCorrect(){

        String url2 =driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/hand-tools");
    }

    public void CheckThatUrlOfPowerToolsPageIsCorrect(){

        String url2 =driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/power-tools");
    }

    public void CheckThatUrlOfOtherToolsPageIsCorrect(){

        String url2 =driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/other");
    }
    public void CheckThatUrlOfSpecialToolsPageIsCorrect(){

        String url2 =driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/category/special-tools");
    }
    public void CheckThatUrlOfRentalsToolsPageIsCorrect(){

        String url2 =driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://practicesoftwaretesting.com/rentals");
    }

    /**********************Actions**************************************************************/


    public void CheckThatHandToolsPageIsLoadedSuccessfully(){
        driver.findElement(Categories).click();
        driver.findElement(HandTools).click();
    }

    public void CheckThatPowerToolsPageIsLoadedSuccessfully(){
        driver.findElement(Categories).click();
        driver.findElement(PowerTools).click();
    }
    public void CheckThatOtherToolsPageIsLoadedSuccessfully(){
        driver.findElement(Categories).click();
        driver.findElement(Other).click();
    }
    public void CheckThatSpecialToolsPageIsLoadedSuccessfully(){
        driver.findElement(Categories).click();
        driver.findElement(SpecialTools).click();
    }
    public void CheckThatRentalsToolsPageIsLoadedSuccessfully(){
        driver.findElement(Categories).click();
        driver.findElement(Rentals).click();
    }



}
