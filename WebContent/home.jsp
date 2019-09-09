<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.fametronics.User"%> 
<%@ page import="java.util.ArrayList"%>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<% ArrayList<User> userDetails =  (ArrayList<User>)request.getAttribute("data"); %>

<% for(User s: userDetails) {
         
    %>
   
   	
   		Welcome <%=s.getName()%><br/>
   		<%=s.getEmail()%><br/>
   		<%=s.getPhone()%>
   		
     
    
    <% } %>  



</body>
</html>