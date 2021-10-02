package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends SnowincidentBaseclass {
	@Test
	public void runUpdateIncident() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("(//div[contains(text(),'Incidents')])[3]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@id='incident_table_header_search_control'])[1]")).sendKeys("INC0010006",
				Keys.ENTER);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//tr//td[3]/a")).click();
		WebElement Urgency = driver.findElement(By.id("incident.urgency"));
		Select D = new Select(Urgency);
		D.selectByVisibleText("1 - High");
		WebElement State = driver.findElement(By.id("incident.state"));
		Select S = new Select(State);
		S.selectByValue("2");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys("WorkNotes");
		driver.findElement(By.xpath("(//button[text() ='Update'])[1]")).click();
		String Statevalue = driver.findElement(By.xpath("//table//tbody[@class='list2_body']//tr//td[9]")).getText();
		String Urgencyvalue = driver.findElement(By.xpath("//table//tbody[@class='list2_body']//tr//td[8]")).getText();
		if (Urgencyvalue.contains("High")) {
			System.out.println("Selected urgency value is displayed as expected");
		} else
			System.out.println("Selected urgency value is not displayed as expected");
		if (Statevalue.contains("Progress")) {
			System.out.println("Selected state value is displayed as expected");
		} else
			System.out.println("Selected state value is not displayed as expected");

	}

}
