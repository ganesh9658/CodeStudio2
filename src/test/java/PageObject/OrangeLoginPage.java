package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage
{
	WebDriver ldriver;
	
	public OrangeLoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[contains(@href,'/web/index.php/admin/viewAdminModule')]")
	WebElement AdminTab;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div[2]/input")
	WebElement UserNameTextBox;
	
	public void EnterUsername(String uname)
	{
		Username.sendKeys(uname);
	}
	public void EnterPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}

	public void ClickLoginButton()
	{
		LoginButton.click();
	}
	
	public void ClickAdminTab()
	{
		AdminTab.click();
	}
	
	public void EnterRUsername(String rname)
	{
		UserNameTextBox.sendKeys(rname);
	}


}
