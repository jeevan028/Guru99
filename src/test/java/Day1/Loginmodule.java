package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginmodule {

	@Test
	public void login() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr423708");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("EsygUgy");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();

	}

}
