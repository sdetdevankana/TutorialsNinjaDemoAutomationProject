package tutorialsNinja.register;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;



public class TC_RF_009 extends Base{
	
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
	public void registerWithExistingEmail() throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ankana");
		driver.findElement(By.id("input-lastname")).sendKeys("Ghosh");
		driver.findElement(By.id("input-email")).sendKeys("ankanaghosh26@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("ankana123");
		driver.findElement(By.id("input-confirm")).sendKeys("ankana123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),expectedWarningMessage);
		
		
		Thread.sleep(3000);
		
		
		
			
	}
	
	

}
