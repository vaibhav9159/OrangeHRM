package com.hrm.qa.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hrm.qa.base.BaseTest;

public class Utils extends BaseTest{
	
	static Workbook book;
	static Sheet sheet;

	public static long IMPLICIT_WAIT = 10;
	public static int PAGE_LOAD_WAIT = 10;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "/src/main/java/com/hrm/qa/data/candidateData.xlsx"; 

	public static Object[][] getCandidateTestData(String sheetName) throws EncryptedDocumentException, IOException {
		 DataFormatter format = new DataFormatter();
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(file);
 
		sheet = book.getSheet(sheetName);
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				try {
					//data[i][j] = sheet.getRow(i + 1).getCell(j).toString();	 
					data[i][j]= format.formatCellValue(sheet.getRow(i+1).getCell(j));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	
	public static void captureScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis()+ ".png"));
	}

}
