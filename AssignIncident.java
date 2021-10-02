package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident extends SnowincidentBaseclass {
	@Test
	public void runAssignIncident() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("(//div[contains(text(),'Open')])[1]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//input[@id='incident_table_header_search_control'])[1]")).sendKeys("INC0010011",
				Keys.ENTER);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//tr//td[3]/a")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).clear();
		driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).sendKeys("Hardware");
		driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']")).clear();
		driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.incident.assigned_to']")).sendKeys("David Dan", Keys.TAB);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).click();
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("WorkNotes");
		driver.findElement(By.xpath("(//button[text() ='Update'])[1]")).click();
		String Groupvalue = driver.findElement(By.xpath("//table//tbody[@class='list2_body']//tr//td[11]")).getText();
		String Assignedvalue = driver.findElement(By.xpath("//table//tbody[@class='list2_body']//tr//td[12]"))
				.getText();
		if (Groupvalue.contains("Hardware")) {
			System.out.println("Selected group value is displayed as expected");
		} else
			System.out.println("Selected group value is not displayed as expected");
		if (Assignedvalue.contains("David")) {
			System.out.println("Selected Assigned value is displayed as expected");
		} else
			System.out.println("Selected Assigned value is not displayed as expected");

	}

}
