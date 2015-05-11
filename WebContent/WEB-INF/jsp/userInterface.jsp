<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setHeader("P3P","CP=CAO PSA OUR");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LibrarySystem</title>
</head>

<frameset rows="90,*">
   <frame name="userPanel" src="userPanel.html"/>
   <frame name="content" src="searchPage.html"/>

  </frameset>

</html>