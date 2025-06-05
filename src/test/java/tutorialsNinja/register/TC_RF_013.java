package tutorialsNinja.register;

import java.time.Duration;

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

public class TC_RF_013 extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = openBrowserApplication();
		
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();

	}
	
	@Test
	public void verifyPlaceHolder()
	{
		String expectedFirstNamePlaceHolder = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),expectedFirstNamePlaceHolder);
		
		String expectedLastNamePlaceHolder = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),expectedLastNamePlaceHolder);
		
		String expectedEmailPlaceHolder = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),expectedEmailPlaceHolder);
		
		String expectedTelephonePlaceHolder = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),expectedTelephonePlaceHolder);
		
		String expectedPasswordPlaceHolder = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),expectedPasswordPlaceHolder);
		
		String expectedPasswordConfirmPlaceHolder = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),expectedPasswordConfirmPlaceHolder);
	}

}
