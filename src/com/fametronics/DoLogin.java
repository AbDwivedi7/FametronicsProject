package com.fametronics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fametronics","root","@123abhi");
			PreparedStatement ps = con.prepareStatement("select * from UserDetails where email=?");
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			
			ArrayList<User> list = new ArrayList<User>();
			
			if(rs.next()) {
				if(password.equals(rs.getString("password"))) {
					
					
				
						 User UserDAO = new User();
						 String name = rs.getString("name");
						 UserDAO.setName(name);
						 String email1 = rs.getString("email");
						 UserDAO.setEmail(email1);
						 String phone = rs.getString("phone");
						 UserDAO.setPhone(phone);
						 list.add(UserDAO);	
					
						
					
				}
			}
			 request.setAttribute("data", list);
			 RequestDispatcher rd = request.getRequestDispatcher("home.jsp");          
			 rd.forward(request, response);  


		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
