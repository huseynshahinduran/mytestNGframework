package com.techproed.test;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {

    /*
        +Tests package’inda yeni bir class olusturun: WindowHandleExample
        +https://the-internet.herokuapp.com/windows adresine gidin.
        +Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        +Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        +Click Here butonuna basın.
        +Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
        +Sayfadaki textin   “New Window” olduğunu doğrulayın.
       Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
    */

    @Test
    public void newWindowPage(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWinDowHandle=driver.getWindowHandle();
        System.out.println("PARENT WINDOW HANDLE => "+parentWinDowHandle);

        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowHandles=driver.getWindowHandles();
        for (String childWindowHandle : allWindowHandles) {
            if (!childWindowHandle.equals(parentWinDowHandle)){
                driver.switchTo().window(childWindowHandle);
                System.out.println("CHILD WINDOW HANDLE => "+childWindowHandle);
            }

        }

        String actualNewTitle=driver.getTitle();
        String expectedNewTitle="New Window";
        Assert.assertEquals(actualNewTitle,expectedNewTitle);

        String actualNewText=driver.findElement(By.xpath("//h3")).getText();
        String expectedNewText="New Window";
        Assert.assertEquals(actualNewText,expectedNewText);


        driver.switchTo().window(parentWinDowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet");



    }








}
