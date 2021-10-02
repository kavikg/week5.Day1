package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends SnowincidentBaseclass {
	@Test
	public void runDeleteIncident() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("(//div[contains(text(),'Incidents')])[3]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@id='incident_table_header_search_control'])[1]")).sendKeys("INC0010018",
				Keys.ENTER);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//tr//td[3]/a")).click();
		driver.findElement(
				By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[3]")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr")).getText();
		System.out.println(text);
		if (text.contains("No records to display")) {
			System.out.println("Incident is deleted Successfully");
		} else
			System.out.println("Incident is not deleted");

	}

}
