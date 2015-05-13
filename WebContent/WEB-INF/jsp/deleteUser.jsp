<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div style="width:100%; align-text:center">
 <form action="deleteUserDeal">
 <table border="1" align="center">
    <tr><th>UserName</th>
            
    </tr>
    <tr><td><input type="text" name="userName"/></td>
        
    </tr> 
    <tr><td><input type="submit" name="Submit" value="Delete"/></td>   
 </table>
 </form>
 <%
	 String deleteSucceed = (String) request.getAttribute("deleteSucceed");
	 if(deleteSucceed != null) {
		 out.println(deleteSucceed);
	 }
	 %>
</div>
</body>
</html>