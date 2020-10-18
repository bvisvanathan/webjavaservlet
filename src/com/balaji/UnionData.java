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
@WebServlet("/UnionData") 
public class UnionData extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		CallableStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		PrintWriter out = null;
		try { 

			// Initialize the database 
			con = DatabaseConnection.initializeDatabase(); 

			String query1 = "{call carsnbikes()}";
			try {
				
				 stmt = con.prepareCall(query1);
				 rs = stmt.executeQuery();
				// Set response content type
			      response.setContentType("text/html");
			      
			      
				out = response.getWriter();
			      String output = "";
				while (rs.next()) {
					output = "Label: " +rs.getString(1)+", Registration: "+ rs.getString(2)+ ", Model: " + rs.getString(3)+", Color: " + rs.getString(4);
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
