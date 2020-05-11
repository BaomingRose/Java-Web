<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="deal.jsp" method="post">
    	<table>
    	<tr> <td>用户名:</td><td colspan="2"><input type="text" name="userName"/></td></tr>
    	<tr> <td>密码:</td><td colspan="2"><input type="password" name="password"/></td> </tr>
    	<tr> <td></td><td><input type="submit" value="登录"/> </td>
    	 <td><input type="reset" value="清空"/></td>
    	</tr>
    	</table>
	</form>
</body>
</html>