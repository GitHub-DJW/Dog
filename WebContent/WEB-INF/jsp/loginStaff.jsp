<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LibrarySystem</title>
</head>
<body>
<h2 align="center">Login</h2>
<% String errorMessage = (String)request.getAttribute("errorMessage"); 

  if(errorMessage!= null) {
     %> <p align="center">  <%=errorMessage %> </p> 
     
     <% 
  }  
	  
	 %>
<div style="width:100%;text-align:center">
<form name="input" action="loginStaffDeal" method="post"  >
 username: <input type="text" name="loginName"/>
 <br />
 password: <input type="password" name="loginPassword"/>
 <br/>  
 libraryStaff <input type="radio" name="loginType" value="libraryStaff" checked="checked"/> 

 systemManger <input type="radio" name="loginType" value="systemManger"/>
 <input type="submit" value="Submit"/>
</form>
</body>
</html>