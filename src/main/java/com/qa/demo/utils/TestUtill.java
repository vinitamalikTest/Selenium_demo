package com.qa.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.qa.demo.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtill extends TestBase {
    public static WebDriver driver;
    public TestUtill() throws IOException{
        super();
    }
    public  static String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);
            int totalNoOfCols = sh.getColumns();
            int totalNoOfRows = sh.getRows();
            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
            for (int i= 1 ; i < totalNoOfRows; i++) {
                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir +"/screenshots/"+System.currentTimeMillis()+".png"));
    }

}
