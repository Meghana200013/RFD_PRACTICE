package com.amazon.senario1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S4 {
	@Test
	public void senario4(){
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.amazon.in/");
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 17");
	 driver.findElement(By.id("nav-search-submit-button")).click();
	 driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-3 s-link-style a-text-normal']")).click();
	 Set<String> windows=driver.getWindowHandles();
	 for(String window:windows) {
		 driver.switchTo().window(window);
		    List<WebElement> elements =driver.findElements(By.xpath("//span[text()='With Exchange']"));

		    if (!elements.isEmpty() && elements.get(0).isEnabled()) {
		    	elements.get(0).click();
		    	WebElement selectOption=driver.findElement(By.id("chooseButton-announce"));
		        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(selectOption));
		        driver.findElement(By.id("chooseButton")).click();
		        WebElement brand=driver.findElement(By.id("buyBackDropDown1"));
		        Select sel=new Select(brand);
		        sel.selectByValue("Samsung");
		        WebElement model=driver.findElement(By.id("Samsung"));
		        Select sel1=new Select(model);
		        sel1.selectByContainsVisibleText("S24 5G");
		        WebElement storage=driver.findElement(By.xpath("//select[contains(@id,'S24 5G')]"));
		        Select sel2=new Select(storage);
		        sel2.selectByContainsVisibleText("512GB");
		        Actions a=new Actions(driver);
		        WebElement noDamageCheckBox=driver.findElement(By.id("noBodyDamageCheckbox"));
		        a.click(noDamageCheckBox).build().perform();
		        WebElement continueButton=driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
		        a.click(continueButton).build().perform();
		        break;
		    }
	}
	}
}
