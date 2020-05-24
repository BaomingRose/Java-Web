<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加客户</title>
</head>
<body>
	<form action = "InsertCustomerServlet" method = "post">
		<table>
		<tr><td>客户ID：</td>
			<td><input type="text" name="id"></td>
		</tr>
		
		<tr><td>客户名： </td>
			<td><input type="text" name="name"></td>
		</tr>
		
		<tr><td>邮箱： </td>
			<td><input type="text" name="email"></td>
		</tr>

		<tr><td>余额：</td>
			<td><input type="text" name="balance"></td>
		</tr>
	
		<tr><td></td><td><input type="submit" value="添加"></td></tr>
		</table>
	</form>	

</body>
</html>