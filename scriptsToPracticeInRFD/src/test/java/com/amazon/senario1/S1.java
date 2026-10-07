package com.amazon.senario1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S1 {

	
	@Test
	public void amazonS1(){
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("earpods");
		 driver.findElement(By.id("nav-search-submit-button")).click();
		 List<WebElement> listOfEarpods=driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/div/a"));
		 for (WebElement webElement : listOfEarpods) {
			 String titleofProducts= webElement.getText();
			if(titleofProducts.contains("earpods")) {
				System.out.println(titleofProducts);
			}else {
				System.out.println("item not found");
			}
		}

	}
}
