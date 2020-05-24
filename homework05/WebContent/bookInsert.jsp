<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "BookInsertServlet" method = "post">
	<table>
	<tr><td>书号：</td>
		<td><input type="text" name="id"></td>
	</tr>
		
	<tr><td>书名： </td>
		<td><input type="text" name="title"></td>
	</tr>
		
	<tr><td>作者： </td>
		<td><input type="text" name="author"></td>
	</tr>

	<tr><td>出版社：</td>
		<td><input type="text" name="publisher"></td>
	</tr>
		
	<tr><td>价格：</td>
		<td><input type="text" name="price"></td>
	</tr>
	
	<tr><td></td><td><input type="submit" value="添加"></td></tr>
	</table>
</form>	

</body>
</html>