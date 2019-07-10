package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class FWUtils
{
	public static String getXLData(String path, String sheet, int r, int c)
	{
		String value = "";
		try
		{			
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue().toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;
		
	}

	public static void setXLData(String path, String sheet, int r, int c, int s)
	{
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).createRow(r).createCell(c).setCellValue(s);
			wb.write(new FileOutputStream(path));	
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static int getXLRowCount (String path, String sheet)
	{
		int n= -1;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			n = wb.getSheet(sheet).getLastRowNum();			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return n;
	}

	public static void takeScreenShot(WebDriver driver, String path)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path);
			FileUtils.copyFile(src, des);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	
}