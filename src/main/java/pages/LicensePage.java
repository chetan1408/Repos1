package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensePage 
{
	
	@FindBy(xpath = "//nobr[.='Issue Date:']/../../td[2]")
	private WebElement issueDate;

	@FindBy(id = "LogoutLink")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//b[contains(.,'actiTIME')]")
	private WebElement productEdition;
	
	public LicensePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProductEdition( String pExpected)
	{
		String pActual = productEdition.getText();
		Reporter.log("Actual Product Edition: "+ pActual, true);
		Reporter.log("Expected Product Edition: "+ pExpected, true);
		Assert.assertEquals(pActual, pExpected);
		
	}
	
	public void verifyIssueDate()
	{
		Assert.assertTrue(issueDate.isDisplayed());
	}

}
