<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>登录页面</title>
</head>

<body>
	<%= (String)session.getAttribute("message") %>
	<form action="CheckUserServlet" method="post">
    	<table>
    		<tr> <td>用户名:</td><td><input type="text" name="username"/></td>	</tr>
    		<tr> <td>密码:</td><td><input type="password" name="password"/></td> </tr>
    		<tr> <td colspan="2"> <input type="checkbox" name="check"/>自动登录 <br/>
    					  		  <input type="submit" value="登录"/> </td></tr>
    	</table>
	</form>
</body>

</html>

