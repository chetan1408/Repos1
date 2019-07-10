package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.LoginPage;

public class TestValidLoginPage extends BaseTest
{
	@Test (priority = 2)
	public void testValidLogin() throws InterruptedException
	{
		String un = FWUtils.getXLData(XL_PATH, "ValidData", 1, 0);
		String pw = FWUtils.getXLData(XL_PATH, "ValidData", 1, 1);
		
		LoginPage lg = new LoginPage(driver);
		
		//Enter valid username
		lg.setUN(un);
		
		//Enter valid passwrd
		lg.setPW(pw);
		
		lg.login();
				
	}

}
