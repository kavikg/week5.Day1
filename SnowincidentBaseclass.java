package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnowincidentBaseclass {
	public ChromeDriver driver;

	@BeforeMethod
	public void precondition() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev38607.service-now.com/navpage.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement fram = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(fram);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Drithi@20");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		
	}

	@AfterMethod
	public void postcondition() {
		// TODO Auto-generated method stub
		driver.close();
	}

}
