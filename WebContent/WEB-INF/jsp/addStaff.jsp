<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<div style="width:100%; align-text:center">
 <form action="addStaffDeal">
 <table border="1" align="center">
    <tr><th>StaffName</th>
            
    </tr>
    <tr><td><input type="text" name="staffName"/></td>
        
    </tr> 
    <tr><td><input type="submit" name="Submit" value="Add"/></td>   
 </table>
 </form>
    <%
	 String addSucceed = (String) request.getAttribute("addSucceed");
	 if(addSucceed != null) {
		 %><p align="center"><%=addSucceed%></p>  <%
	 }
	 %>
</div>

</body>
</html>