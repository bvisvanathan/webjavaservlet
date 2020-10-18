package com.balaji;


import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 


// Servlet Name 
@WebServlet("/CalculateFuelEfficiency") 
public class CalculateFuelEfficiency extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		CallableStatement stmt = null;
		Connection con = null;
		//ResultSet rs = null;
		PrintWriter out = null;
		try { 

			// Initialize the database 
			con = DatabaseConnection.initializeDatabase(); 

			String query1 = "{call CalcFuelEfficiency(?,?)}";
			
			try {
				
				 stmt = con.prepareCall(query1);
				 stmt.setString(1, request.getParameter("regn_num")); 
				 stmt.registerOutParameter(2, Types.FLOAT);
				 stmt.execute();
				// Set response content type
			      response.setContentType("text/html");
			      
			      
				out = response.getWriter();
			      String output = "";
			    
				if (stmt.getFloat(2) > 0) {
					output =  "Expected mileage: " + stmt.getFloat(2);
					out.println("<br/>"+ output  + "<br/>");
				}
				else {
					output =  "Verify the registration number!";
					out.println("<br/>"+ output  + "<br/>");
				}
				stmt.close(); 
				con.close(); 
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
