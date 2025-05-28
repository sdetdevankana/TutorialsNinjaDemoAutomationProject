package tutorialsNinja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_009 {

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
		
		
		
		driver.quit();		
	}
	
	

}
