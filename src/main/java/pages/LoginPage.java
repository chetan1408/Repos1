package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 

{

	@FindBy (name="username")
	private WebElement un;
	
	@FindBy (name="pwd")
	private WebElement pw;
		
	@FindBy (xpath = "//div[.='Login ']")
	private WebElement lgn;
		
	@FindBy (xpath = "(//span[@class='errormsg'])[1]")
	private WebElement errormsg;
				
	//WebDriver driver;
		
	public LoginPage(WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
		
	public void verify()
	{
		Assert.assertTrue(errormsg.isDisplayed());
	}
		
	public void login()
	{
		lgn.click();
	}
		
	public void setUN(String un1)
	{
		un.sendKeys(un1);
	}
		
	public void setPW(String pw1)
	{
		pw.sendKeys(pw1);
	}


}
