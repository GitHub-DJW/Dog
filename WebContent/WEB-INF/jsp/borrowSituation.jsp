<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@page import="java.util.List"%>
<%@page import="model.Book" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
   
 
<div style="width:100%;text-align:center">
<table border="1" align="center">
  <tr>
    <th>BookNo</th>   
    <th>BookName</th> 
    <th>Author</th> 
    <th>Publishers</th>
    <th>BorrowDate</th> 
    <th>RemainDay</th>
    
  </tr>

<% List<Object[]> borrowBookList = (List<Object[]>)request.getAttribute("borrowBookList"); 
   
   Date today = new Date();
  

   for(Object[] obj :borrowBookList)    
    { 
    	Date borrowDate = (Date) obj[4];
		long useDay = today.getTime() / 86400000 - borrowDate.getTime() / 86400000;
    
     %>
	   <tr>
	           <td><%=obj[0] %></td>
	           <td><%=obj[1] %></td>
	           <td><%=obj[2] %></td>
	           <td><%=obj[3] %></td>
	           <td><%=obj[4] %></td>
	           <td><%=60 - useDay %></td>
	   </tr>
	   <% 
   }

%>
</table> 
</div> 
</body>
</html>