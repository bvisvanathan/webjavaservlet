package com.balaji.automatedtests;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.*;		

public class RadioButtonTest {				
    public static void main(String[] args) {									
    		
    	// declaration and instantiation of objects/variables		
    	System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        driver.get("http://demo.guru99.com/test/radio.html");
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,1000)");
       // driver.findElement(By.id("closeBtn")).click();
        //driver.findElement(By.xpath("//*[@id=\"closeBtn\"]")).click();
        
      
        
        
        
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
        		
        //Radio Button1 is selected		
        radio1.click();			
        System.out.println("Radio Button Option 1 Selected");					
        try {Thread.sleep(2000);} catch(Exception e1) {}
        //Radio Button1 is de-selected and Radio Button2 is selected		
        radio2.click();			
        System.out.println("Radio Button Option 2 Selected");	
        
        if(radio2.isDisplayed()) {
        	System.out.println("radio2 is displayed");
        }
        		
        // Selecting CheckBox		
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

        // This will Toggle the Check box 		
        option1.click();	
        try {Thread.sleep(2000);} catch(Exception e1) {}
        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }		
        try {Thread.sleep(2000);} catch(Exception e1) {}
        
        if(option1.isDisplayed()) {
        	System.out.println("option1 is displayed");
        }
        
		driver.close();		
    }  	
}
    	