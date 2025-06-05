package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.commonUtilities;

public class Base {
	
	WebDriver driver;

    public WebDriver openBrowserApplication()
	{
    	
    	Properties prop = commonUtilities.loadProperty();
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("safari"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appUrl"));
		
		return driver;
	}
	
		
}
