package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSingInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSingIn {

    GlbSingInPage glbSingInPage=new GlbSingInPage();
    GlbHomePage glbHomePage=new GlbHomePage();

    @Test
    public void gecersizEmail() throws InterruptedException {


        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        glbHomePage.singIn.click();

        glbSingInPage.login_email.sendKeys(ConfigReader.getProperty("gecersizglb_email"));
        glbSingInPage.login_password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSingInPage.loginButton.click();

        Assert.assertTrue(glbSingInPage.error_message.isDisplayed());

        Thread.sleep(1000);
        Driver.closeDriver();
    }


    @Test(groups = "grouptest1")
    public void gecersizPassword() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        Thread.sleep(3000);
        glbHomePage.singIn.click();

        glbSingInPage.login_email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSingInPage.login_password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbSingInPage.loginButton.click();

        Assert.assertTrue(glbSingInPage.error_message.isDisplayed());

        Thread.sleep(1000);
        Driver.closeDriver();
    }


    @Test(groups = "grouptest1")
    public void gecersizEmailPassword() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        glbHomePage.singIn.click();

        glbSingInPage.login_email.sendKeys(ConfigReader.getProperty("gecersizglb_email"));
        glbSingInPage.login_password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbSingInPage.loginButton.click();

        Assert.assertTrue(glbSingInPage.error_message.isDisplayed());

        Thread.sleep(1000);
        Driver.closeDriver();
    }







}
