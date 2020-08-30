package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatHotel extends TestBase {

        /*
Tests packagenin altina class olusturun: CreateHotel
Bir method olusturun: createHotel
http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
Username : manager2
Password : Man1ager2!
Login butonuna basin.
Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
Save butonuna basin.
“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
OK butonuna tiklayin.

         */


    @Test
    public void creatHotel(){

        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");

        WebElement usernameTextBox=driver.findElement(By.id("UserName"));
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        usernameTextBox.sendKeys("manager2");
        passwordTextBox.sendKeys("Man1ager2!");
        loginButton.click();

        driver.findElement(By.id("Code")).sendKeys("BUTIK");
        driver.findElement(By.id("Name")).sendKeys("GHOST");
        driver.findElement(By.id("Address")).sendKeys("Glasgow");
        driver.findElement(By.id("Phone")).sendKeys("5842794685795");
        driver.findElement(By.id("Email")).sendKeys("ghosthotel@gmail.com");

        WebElement iDGroup=driver.findElement(By.id("IDGroup"));
        Select select=new Select(iDGroup);
        select.selectByIndex(1);

        WebElement save=driver.findElement(By.id("btnSubmit"));
        save.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),
                "Hotel was inserted successfully"));

        Assert.assertTrue(isTrue);

        WebElement okButton=driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        okButton.click();

    }

}
