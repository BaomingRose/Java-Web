<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deal</title>
</head>
<body>
	<%
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		if (username.equals("yuming") && password.equals("11")) {
			session.setAttribute("username", username);
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>