package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonDropdown extends TestBase {

        /*
        +Tests packagenin altinda bir class olusturun: AmazonDropdown
        +https://www.amazon.com/ adresine gidin.
        +Dropdown elementini bulun.
        +İlk seçilen seçeneği(firstSelectedOption) konsolda yazdırın ve ilk secenegin “All
        +Departments” ile esit oldugunu dogrulayin.
        6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu
        dogrulayin.(Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)
        Butun dropdown seçeneklerini konsolda yazdırın
        Dropdowndaki eleman sayisini konsolda yazdırın
        “Electronics” ın dropdownda olup olmadığını kontrol edin. “Electronics” dropdownda
        bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.

        NOT: TestBase classini kullanalim. Dogrulama yaparken Assertion kullanalim.
        Test case’de verilen secenekler sizde farkli olabilir. Sizde gorunen seceneklere gore
        kodunuzu yazabilirsiniz.
         */

    @Test
    public void amazonDropdown(){

        driver.get("https://www.amazon.com/");

        WebElement dropdownElement=driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(dropdownElement);

        String firstSelectedOption=driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        Assert.assertEquals(firstSelectedOption,"All Departments");
        System.out.println("First Option: "+firstSelectedOption);

        select.selectByIndex(5);
        String sixthOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(sixthOption,"Books");
        System.out.println("Sixth Option: "+sixthOption);

        System.out.println("\n *****All Option*****");
        List<WebElement> allOption=select.getOptions();
        for(WebElement option : allOption){
            System.out.println(option.getText());
        }

        int optionSayisi=allOption.size();
        System.out.println("\nDropdowndaki eleman sayisi: "+optionSayisi);

        boolean flag=false;
        for(WebElement option : allOption){
            if (option.getText().equals("Electronics")){
                flag=true;
                break;
            }
        }

        System.out.println(flag);








    }







}
