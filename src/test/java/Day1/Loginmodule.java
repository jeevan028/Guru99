package Day1;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginmodule {
	WebDriver driver;

	@BeforeTest
	public void CD() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	@Test
	public void login() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//implicit wait will applicable to all webelements in the webpage it will wait untill the webelement loads
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\jeevan kumar\\eclipse-workspace\\Guru99\\Data.properties");
		pro.load(fis);
		driver.get(pro.getProperty("url"));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(pro.getProperty("uid"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pro.getProperty("pw"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title,"Guru99 Bank Manager HomePage");
		driver.close();
	}

}