package com.rahulshettyAcademy.senarios;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S3 {

	@Test
	public void senario3() {
		/*
		 * write Automation script for the webtable , search Alex and Ivory dynamically
		 * and validate the price
		 */

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500).build().perform();
		String ivoryPrice = driver
				.findElement(By.xpath(
						"//div[@class='tableFixHead']/table/tbody/tr//td[text()='Ivory']/following-sibling::td[3]"))
				.getText();
		String alexPrice = driver
				.findElement(By.xpath(
						"//div[@class='tableFixHead']/table/tbody/tr//td[text()='Alex']/following-sibling::td[3]"))
				.getText();
		int aPrice = Integer.parseInt(alexPrice);
		int iPrice = Integer.parseInt(ivoryPrice);
		assertEquals(iPrice, 18, "not match");
		assertEquals(aPrice, 28, "not match");
		System.out.println(alexPrice);
		System.out.println(ivoryPrice);
	}
}
