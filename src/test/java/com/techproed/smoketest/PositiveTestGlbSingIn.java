package com.techproed.smoketest;


import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSingInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PositiveTestGlbSingIn {

    GlbSingInPage glbSingInPage=new GlbSingInPage();
    GlbHomePage glbHomePage=new GlbHomePage();

    @Test
    public void GlbSingInTest() {

        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        glbHomePage.singIn.click();

        glbSingInPage.login_email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSingInPage.login_password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSingInPage.loginButton.click();

        Driver.closeDriver();
    }





}
