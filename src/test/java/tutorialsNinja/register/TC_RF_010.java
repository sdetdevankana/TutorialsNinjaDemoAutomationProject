package tutorialsNinja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 extends Base{
	
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
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ankana");
		driver.findElement(By.id("input-lastname")).sendKeys("Ghosh");
		driver.findElement(By.id("input-email")).sendKeys("ankanaghosh26");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("ankana123");
		driver.findElement(By.id("input-confirm")).sendKeys("ankana123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		
		
		Thread.sleep(3000);
		
		File screenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(screenShot1,new File(System.getProperty("user.dir")+"\\ScreenShot\\sc1Actual.png"));
		
		BufferedImage actualBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\ScreenShot\\sc1Actual.png"));
		
		BufferedImage expectedBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\ScreenShot\\sc1Expected.png"));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, actualBImg);
		
		boolean b = imgDifference.hasDiff();
		System.out.println(b);
		
		
			
	}
	
	

}
