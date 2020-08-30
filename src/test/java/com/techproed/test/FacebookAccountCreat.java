package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookAccountCreat extends TestBase {

    @Test
    public void nameSurname() throws InterruptedException {

        driver.get("https://www.facebook.com/");

        WebElement name=driver.findElement(By.id("u_0_o"));
        name.sendKeys("Ghost");

        WebElement surname=driver.findElement(By.id("u_0_q"));
        surname.sendKeys("Player");

        WebElement email=driver.findElement(By.id("u_0_t"));
        email.sendKeys("huseynshahinduran@gmail.com");

        Thread.sleep(500);

        WebElement reEmail=driver.findElement(By.id("u_0_w"));
        reEmail.sendKeys("huseynshahinduran@gmail.com");

        WebElement password=driver.findElement(By.id("password_step_input"));
        password.sendKeys("7399048898GhostPlayer");

        WebElement day=driver.findElement(By.id("day"));
        Select selectDay=new Select(day);
        selectDay.selectByIndex(6);

        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
        selectMonth.selectByValue("7");

        WebElement year=driver.findElement(By.id("year"));
        Select selectYear=new Select(year);
        selectYear.selectByValue("2001");

        WebElement male=driver.findElement(By.id("u_0_7"));
        if (!male.isSelected()){
            male.click();
        }else {
            System.out.println("Onceden secilmis.");
        }

        WebElement singUp=driver.findElement(By.id("u_0_15"));
        singUp.click();

    }





}
