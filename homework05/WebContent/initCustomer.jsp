<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询客户</title>
</head>
<body>
	<form action = "SelectCustomerServlet" method="post">
      	请输入客户ID：
  		<input type = "text" name="id" size="15">
  		<input type = "submit" value = "确定">
	</form>
	<a href = "insertCustomer.jsp">插入数据</a>
	<br/>
	<a href = "ShowAllCustomers">显示所有</a>
</body>
</html>