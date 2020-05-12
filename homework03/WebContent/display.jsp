<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.beans.UserBean"%>
<%! UserBean user = null; %>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");	
	String password = request.getParameter("password");	
	String email = request.getParameter("email");
	user = new UserBean(username, password, email);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display.jsp</title>
</head>
<body>
	UserName:<%= user.getUsername() %>> <br/>
   	Password:<%= user.getPassword() %> <br/>
    Email:<%= user.getEmail() %> <br/>
</body>
</html>