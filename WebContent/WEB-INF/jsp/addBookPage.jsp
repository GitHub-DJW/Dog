<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div style="width:100%; align-text:center">
 <form action="addBookDeal">
 <table border="1" align="center">
    <tr><th>BookName</th>
        <th>Author</th>
        <th>Publishers</th>
        <th>RetrievalNo</th>
        <th>BookNumber</th>
    </tr>
    <tr><td><input type="text" name="bookName"/></td>
        <td><input type="text" name="author"/></td>
        <td><input type="text" name="publishers"/></td>
        <td><input type="text" name="retrievalNo"/></td>
        <td><input type="text" name="bookNumber"/></td> 
    </tr> 
    <tr><td><input type="submit" name="Submit"/></td>   
 </table>
 </form>
 <%
	 String addSucceed = (String) request.getAttribute("addSucceed");
	 if(addSucceed != null) {
		 out.println(addSucceed);
	 }
	 %>
</div>
</body>
</html>