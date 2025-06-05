package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_006 extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
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
	public void verifyRegisterWithMandatoryFields() {
		
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ankana");
		driver.findElement(By.id("input-lastname")).sendKeys("Ghosh");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("ankana123");
		driver.findElement(By.id("input-confirm")).sendKeys("ankana123");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected());
				
	}
	
	public String generateNewEmail()
	{
		Date date=new Date();
		String dateString = date.toString();	
		String noSpaceDateString = dateString.replaceAll(" ","");
		String noSpaceandColonDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceandColonDateString+"@gmail.com";
		return emailWithTimeStamp;

	}

}
