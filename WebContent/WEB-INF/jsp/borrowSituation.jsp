<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@page import="java.util.List"%>
<%@page import="model.Book" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
   
 
<div style="width:100%;text-align:center">
<table border="1" align="center">
  <tr><th>BookName</th> 
    <th>Author</th> 
    <th>Publishers</th>
    <th>RetrievalNo</th> 
    <th>BookNumber</th> 
    <th>RemainingBookNumber</th>
  </tr>

<% List<Book> bookList = (List<Book>)request.getAttribute("borrowBookList"); 
   
for(int i = 0; i < bookList.size(); i++) {
	   Book book = (Book)bookList.get(i);
	   %>
	    
	       <tr><td><%=book.getBookName()%></td>
	           <td><%=book.getAuthor()%>  </td>
	           <td><%=book.getPublishers() %></td>
	           <td><%=book.getRetrievalNo() %></td>
	           <td><%=book.getBookNumber() %></td>
	           <td><%=book.getRemainingBookNumber() %></td>
	       </tr>
	    
   
	   <% 
   }

%>
</table> 
</div> 
</body>
</html>