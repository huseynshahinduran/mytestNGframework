package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPositiveTest extends TestBase {

     /*
        fhctrip uygulamasının oturum açma işlevselliğini test edin.  http://www.fhctrip.com/Account/Logon
        Iki ayri class olusturun (package:smoketest) : PositiveTest ve NegativeTest
        Positive Test : her ikisi de geçerli username ve password
     */

    @Test
    public void positiveTestLogin(){

        driver.get(ConfigReader.getProperty("fhc_login_url"));

        FHCLoginPage positiveTestLogin=new FHCLoginPage(driver);
        positiveTestLogin.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        positiveTestLogin.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        positiveTestLogin.loginButton.click();






    }



}
