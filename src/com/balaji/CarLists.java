package com.balaji;

import java.io.PrintWriter;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 

public class CarLists {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
	 	WebDriver wd = new ChromeDriver();	
        wd.get("https://en.wikipedia.org/wiki/List_of_car_brands#India");
        WebElement country = wd.findElement(By.id("India"));
      //*[@id="India"]
        
        List <WebElement>  activebrands = wd.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/ul[38]/li"));
       // activebrands.
        //System.out.println(activebrands.get(0).getText());
        System.out.println("No of cols are : " +activebrands.size());
        List <WebElement>  formerbrands = wd.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/ul[39]/li"));
        System.out.println("No of cols are : " +activebrands.size());
        
       
        
        Connection con = DatabaseConnection.initializeDatabase();
        int i = 0;
        
        for(WebElement row : activebrands){
        	PreparedStatement st = con.prepareStatement("insert into carslist values(?, ?, ?, ?)");
        	st.setInt(1, i);
        	st.setString(2, country.getText());
            st.setString(3, row.getText()); 
            st.setString(4, ""); 
            //st.setInt(4, Integer.valueOf(request.getParameter("mileage")));
        	i++;
        	st.executeUpdate();
        	System.out.println(row.getText());
        	st.close();
        }
        System.out.println("completed");
       
      	con.close();
        
       
        
      //*[@id="mw-content-text"]/div[1]/ul[39]/li
      //*[@id="mw-content-text"]/div[1]/ul[38]/li[1]
		
		// TODO Auto-generated method stub
		//Connection con = DatabaseConnection.initializeDatabase(); 

		// Create a SQL query to insert data into demo table 
		// demo table consists of two columns, so two '?' is used 
		//PreparedStatement st = con.prepareStatement("insert into cars_tbl values(?, ?, ?, ?)"); 

		// For the first parameter, 
		// get the data using request object 
		// sets the data to st pointer 
		//st.setString(1, request.getParameter("regn_num")); 
		//st.setString(2, request.getParameter("model")); 
		//st.setString(3, request.getParameter("color")); 
		//st.setInt(4, Integer.valueOf(request.getParameter("mileage"))); 

		
		// Execute the insert command using executeUpdate() 
		// to make changes in database 
		//st.executeUpdate(); 

		// Close all the connections 
		//st.close(); 
		//con.close(); 

		// Get a writer pointer 
		// to display the successful result 
		/*PrintWriter out = response.getWriter(); 
		out.println("<html><body><b>Successfully Inserted"
					+ "</b></body></html>");*/
		         
        /*//No.of Columns
        List <WebElement>  col = wd.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
        List <WebElement> rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        
      
        
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement baseTable = wd.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed;
		    int i=0;
		    String xp;
		    for (i=1;i<rows.size();i++) {
		    	xp="//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]";
		    	cellIneed = tableRow.findElement(By.xpath(xp));
		    	String valueIneed = cellIneed.getText();
		    	System.out.println("Cell value is : " + valueIneed); 
		    }
		    
		    for(WebElement row : rows){
	        	System.out.println(row.getText());        	
	        }
*/
	}

}
