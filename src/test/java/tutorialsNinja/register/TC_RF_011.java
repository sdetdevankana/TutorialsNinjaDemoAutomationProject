package tutorialsNinja.register;

import java.time.Duration;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtilities;

public class TC_RF_011 extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
			driver = openBrowserApplication();
			
			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			
		}
		
		@AfterMethod
		public void teardown()
		{
			if(driver!=null) {
			driver.quit();
			}
		}
		

	
	@Test
	public void verifyRegisterWithInvalidPhone()
	{
		driver.findElement(By.id("input-firstname")).sendKeys("Ankana");
		driver.findElement(By.id("input-lastname")).sendKeys("Ghosh");
		driver.findElement(By.id("input-email")).sendKeys(commonUtilities.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1111");
		driver.findElement(By.id("input-password")).sendKeys("ankana123");
		driver.findElement(By.id("input-confirm")).sendKeys("ankana123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		String expectedWarningMessage = "Phone number does not apear to be valid";
		
		boolean state = false;
		try {
			String actualWarningMessage = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
			
			if(actualWarningMessage.equals(expectedWarningMessage))
			{
				state = true;
			}
		}catch(NoSuchElementException e)
		{
			state = false;
		}
		
		Assert.assertTrue(state);
		
	}
	
	

}
