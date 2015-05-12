<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<% String loginName =(String) request.getSession().getAttribute("loginName"); %>
 <p align="center"> 
  welcome <%=loginName %> !
 </p>
 
 <p align="center">  
    <a href="borrowPage.html" target="staffContent">  BorrowPage</a>
    <a href="addBookPage.html" target="staffContent">  Add Book</a>
    <a href="exit.html" target="_top"> Exit</a>
 </p>
</body>
</html>