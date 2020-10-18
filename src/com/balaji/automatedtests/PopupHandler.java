package com.balaji.automatedtests;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;		

public class PopupHandler {				

    public static void main(String[] args) throws InterruptedException {									
    	System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();			
        		
        //Launching the site.				
        driver.get("http://demo.guru99.com/popup.php");			
        driver.manage().window().maximize();		
                		
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
        		
        String MainWindow=driver.getWindowHandle();		
        		
        // To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();	
        WebDriverWait wait = new WebDriverWait(driver,3000);
        
        FluentWait<WebDriver> waitflu = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
        		.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        
        WebElement ele = waitflu.until(new Function<WebDriver, WebElement>()

        {

        public WebElement apply(WebDriver driver)

                    {         

        WebElement elementtest = driver.findElement(By.name("emailid"));

        //String getTextOnPage = element.getText();
        return elementtest;
                    }
        });
        
       
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);                   
                    
                    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("emailid")));
                    email.sendKeys("simplilearn@simplilearn.com");
                    //driver.findElement(By.name("emailid")).sendKeys("simplilearn@simplilearn.com");                			
                    //Thread.sleep(5000);
                    WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnLogin")));
                    login.click();
                    //driver.findElement(By.name("btnLogin")).click();			
                    Thread.sleep(5000);             
			// Closing the Child Window.
                        driver.close();		
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);				
    }
}		
