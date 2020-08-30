package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.Closeable;
import java.util.List;

public class WebTables extends TestBase {

    /*

     */



    public void login() throws InterruptedException {

        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(500);

    }

    @Test
    public void table() throws InterruptedException {
        login();

        WebElement tbody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("TABLE BODY SIZE: "+table.size());

        List<WebElement> allHeaders=driver.findElements(By.tagName("th"));
        for (WebElement header:allHeaders){
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRows() throws InterruptedException {
        login();

        System.out.println("Table body'de toplam "+driver.findElements(By.xpath("//tbody//tr")).size()+" tane satir(row) vardir.");

        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row:allRows){
            System.out.println(row.getText());
        }

        List<WebElement> elementsRow4=driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element:elementsRow4){
            System.out.println(element.getText());
        }
    }

    @Test
    public void printCells() throws InterruptedException {

        login();

        System.out.println("Tabloda toplam "+driver.findElements(By.xpath("//tbody//td")).size()+" tane cell(hucre) vardir.");

        List<WebElement> allCells=driver.findElements(By.xpath("//tbody//td"));
        for (WebElement cell:allCells){
            System.out.println(cell.getText());
        }

    }

    @Test
    public void printColumns() throws InterruptedException {

        login();

        System.out.println("Tabloda toplam "+driver.findElements(By.xpath("//tr[3]//td")).size()+" tane sutun(column) vardir.");

        List<WebElement> allColumns=driver.findElements(By.xpath("//tr[3]//td"));
        for (WebElement columns:allColumns){
            System.out.println(columns.getText());
        }

        System.out.println();

        List<WebElement> columns5=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement column:columns5){
            System.out.println(column.getText());
        }

    }

    public void printData(int row, int column){

        String xpath="//tbody//tr["+row+"]//td["+column+"]";
        WebElement data=driver.findElement(By.xpath(xpath));
        System.out.println(data.getText());

    }

    @Test
    public void printDataTest() throws InterruptedException {

        login();
        printData(8,3);
        printData(5,2);
        printData(9,5);






    }


}
