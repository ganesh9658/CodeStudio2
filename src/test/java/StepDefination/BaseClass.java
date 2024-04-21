package StepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.OrangeLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driverb;
	public OrangeLoginPage lp;
	public static Logger log;
	public Properties prop;
	
	public String randomeUsername()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public void OpenBrowser()
	{
		prop=new Properties();
		try {
			//FileInputStream file=new FileInputStream("C:\\Users\\Dinesh Saivolla\\eclipse-workspace_Selenium\\CodeStudio\\src\\test\\resources\\Configuration\\config.properties");
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\config.properties");
			
			prop.load(file);
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				
				
				log=org.apache.logging.log4j.LogManager.getLogger("LoginStepD");
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
				driverb=new ChromeDriver();
				lp=new OrangeLoginPage(driverb);
				driverb.manage().window().maximize();
				driverb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				log.info("startup executed");
			}
			else
			{
				log=org.apache.logging.log4j.LogManager.getLogger("LoginStepD");
				//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
				//driverd=new ChromeDriver();
				WebDriverManager.firefoxdriver().setup();
				driverb=new FirefoxDriver();
				lp=new OrangeLoginPage(driverb);
				driverb.manage().window().maximize();
				driverb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				log.info("startup executed");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void OpenUrl()
	{
		prop=new Properties();
		try {
			//FileInputStream file=new FileInputStream("C:\\Users\\Dinesh Saivolla\\eclipse-workspace_Selenium\\CodeStudio\\src\\test\\resources\\Configuration\\config.properties");
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\config.properties");
			
			prop.load(file);
			
			if(prop.getProperty("Url").equalsIgnoreCase("DEV")) {
				
				driverb.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
			}
			else if (prop.getProperty("Url").equalsIgnoreCase("QA"))
			{
				driverb.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			}
			else
			{
				driverb.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
