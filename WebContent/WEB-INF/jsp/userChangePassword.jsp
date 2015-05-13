<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<% String errorMessage = (String) request.getAttribute("errorMessage");
    String changeSucceed = (String) request.getAttribute("changeSucceed");
    if(errorMessage != null) {
    	%> <p align="center"><%=errorMessage %> </p>     <% 
    }
 
    if(changeSucceed != null) {
    	%> <p align="center"><%=errorMessage %> </p>     <% 
    }
 
 %>

<div style="width:100%;text-aglin:center">
<form action="userChangePasswordDeal">
<ul>
   <li>original password：<input type="text" name="originalPassword"/> </li>
   <li>New Password：<input type="text" name="newPassword"/></li>
   <li>confirm Password<input type="text" name="confirmPassword"/></li>
   <li><input type="submit" value="Submit"/>
</ul>
</form>
</div>
</body>
</html>