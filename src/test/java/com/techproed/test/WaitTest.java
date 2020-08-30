package com.techproed.test;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest extends TestBase {

     /*
        1.  Bir class olusturun : WaitTest
        2.  Iki tane metod olusturun :  implicitWait() , explicitWait()
        Iki metod icin de asagidaki adimlari test edin.
        3.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        4.  Remove butonuna basin.
        5.  “It’s gone!” mesajinin goruntulendigini dogrulayin.
     */

    @Test
    public void implicitWait(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement text=driver.findElement(By.id("message"));
        Assert.assertEquals(text.getText(),"It's gone!");

    }

    @Test
    public void explicitWait(){

        WebDriverWait wait=new WebDriverWait(driver,20);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertEquals(driver.findElement(By.id("message")).getText(),"It's gone!");
        System.out.println(driver.findElement(By.id("message")).getText());

    }



}
