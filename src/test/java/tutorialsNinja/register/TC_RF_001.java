package tutorialsNinja.register;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtilities;

public class TC_RF_001 extends Base{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	
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
		driver.findElement(By.id("input-email")).sendKeys(commonUtilities.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("ankana123");
		driver.findElement(By.id("input-confirm")).sendKeys("ankana123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expected_heading = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']// h1")).getText(), expected_heading);
		
		String properDetailsOne = "Congratulations! Your new account has been successfully created!";
		String properDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String properDetailsThree ="f you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String properDetailsFour = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		
		String expected_properDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expected_properDetails.contains(properDetailsOne));
		Assert.assertTrue(expected_properDetails.contains(properDetailsTwo));
		Assert.assertTrue(expected_properDetails.contains(properDetailsThree));
		Assert.assertTrue(expected_properDetails.contains(properDetailsFour));
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
				
	}
	
	/**public String generateNewEmail()
	{
		Date date=new Date();
		String dateString = date.toString();	
		String noSpaceDateString = dateString.replaceAll(" ","");
		String noSpaceandColonDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceandColonDateString+"@gmail.com";
		return emailWithTimeStamp;

	}**/

}
