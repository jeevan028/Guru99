package Day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3Dataparameter {
	@Test(dataProvider="data")
	public void main(String uid, String pw) throws IOException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(uid);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pw);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@DataProvider
	public Object[][] data() {
		Object[][] arr=new Object[4][2];
		arr[0][0]="mngr423708";
		arr[0][1]="EsygUgy";

		arr[1][0]="invalid";
		arr[1][1]="EsygUgy";

		arr[2][0]="mngr423708";
		arr[2][1]="invalid";

		arr[3][0]="invalid";
		arr[3][1]="invalid";

		return arr;

	}

}
