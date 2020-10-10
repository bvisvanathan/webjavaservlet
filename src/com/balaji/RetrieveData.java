package com.balaji;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 


// Servlet Name 
@WebServlet("/RetrieveData") 
public class RetrieveData extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		PrintWriter out = null;
		try { 

			// Initialize the database 
			con = DatabaseConnection.initializeDatabase(); 

			String query1 = "Select * from cars_tbl";
			try {
				
				 stmt = con.createStatement();
				 rs = stmt.executeQuery(query1);
				// Set response content type
			      response.setContentType("text/html");
			      
			      
				out = response.getWriter();
			      String output = "";
				while (rs.next()) {
					output = "Car Registration: " +rs.getString("car_regn")+", Car Model: "+ rs.getString("car_model")+ ", Car Color: " + rs.getString("car_color")+", Kms run: "+rs.getInt("car_mileage");
					out.println("<br/>"+ output  + "<br/>");
				}
				stmt.close(); 
				con.close(); 
				rs.close();
				out.close();
				}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
		
	} 
} 
