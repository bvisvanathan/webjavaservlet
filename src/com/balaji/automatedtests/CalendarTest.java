package com.balaji.automatedtests;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarTest {

    

    public static void main(String args[]) {

    	System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();	

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/test/");

        //Find the date time picker control

        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

        //Fill date as mm/dd/yyyy as 22/08/2020

        dateBox.sendKeys("22082020");

        //Press tab to shift focus to time field

        dateBox.sendKeys(Keys.TAB);

        //Fill time as 7:30 PM

        dateBox.sendKeys("0730PM");

    }

    }