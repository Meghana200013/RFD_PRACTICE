package com.amazon.senario1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6 {

	@Test
	public void senario6(){
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");	
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> brand=driver.findElements(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a/span[contains(text(),'Apple')]"));
		if(brand.isEmpty()) {
			WebElement brandopt=driver.findElement(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a"));
			String checkedopt=brandopt.getText();
			System.out.println(checkedopt);
			brandopt.click();
			List<WebElement> brand1=brand;
			if(!brand1.isEmpty()) {
				brand1.get(0).click();
				driver.findElement(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a/span[contains(text(),'"+checkedopt+"')]")).click();
			}else {
				driver.findElement(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a[@aria-label='See more, Brands']")).click();
				driver.findElement(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a/span[contains(text(),'Apple')]")).click();
				driver.findElement(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a/span[contains(text(),'"+checkedopt+"')]")).click();
			}
		}else{
			driver.findElement(By.xpath("//div[@id='p_123-title']/following-sibling::ul/descendant::a/span[contains(text(),'Apple')]")).click();
		}
		
		WebElement color=driver.findElement(By.xpath("//span[text()='Colour']/parent::div/following-sibling::ul/descendant::a[@title='Black']"));
		Actions act =new Actions(driver);
		act.scrollToElement(color).build().perform();
		act.click(color).build().perform();
		
		//driver.findElement(By.xpath("//div[@data-cy='title-recipe']/descendant::span[contains(text(),'iPhone 18 Pro (1 TB)')]")).click();
		
		
	}
}
