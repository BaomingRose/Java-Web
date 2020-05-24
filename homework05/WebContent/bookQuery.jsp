<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询书籍</title>
</head>
<body>
	<form action = "BookQueryServlet" method="post">
      	请输入书籍号：
  		<input type = "text" name="bookid" size="15">
  		<input type = "submit" value = "确定">
	</form>
	<a href = "bookInsert.jsp">插入数据</a>
	<br/>
	<a href = "displayBooks.jsp">显示所有</a>
</body>
</html>