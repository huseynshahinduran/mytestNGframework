package com.techproed.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSingUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports1 {

    //ExtentReports ==>> raporlamaya baslamak icin buna ihtiyacimiz var. Raporu kapatmak(flash()) icin kullaniyoruz.
    //ExtentHtmlReporter ==>> Raporlari yapilandirmaya (configuration) yardimci olur. HTML raporlarini creat eder.
    //ExtentTest ==>> Aciklama(logs) eklemek icin, test adimlarini belirlemek icin kullanilir.

    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

    @BeforeTest
    public void setup(){

        /*
            reporter'i baslatalim ve konumunu ayarlayalim.
                                            klasor: reports  , dosya adi: extentreport.html
         */

        extentHtmlReporter=new ExtentHtmlReporter("./reports/extentreport.html");
        //extentHtmlReporter'la bazi yapilandirmalar yapalim.
        extentHtmlReporter.config().setReportName("GLB trader Report");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentHtmlReporter.config().setDocumentTitle("GLB sing up report");
        extentHtmlReporter.config().setEncoding("UTF-8");

        //ExtentReports'u creat edelim
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //daha fazla aciklama ekleyebiliriz.
        extentReports.setSystemInfo("Automation engineer","Huseyn");
        extentReports.setSystemInfo("Browser","chrome");



    }

    @AfterTest
    public void endReport(){

     extentReports.flush();

    }

    @Test
    public void glbSingUp() throws InterruptedException {

        GlbSingUpPage glbSingUp=new GlbSingUpPage();
        GlbHomePage glbHomePage=new GlbHomePage();

        extentTest=extentReports.createTest("GLB Sing Up Test");

        extentTest.info("URL'e git");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("Join Now linkine tikla");
        glbHomePage.joinNowLink.click();

        extentTest.info("Email'i gir");
        glbSingUp.email.sendKeys(ConfigReader.getProperty("test_email"));
        extentTest.info("Isim'i gir");
        glbSingUp.name.sendKeys(ConfigReader.getProperty("name"));
        extentTest.info("Telefon numaras'i gir");
        glbSingUp.mobile.sendKeys(ConfigReader.getProperty("phone_num"));
        extentTest.info("Sifre'i gir");
        glbSingUp.password.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("Sifre'i tekrar gir");
        glbSingUp.rePassword.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("Sing Up butonuna tikla");
        glbSingUp.singUpButton.click();


        Thread.sleep(2000);
//        System.out.println("SUCCESS MEASJ: "+glbSingUp.successMessage.getText());
        Assert.assertFalse(glbSingUp.successMessage.getText().equals("Success!"));
        extentTest.pass("PASSED: Test basariyla tamamlandi.");

        Driver.closeDriver();
        extentTest.pass("Driver basariyla kapatildi.");

    }




}
