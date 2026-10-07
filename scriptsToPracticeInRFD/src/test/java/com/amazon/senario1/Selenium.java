package com.amazon.senario1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

		List<WebElement> firstNames = driver.findElements(
		    By.xpath("//table[@class='table table-striped mt-3']//tbody/tr/td[1]"));

		List<WebElement> lastNames = driver.findElements(
		    By.xpath("//table[@class='table table-striped mt-3']//tbody/tr/td[2]"));

		for (int i = 0; i < firstNames.size(); i++) {
		    System.out.println("First Name: " + firstNames.get(i).getText());
		    System.out.println("Last Name : " + lastNames.get(i).getText());
		   
		}

	}
	@Test
	public void spaceAlp() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement text = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		String s="abc";
		for(int i=0;i<s.length();i++) {
			text.sendKeys(s.charAt(i)+" ");
		
		}
	}

}
