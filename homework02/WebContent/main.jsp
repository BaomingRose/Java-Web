<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h1>欢迎<%= session.getAttribute("username") %>登陆！！！</h1>
	<br/>
	<br/>
	<br/>
	<a href = "exit.jsp">退出登陆</a>
</body>
</html>