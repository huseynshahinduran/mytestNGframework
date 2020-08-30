package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.omg.CORBA.UShortSeqHelper;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcelFile() throws IOException {
        //Data okuyacagimiz dosyanin path'ini yazalim
        String path="C:\\Users\\husey\\OneDrive\\Masaüstü\\ULKELER.xlsx";
        //Dosyayi(File) acalim
        FileInputStream fileInputStream=new FileInputStream(path);
        //fileInputStream kullanarak workbook'u acalim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //1.worksheet'e gidelim
        Sheet sheet=workbook.getSheetAt(0);
        //1.satira(row) gidelim
        Row row=sheet.getRow(0);
        //Artik test datalarini(cell) okuyabiliriz.
        Cell cell=row.getCell(0);

        System.out.println("1.CELl'deki data: "+cell);
        System.out.println("2.CELL'deki data: "+row.getCell(1));

        Row row2=sheet.getRow(1);
        Cell cell1=row2.getCell(0);
        System.out.println(cell1);

        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0));

        String row2cell1=workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(row2cell1);

        int rowSayisi=sheet.getLastRowNum();
        System.out.println("Dosyadaki toplam satir sayisi: "+rowSayisi);

        Map<String, String> ulkeler=new HashMap<>();
        int ulkeColumn=0;
        int baskentColumn=1;

        for(int rowNum = 1; rowNum<=rowSayisi; rowNum++){

            System.out.println("-----------------");
            String ulke=sheet.getRow(rowNum).getCell(ulkeColumn).toString();
            System.out.println("Ulke: "+ulke);

            String baskent= sheet.getRow(rowNum).getCell(baskentColumn).toString();
            System.out.println("Baskent: "+baskent);

            ulkeler.put(ulke,baskent);
        }

        System.out.println(ulkeler);



    }

}
