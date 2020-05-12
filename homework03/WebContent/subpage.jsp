<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subPage</title>
</head>
<body>
	<%! String userName; %>
	<%
		userName = (String)pageContext.getAttribute("userName");
	%>
	<%= userName %>
</body>
</html>