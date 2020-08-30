package com.techproed.smoketest;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSingUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class GlbSingUpTest {

    GlbSingUpPage glbSingUp=new GlbSingUpPage();
    GlbHomePage glbHomePage=new GlbHomePage();

    @Test
    public void glbSingUp() throws InterruptedException {

//        Driver.getDriver().get(ConfigReader.getProperty("glb_singup_url"));

        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        glbHomePage.joinNowLink.click();

        glbSingUp.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSingUp.name.sendKeys(ConfigReader.getProperty("name"));
        glbSingUp.mobile.sendKeys(ConfigReader.getProperty("phone_num"));
        glbSingUp.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSingUp.rePassword.sendKeys(ConfigReader.getProperty("test_password"));
        glbSingUp.singUpButton.click();

        Thread.sleep(2000);
        System.out.println("SUCCESS MEASJ: "+glbSingUp.successMessage.getText());
        Assert.assertTrue(glbSingUp.successMessage.getText().equals("Success!"));

        Driver.closeDriver();

    }






}
