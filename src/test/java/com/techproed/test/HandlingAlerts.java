package com.techproed.test;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingAlerts extends TestBase {

    /*
        Bir class olusturun: HandlingAlerts
        https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton1=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton1.click();
        Thread.sleep(500);
        System.out.println("Alert mesaji: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement resultMessage=driver.findElement(By.id("result"));
        Assert.assertTrue(resultMessage.isDisplayed());
        System.out.println("Result mesaji: "+resultMessage.getText());
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton2=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        buton2.click();
        Thread.sleep(500);
        System.out.println("Alert mesaji: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement resultMessage=driver.findElement(By.id("result"));
        String actualResult=resultMessage.getText();
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println("Result mesaji: "+resultMessage.getText());

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton3=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        Thread.sleep(500);
        System.out.println("Alert mesaji: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("HUSEYN");
        driver.switchTo().alert().accept();
        WebElement resultMessage=driver.findElement(By.id("result"));
        Assert.assertTrue(resultMessage.isDisplayed());
        System.out.println("Result mesaji: "+resultMessage.getText());
    }

}
