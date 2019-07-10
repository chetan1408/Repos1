package script;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.EnterTimeTrackPage;
import pages.LicensePage;
import pages.LoginPage;

public class TestCheckIssueDate extends BaseTest
{
	@Test(priority = 3)
	public void testCheckIssueDate() throws InterruptedException
	{
		String un = FWUtils.getXLData(XL_PATH, "CheckIssueDate", 1, 0);
		String pw = FWUtils.getXLData(XL_PATH, "CheckIssueDate", 1, 1);
		String issueDate = FWUtils.getXLData(XL_PATH, "CheckIssueDate", 1, 2);
		
		LoginPage lg = new LoginPage(driver);
		
		//Enter valid username
		lg.setUN(un);
		
		//Enter valid passwrd
		lg.setPW(pw);
		
		lg.login();
		Thread.sleep(3000);
		
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		
		
		e.clickSettings();
		
		e.clickLicenses();
		
		LicensePage lp = new LicensePage(driver);
		
		lp.verifyIssueDate();
		
		String expected = FWUtils.getXLData(XL_PATH, "CheckIssueDate", 1, 3);
		lp.verifyProductEdition(expected);
		
	}
	
}
