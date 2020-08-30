package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    /*
        Bir class olusturun: IframeTest
        https://the-internet.herokuapp.com/iframe  adresine gidin.
        Bir metod olusturun: iframeTest
        “An IFrame containing….” textini konsolda yazdirin.
        Text Box’a “Merhaba Dunya!” yazin.
        TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iframeTest() throws InterruptedException {

        WebElement  iframeText=driver.findElement(By.xpath("//h3"));
        System.out.println(iframeText.getText());

        driver.switchTo().frame(0);
        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        driver.switchTo().defaultContent(); //==>Default page gider
        WebElement blueText=driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(blueText.getText());

    }
//
//    @AfterMethod
//    public void treadDown(){
//        driver.close();
//    }



}
