package com.fametronics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	
final static long serialVersionUID = 1L;
	
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
				
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fametronics","root","@123abhi");
			PreparedStatement ps = con.prepareStatement("insert into UserDetails(name, email, phone, password) values (?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, password);
			
			int j = ps.executeUpdate();
			if(j>0) {
				writer.print("Registered successfully");
			}
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");          
		    rs.forward(request, response);  
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
