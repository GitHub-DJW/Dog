<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<h2 align="center">Borrow Book</h2>
<div style="width:100%;text-align:center ">
  <form action="borrowDeal">
  <table border="1" align="center"> 
   <tr><th>BookNo</th>
       <th>UserNo</th>
   </tr>
   <tr><td><input type="text" name="borrowBookNo"/> </td>
       <td><input type="text" name="userNo"/> </td>
   </tr>
   <tr><td> <input type="submit" value="submit"/></td>
   </tr>    
  </table>
   <%
	 String borrowSucceed = (String) request.getAttribute("borrowSucceed");
	 if(borrowSucceed != null) {
		 out.println(borrowSucceed);
	 }
   %>
                   
  </form>
  
</div>
</body>
</html>