<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2 align="center">Return Book</h2>
<div style="width:100%;text-align:center ">
  <form action="returnDeal">
  <table border="1" align="center"> 
   <tr><th>BookNo</th>
       <th>UserNo</th>
   </tr>
   <tr><td><input type="text" name="returnBookNo"/> </td>
       <td><input type="text" name="userNo"/> </td>
   </tr>
   <tr><td> <input type="submit" value="submit"/></td>
   </tr>    
  </table>
   <%
	 String returnSucceed = (String) request.getAttribute("returnSucceed");
     String errorMessage = (String)request.getAttribute("errorMessage"); 
	 if(returnSucceed != null) {
		 %> <p align="center">  <%=returnSucceed %> </p>     
		  <% 
	 }
	 
	 if(errorMessage!= null) {
		    %> <p align="center">  <%=errorMessage %> </p>     
		  <% 
		  }  
    %>
   
                   
  </form>
  
</div>
</body>
</html>