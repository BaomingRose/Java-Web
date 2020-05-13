<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr><td>客户ID</td><td>客户名</td><td>邮箱</td>
			<td>余额</td><td>修改</td><td>删除</td>
		</tr>
		
		<c:forEach var="customer" items="${customerList}" >
   		<tr><td>${customer.id}</td>
       		<td>${customer.name}</td>
       		<td>${customer.email}</td>
       		<td>${customer.balance}</td>
       		<td><a href="ActionServlet?id=${customer.name}&method=alter">修改</a></td>
       		<td><a href="ActionServlet?id=${customer.name}&method=delete">删除</a></td>
       	</tr>
		</c:forEach>
	</table>

</body>
</html>