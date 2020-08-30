package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FacebookLogin extends TestBase {

    @Test
    public void login(){
        driver.get("https://www.facebook.com/");

        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("huseyinsahinduran@gmial.com");

        WebElement password=driver.findElement(By.id("pass"));
        password.sendKeys("7399048898Falcon");

        WebElement login=driver.findElement(By.id("u_0_b"));
        login.click();

    }




}
