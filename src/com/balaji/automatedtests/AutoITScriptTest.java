package com.balaji.automatedtests;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoITScriptTest {
	private static WebDriver driver;
	
	  public static void main(String[] args) {
	      // declaration and instantiation of objects/variables
	  //	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//	WebDriver driver = new FirefoxDriver();
			//comment the above 2 lines and uncomment below 2 lines to use Chrome
		  System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
		    driver = new ChromeDriver();
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	  	
	      String baseUrl = "http://www.tinyupload.com";
	      
	     
	        
	      
	      
	      // launch  and direct it to the Base URL
	      driver.get(baseUrl);
	     // driver.manage().window().setSize(new Dimension(945, 530));
	     // driver.findElement(By.name("uploaded_file")).click();
	      Actions builder = new Actions(driver);
	       builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();
	      
	    //  js.executeScript("document.querySelector(\"body > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > form > table > tbody > tr:nth-child(2) > td:nth-child(1) > input.pole_plik\").click()");
	      
	      try {
	    	    //driver.manage().window().setSize(new Dimension(755, 716));
	          // driver.findElement(By.name("uploaded_file")).click();
	    	 
	    	   Thread.sleep(2000);
	    	  
	    	  // Runtime.getRuntime().exec("C:\\Users\\nvmur\\Downloads\\TinyFile.exe");
	    	  
	    	   Thread.sleep(3000);
	      
	      }
	      catch (Exception e1) {
	      	e1.printStackTrace();
	      }
	      
	      
	      
	     
	      //close Chrome
	    //  driver.close();
	     
	  }
	  


	}
