<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
 
<div style="width:100%;text-aglin:center">
<form action="staffChangePasswordDeal">
<table align="center">
   <tr><td>original password</td>
       <td><input type="password" name="originalPassword"/> </td>
   </tr>
   <tr><td>New Password</td>
       <td><input type="password" name="newPassword"/></td>
   </tr>    
   <tr><td>confirm Password</td>
   <td><input type="password" name="confirmPassword"/></td>
   </tr>
   <tr><td><input type="submit" value="Submit"/></td>
   </tr>
</table>
</form>
<% String errorMessage = (String) request.getAttribute("errorMessage");
    String changeSucceed = (String) request.getAttribute("changeSucceed");
    if(errorMessage != null) {
    	%> <p align="center"><%=errorMessage %> </p>     <% 
    }
 
    if(changeSucceed != null) {
    	%> <p align="center"><%=changeSucceed %> </p>     <% 
    }
 
 %>

</div>
</body>
</html>