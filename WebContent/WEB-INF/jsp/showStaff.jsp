<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>    
<%@page import="model.Staff" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<% List<Staff> staffList = (List<Staff>)request.getAttribute("staffList"); %>
<table border="1" align="center">
 <tr><th>StaffNo</th>
     <th>StaffName</th>
 </tr>
 <%           
    for(int i = 0; i < staffList.size(); i++) {
    	Staff staff = staffList.get(i);
    	%><tr><td><%=staff.getStaffNo() %></td>
    	      <td><%=staff.getStaffName() %></td>
    	  </tr>  
    	  
        <% 	    
    }
    
 
 %>
        
</table>
</body>
</html>