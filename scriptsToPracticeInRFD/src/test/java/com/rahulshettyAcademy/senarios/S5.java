package com.rahulshettyAcademy.senarios;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class S5 {
	/* Selenium Script 
	https://rahulshettyacademy.com/seleniumPractise/#/
	Select any product dynamically
	Fetch product price 
	Add product to cart when number of units matches a certain number...calculate price, 
	Then validate the price shown in top right of page
	*/
	
	@Test
	public void Senario5() {
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	 String product="Cucumber";
	 String product_price=driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/..//p[@class='product-price']")).getText();
	 String sPrice=product_price.replaceAll("[^0-9]", "");
	 int price=Integer.parseInt(sPrice);
	 int unit=3;
	 for(int i=1;i<=unit;i++) {
	 driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/..//div[@class='product-action']")).click();
	 }
	 driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	 List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cart-preview active']//li[@class='cart-item']//div[@class='product-info']/p[@class='product-name']"));
	 int total=0;
	 for(WebElement cartproduct:cartProducts){
		String cartP=cartproduct.getText();
	 if(cartP.contains(product)) {
		 String quantityString=driver.findElement(By.xpath("//div[@class='cart-preview active']//li[@class='cart-item']//div[@class='product-info']/p[@class='product-name']/../..//p[@class='quantity']")).getText();
		 System.out.println(quantityString);
		 String quantity=quantityString.replaceAll("[^0-9]", "");
		 int q=Integer.parseInt(quantity);
		 System.out.println(q);
		 total=q*price;
		 String cartProdPrice=driver.findElement(By.xpath("//div[@class='cart-preview active']//li[@class='cart-item']//div[@class='product-info']/p[@class='product-name']/../..//p[@class='amount']")).getText();
		 String sCartProdPrice=cartProdPrice.replaceAll("[^0-9]", "");
		 int actualPrice=Integer.parseInt(sCartProdPrice);
		 System.out.println(total);
		 assertEquals(actualPrice, total,"total ammount differse");
		 
		 break;
	 }
	 }	 
	 
	}
}
