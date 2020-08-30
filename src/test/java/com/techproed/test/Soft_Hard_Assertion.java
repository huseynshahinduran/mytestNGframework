package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Soft_Hard_Assertion {

    /*
        Class name : Soft_Hard_Assertion
        http://a.testaddressbook.com/sign_in adresine gidin.
        email textbox,password textbox, ve signin button elementlerini locate edin.
        Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
        Username :  testtechproed@gmail.com
        Password :   Test1234!
        Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
        Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın
     */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test(priority = 1)
    public void login(){

        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        emailTextBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordTextBox=driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("Test1234!");

        WebElement singInButton=driver.findElement(By.name("commit"));
        singInButton.click();

        driver.manage().window().maximize();
    }

    @Test(dependsOnMethods = "login")
    public void homePage(){

        WebElement welcomeMessage=driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
        Assert.assertTrue(welcomeMessage.isDisplayed());

        SoftAssert softAssert=new SoftAssert();
//        softAssert.assertTrue(!welcomeMessage.isDisplayed());
        softAssert.assertTrue(welcomeMessage.isDisplayed());
//        softAssert.assertEquals(3,5);
//        softAssert.assertAll();

        WebElement userID=driver.findElement(By.className("navbar-text"));
        String actualID=userID.getText();
        String expectedID="testtechproed@gmail.com";
        Assert.assertEquals(actualID,expectedID);

        SoftAssert softAssert1=new SoftAssert();
        softAssert1.assertEquals(actualID,expectedID);
        softAssert1.assertAll();




    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
