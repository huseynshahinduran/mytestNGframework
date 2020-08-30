package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcel() throws IOException {

        String path=".\\src\\test\\resources\\ULKELER.xlsx";
        FileInputStream file=new FileInputStream(path);
        Workbook workbook=WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(0);

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        Cell cell4=row.createCell(3);
        cell4.setCellValue("NUFUS");

        Cell cell5=row.createCell(4);
        cell5.setCellValue("YUZOLCUMU");

        row.removeCell(cell5);

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83.02 million");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10.72 million");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("82 million");


        workbook.write(fileOutputStream);

        fileOutputStream.close();
        file.close();
        workbook.close();

    }






}
