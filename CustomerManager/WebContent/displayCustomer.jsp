<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="customer" type="com.model.Customer" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户信息</title>
</head>
<body>
	<table>
		<tr><td>客户ID：</td>
			<td><jsp:getProperty name="customer" property="id" /></td>
		</tr>
		
		<tr><td>客户名： </td>
			<td><jsp:getProperty name="customer" property="name" /></td>
		</tr>
		
		<tr><td>邮箱： </td>
			<td><jsp:getProperty name="customer" property="email" /></td>
		</tr>

		<tr><td>余额：</td>
			<td><jsp:getProperty name="customer" property="balance" /></td>
		</tr>
		<tr><td></td><td><a href="initCustomer.jsp">返回</a></td></tr>
	</table>
</body>
</html>