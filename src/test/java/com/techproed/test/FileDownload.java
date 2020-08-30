package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileDownload extends TestBase {
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    @Test
    public void isExist(){
        String mevcutKlasor =  System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR => "+ mevcutKlasor);
        String userKlasor = System.getProperty("user.home");
        System.out.println("USER KLASOR => "+userKlasor);
        String filePath = userKlasor + "/Downloads/Team13 (1).png";
        //String filePath = "C:/Users/PC/Downloads/logo.jpg";  bu da kullanilabilir.
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);  //Eger dosya varsa(file exist) true ve Pass,yoksa false ve test Fail olur..
    }
    @Test
    public void downloadTest(){
        //downloadTest () metodunun icinde aşağıdaki testi yapın:
        //https://the-internet.herokuapp.com/download adresine gidin.
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image=driver.findElement(By.linkText("image1.jpg"));
        image.click();
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.

        String userKlasor=System.getProperty("user.home");
        String filePath=userKlasor+"/Downloads/image1.jpg";

        boolean isDownloaded=Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);

    }
}
