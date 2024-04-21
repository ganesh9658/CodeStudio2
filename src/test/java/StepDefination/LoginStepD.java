package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.OrangeLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepD extends BaseClass{
	
	@Before
	public void startup()
	{
		OpenBrowser();
		System.out.println("browser is open");
		System.out.println("browser is open");
	}
	
	@Given("User Open the chrome browser")
	public void user_open_the_chrome_browser() {
		System.getProperty("user.dir");
		//WebDriverManager.chromedriver().setup();
		System.out.println("Browser already opened from hook");
		log.info("Browser opened");
		System.out.println(prop.getProperty("browser"));
		lp=new OrangeLoginPage(driverb);
		
	
	}



	@When("Users Open the URL")
	public void users_open_the_url() {
	  // driverd.get(url);
		OpenUrl();
	   log.info("open the URL");
	}

	

	@When("Users enter username as {string} and password as {string}")
	public void users_enter_username_as_and_password_as(String stringuname, String stringpwd) throws InterruptedException {
		Thread.sleep(3000);
		lp.EnterUsername(stringuname);
		lp.EnterPassword(stringpwd);
		log.info("Enter username and password");
	}

	
	@And("Clicks on the Login_button")
	public void clicks_on_the_login_button() throws InterruptedException {
		Thread.sleep(3000);
	    lp.ClickLoginButton();
	    log.info("click on login button");
	}

	

	@Then("user is Navigate on the Home Page")
	public void user_is_navigate_on_the_home_page() {
		String expected="OrangeHRM";
	   String title=driverb.getTitle();
	   //System.out.println("The title is"+title );
	   Assert.assertEquals(expected, title);
	   lp.ClickAdminTab();
	   lp.EnterRUsername(randomeUsername());
	   log.warn("navigate to home page and validate the title");

	   
	   
	}

	

	/*@And("Close the browser")
	public void close_the_browser() {
		System.out.println("browser will terminate from hook");
		log.info("close the browser");
	}*/

	@After
	public void teardown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			Date date=new Date();
			String newDate=date.toString().replace(" ", "-").replace(":", "-");
			File file=((TakesScreenshot)driverb).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("FailedScreenshot//FSS"+newDate+".png"));
			
		}
		
		driverb.quit();
		
	}
	
	
	
	@BeforeStep
	public void ss(Scenario sc)
	{
		if(sc.isFailed()==false)
		{
		String title=driverb.getTitle();
			Date date=new Date();
			String newDate=date.toString().replace(" ", "-").replace(":", "-");
			File file=((TakesScreenshot)driverb).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("BeforeStep//"+title+""+newDate+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@AfterStep
	public void addScreenshotAfterStep(Scenario sc)
	{
		if(sc.isFailed())
		{
			final byte[] screenshot= ((TakesScreenshot)driverb).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", sc.getName());
		}
	}



}
