package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage 
{
	WebDriver driver;
	
	@FindBy(xpath = "(//div[contains(text(),'Settings')])[1]")
	private WebElement settings;
	
	@FindBy(linkText = "Licenses")
	private WebElement licenses;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSettings()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(settings));
		settings.click();
	}
	
	public void clickLicenses()
	{
		licenses.click();
	}
	
	public void verifyIsHomePageIsDisplayed(WebDriver driver,long ETO, String eTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,ETO);
		wait.until(ExpectedConditions.titleIs(eTitle));
		String atitle = driver.getTitle();
		
		Assert.assertEquals(atitle, eTitle);
				
	}
	
}
