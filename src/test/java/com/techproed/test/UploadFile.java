package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {

    @Test
    public void fileUploader(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement choseFile=driver.findElement(By.id("file-upload"));
        String filePath="C:\\Users\\husey\\Downloads\\Team13 (1).png";
        choseFile.sendKeys(filePath);
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");


    }



}
