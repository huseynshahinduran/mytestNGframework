package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class ActionClassExample extends TestBase {

      /*
        Create  class: ActionsClassExample
        Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
        https://the-internet.herokuapp.com/context_menu web sitesine gidin.
        Dikdörtgen kutu icinde sağa tıklayın.
        Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
        Alert’te OK ye basin
     */

    @Test
    public void contextClickMethod(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement dikdortgen=driver.findElement(By.id("hot-spot"));

        actions.contextClick(dikdortgen).perform();

        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().alert().accept();

        System.out.println(actualText);
    }

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");

        WebElement helloSingIn=driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(helloSingIn).perform();
        WebElement yourAccount=driver.findElement(By.linkText("Your Account"));
        yourAccount.click();

        //Sayfa basligini(page title) "Your Account" icerdigini(contains) dogrulayin

    }

    /*
    https://www.google.com/ adresine gidin.
Google text box’a IPHONE (capital) yazdirin
( input(giris) => iphone , output => IPHONE)
Text box’ta cift tiklayin(double click).
     */

    @Test
    public void keysUpDown(){

        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.name("q"));
//        searchBox.sendKeys("iphone");

        //Buyuk Harf icin
            //1.Yol:
//        searchBox.sendKeys(Keys.SHIFT+"iphone");

            //2.Yol
//        actions.
//                moveToElement(searchBox).
//                click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone").
//                perform();

        actions.
                keyDown(searchBox,Keys.SHIFT).
                sendKeys("iphone").
                keyUp(searchBox,Keys.SHIFT).
                perform();

        actions.doubleClick(searchBox).perform();
    }

    @Test
    public void scrollUpDown() throws InterruptedException {

        driver.get("https://www.amazon.com/");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }





}
