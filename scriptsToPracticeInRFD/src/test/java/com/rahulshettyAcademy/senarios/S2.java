package com.rahulshettyAcademy.senarios;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S2 {

	@Test
	public void senario2() {
		/*2)write Automation script PractiseTest=rahulshettyacademy url click, 
		 validate assertion for hide and show for textbox.
		 */
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 Actions act=new Actions(driver);
		 act.scrollByAmount(0,500).build().perform();
		 WebElement text=driver.findElement(By.id("displayed-text"));
		
			 driver.findElement(By.id("hide-textbox")).click();
			 boolean displayed=text.isDisplayed();
			 assertFalse(displayed,"text box is displaying");
			 
			 driver.findElement(By.id("show-textbox")).click();
			 boolean displayed1=text.isDisplayed();
			 assertTrue(displayed1,"text box is not displaying");
		 
		 
		 
	}
}
