package com.qa_test_demo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertCsvXlsx {
    public static void convert(String csvPath, String xlsxPath) throws IOException {
        try(Workbook workbook = new XSSFWorkbook();
            BufferedReader reader = new BufferedReader(new FileReader(csvPath))
            ) {
                Sheet sheet = workbook.createSheet("logs");
                String line;
                int rowNum = 0;
                while((line = reader.readLine()) != null) {
                    Row row = sheet.createRow(rowNum++);
                    String[] cells = line.split(",");
                    for (int i = 0; i < cells.length; i++){
                        row.createCell(i).setCellValue(cells[i]);
                    }

                }
                try (FileOutputStream out = new FileOutputStream(xlsxPath)){
                    workbook.write(out);
                }

            }
    }



}