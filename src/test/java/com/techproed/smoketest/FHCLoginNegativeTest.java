package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCLoginNegativeTest extends TestBase {

/*
fhctrip uygulamasının oturum açma işlevselliğini test edin.  http://www.fhctrip.com/Account/Logon
Iki ayri class olusturun (package:smoketest) : PositiveTest ve NegativeTest
Negative test :
geçerli  username fakat geçersiz password
geçerli password  fakat geçersiz username
her ikisi de geçersiz username ve password.
 */

    @Test
    public void gecersizUsername(){

        driver.get(ConfigReader.getProperty("fhc_login_url"));

        FHCLoginPage gecersizUsername=new FHCLoginPage(driver);
        gecersizUsername.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        gecersizUsername.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        gecersizUsername.loginButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
//        WebElement errorMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
//        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(FHCLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));
    }


    @Test
    public void gecersizPassword(){

        driver.get(ConfigReader.getProperty("fhc_login_url"));

        FHCLoginPage gecersizPassword=new FHCLoginPage(driver);
        gecersizPassword.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        gecersizPassword.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        gecersizPassword.loginButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
//        WebElement errorMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
//        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(FHCLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));
    }

    @Test
    public void gecersizUsernamePassword(){

        driver.get(ConfigReader.getProperty("fhc_login_url"));

        FHCLoginPage gecersizUsernamePassword=new FHCLoginPage(driver);
        gecersizUsernamePassword.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        gecersizUsernamePassword.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        gecersizUsernamePassword.loginButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
//        WebElement errorMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
//        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(FHCLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));
    }
    
    
    



}
