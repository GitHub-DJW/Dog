<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	 String deleteSucceed = (String) request.getAttribute("deleteSucceed");
     String errorMessage = (String)request.getAttribute("errorMessage"); 
     if(deleteSucceed != null) {
		 %><p align="center"><%=deleteSucceed%></p>  <%
	 }
	 
	 if(errorMessage!= null) {
		    %> <p align="center">  <%=errorMessage %> </p>     
		  <% 
		  }  
%>

  <div style="width:100%; align-text:center">
 <form action="deleteStaffDeal">
 <table border="1" align="center">
    <tr><th>StaffName</th>
            
    </tr>
    <tr><td><input type="text" name="staffName"/></td>
        
    </tr> 
    <tr><td><input type="submit" name="Submit" value="Delete"/></td>   
 </table>
 </form>
 
	 
</div>
</body>
</html>