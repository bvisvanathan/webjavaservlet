package com.balaji.automatedtests;

import org.sikuli.script.*;
import org.sikuli.*;

//import java.util.Iterator;
//import java.util.Set;

//import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SikuliTest {
	public static void main(String[] args) throws InterruptedException, FindFailed {									
		System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();			
        		
        //Launching the site.				
        driver.get("http://google.com");			
        driver.manage().window().maximize();
        
        Screen screen = new Screen();
        Pattern image1= new Pattern("/home/balajivisvanath/sikuli/google.sikuli/Gmail.png");
        Pattern image2= new Pattern("/home/balajivisvanath/sikuli/google.sikuli/Signir.png");
        
        //Pattern image3= new Pattern("/Users/nagen/Desktop/UserID.png");
        //Pattern image4= new Pattern("/Users/nagen/Desktop/NextButton.png");
       // Pattern image5= new Pattern("/Users/nagen/Desktop/password.png");
        
        screen.wait(image1,3);
        screen.click(image1);
        screen.wait(image2,3);
        screen.click(image2);
       /* screen.wait(image3, 3);
        screen.type(image3, "test@test.com");
        screen.wait(image4, 3);
        screen.click(image4);
        screen.wait(image5, 3);
        screen.type(image5, "password");*/
        		
        
	}
}