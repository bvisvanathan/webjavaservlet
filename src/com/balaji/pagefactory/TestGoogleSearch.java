package com.balaji.pagefactory;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public class TestGoogleSearch {
    public static void main(String[] args) {
        // Create a new instance of a driver
    	System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
    	WebDriver driver = new ChromeDriver();	

        // Navigate to the right place
        //driver.get("http://www.google.com/");

        // Create a new instance of the search page class
        // and initialise any WebElement fields in it.
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        driver.get("http://www.google.com/");

        // And now do the search.
        page.searchFor("weather");
    }
} 
