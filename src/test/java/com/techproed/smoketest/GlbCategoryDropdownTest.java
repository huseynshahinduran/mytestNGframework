package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbCategoryDropdownTest {

    @Test
    public void glbCategoryDropdownTest(){

        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        GlbHomePage glbHomePage=new GlbHomePage();

        Select options=new Select(glbHomePage.allCategoryDropdown);

        boolean flag=false;
        for (WebElement option : options.getOptions()){
            if(option.getText().equals("Furniture")){
                System.out.println("Dropdownda Furniture vardir.");
                flag=true;
                break;

            }
        }

        Assert.assertTrue(flag);

        Driver.closeDriver();
    }




}
