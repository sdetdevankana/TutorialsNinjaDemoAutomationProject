package tutorialsNinja.register;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtilities;

public class TC_RF_008 extends Base{
	
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
	public void verifyRegisterWithDifferentPassWordAndPasswordConfirmValue() {
		
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ankana");
		driver.findElement(By.id("input-lastname")).sendKeys("Ghosh");
		driver.findElement(By.id("input-email")).sendKeys(commonUtilities.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("ankana123");
		driver.findElement(By.id("input-confirm")).sendKeys("ankana");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		String warningMessage = "Password confirmation does not match password!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), warningMessage);
		
		
		
		
		
				
	}
	
	

}
