
package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest implements IAutoConst
{
	public static int pass = 0, fail = 0;
	public WebDriver driver;
	
	@BeforeSuite
	public void setprop()
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}

	@BeforeMethod
	public void openActitTimeApp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ETO,TimeUnit.SECONDS );
		driver.get(URL);
		
	}
	
	@AfterMethod
	public void closeApp(ITestResult iTestResult)
	{
		if(iTestResult.getStatus()==2)
		{
			String name = iTestResult.getName();
			Reporter.log("Failed method name is:- "+name, true);
			FWUtils.takeScreenShot(driver, PHOTO_PATH +name+ ".png");
			fail++;
		}
		else
		{
			pass++;
			//System.out.println("pass count is: "+pass);
		}
		driver.close();
	}
	
	@AfterSuite
	public void genReport() throws InterruptedException
	{
		System.out.println(pass);
		FWUtils.setXLData(REPORT_PATH, "Sheet1", 2, 0, pass);
		System.out.println(fail);
		FWUtils.setXLData(REPORT_PATH, "Sheet1", 1, 1, fail);
	}
	
}
