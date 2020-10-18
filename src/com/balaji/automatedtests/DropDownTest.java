package com.balaji.automatedtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DropDownTest {
 public static void main(String[] args) { 
	 System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
	 	WebDriver driver = new ChromeDriver();
	 	JavascriptExecutor js = (JavascriptExecutor) driver;
	    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
	    
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		js.executeScript("window.scrollBy(0,1000)");

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("BAHAMAS");
		System.out.println("Selected Bahamas");

		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(3);
		

		//Select select = new Select(element);
		List<WebElement> selectedOptions = fruits.getAllSelectedOptions();
		for(WebElement selectedOption : selectedOptions) {
		  System.out.println(selectedOption.getText());
		}
		fruits.deselectByIndex(3);
		fruits.selectByIndex(2);
 }
}