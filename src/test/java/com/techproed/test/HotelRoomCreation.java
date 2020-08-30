package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {

    /*
    Tests packagenin altina class olusturun: HotelRoomCreation
Bir method olusturun:  RoomCreateTest()
http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
Username : manager2
Password : Man1ager2!
Login butonuna basin.
Acilan sayfadaki butun textboxlara istediginiz verileri girin
Save butonuna basin.
“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
OK butonuna tiklayin.
Hotel rooms linkine tiklayin.
"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.
     */

    @Test
    public void roomCreatTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");

        WebElement usernameTextBox=driver.findElement(By.id("UserName"));
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        usernameTextBox.sendKeys("manager2");
        passwordTextBox.sendKeys("Man1ager2!");
        loginButton.click();

        WebElement addHotelRoomButton=driver.findElement(By.className("hidden-480"));
        addHotelRoomButton.click();

        WebElement IDHotel=driver.findElement(By.id("IDHotel"));
        Select select=new Select(IDHotel);
        select.selectByVisibleText("GHOST");

        driver.findElement(By.id("Code")).sendKeys("King");
        driver.findElement(By.id("Name")).sendKeys("5842");
        driver.findElement(By.id("Location")).sendKeys("The Sea Side");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Sehir Manzarali");
        WebElement kaynak=driver.findElement(By.linkText("700"));
        WebElement hedef=driver.findElement(By.id("Price"));
        actions.dragAndDrop(kaynak,hedef).perform();
        WebElement roomType=driver.findElement(By.id("IDGroupRoomType"));
        Select select1=new Select(roomType);
        select1.selectByIndex(6);
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        driver.findElement(By.id("MaxChildCount")).sendKeys("2");
        WebElement save=driver.findElement(By.id("btnSubmit"));
        save.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),
                "HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);
        WebElement okButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        okButton.click();

        Thread.sleep(500);
        actions.sendKeys(Keys.PAGE_UP).perform();

        WebElement hotelRoomsLink=wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//a[@href='/admin/HotelRoomAdmin']")));
        hotelRoomsLink.click();

        WebElement listOfHotels=driver.findElement(By.xpath("//span[.='List Of Hotelrooms']"));
        Assert.assertTrue(listOfHotels.isDisplayed());

    }

}
