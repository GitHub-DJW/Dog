<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LibrarySystem</title>
</head>

<% 
  
    if(session.isNew()) {
	out.println("Please login first");
	
   }
   else {
	   String loginName = (String)request.getAttribute("loginName");
	   session.setAttribute("loginName", loginName);
	  
   }
	
	
	
  %>
<body>
<center>
<h2>Login Succeed !<br />
    Welcome ${loginName}
</h2>
<a href="UserInterface.html">Click to the MainPage </a>
</center>
</body>
</html>