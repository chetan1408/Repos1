package script;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.LoginPage;

public class TestInvalidLoginPage extends BaseTest
{
	@Test(priority = 1)
	public void testInvalidLoginPage()
	{
		try
		{
			int rc = FWUtils.getXLRowCount(XL_PATH, "InvalidData");
			Reporter.log("row count is: "+rc, true);
						
			for (int i = 1; i<=rc ; i++)
			{
				String un = FWUtils.getXLData(XL_PATH, "InvalidData", i, 0);
				String pw = FWUtils.getXLData(XL_PATH, "InvalidData", i, 1);
				
				// Enter Username
				LoginPage lg = new LoginPage(driver);
				lg.setUN(un);
				
				// Enter Password
				lg.setPW(pw);
				
				lg.login();
				Thread.sleep(3000);
				
				lg.verify();
				Thread.sleep(3000);
			}
			
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
	
}
