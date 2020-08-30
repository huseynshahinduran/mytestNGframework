package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {

    @Test
    public void gecersizPassword(){

        //driver ==> Driver.getDriver()
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));

        FHCLoginPage gecersizPassword=new FHCLoginPage(Driver.getDriver());
        gecersizPassword.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        gecersizPassword.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        gecersizPassword.loginButton.click();
//        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        Assert.assertTrue(FHCLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));

        Driver.closeDriver();
    }



}
