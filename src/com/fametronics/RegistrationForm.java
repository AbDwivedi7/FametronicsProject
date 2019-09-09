package com.fametronics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationForm extends HttpServlet{
	
	final static long serialVersionUID = 1L;
	
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		RequestDispatcher rs=request.getRequestDispatcher("registration.jsp");          
	    rs.forward(request, response);  
	}
}
