package com.balaji.automatedtests;

import org.apache.commons.io.FileUtils;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class TestScreenShot {

   

    public static void main(String args[]) throws Exception{

    	System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();		

        //goto url

        driver.get("http://images.google.com");

        //Call take screenshot function
      //*[@id="sbtc"]/div/div[2]/input
      //*[@id="sbtc"]/button/div/span/svg
        
        WebElement searchtext = driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div/div[2]/input"));
        searchtext.sendKeys("cars");
        driver.findElement(By.xpath("//*[@id=\"sbtc\"]/button/div/span")).click();
        
        

        TestScreenShot.takeSnapShot(driver, "/home/balajivisvanath/Downloads/test.png") ;     
        Thread.sleep(2000);
        driver.close();
    }

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                
            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }

}

