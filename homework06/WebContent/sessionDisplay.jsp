<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.* " %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>会话监听器</title></head>
<body>
	<table border="1">
    	<c:forEach var="sess" items="${applicationScope.sessionList}">
       		<tr><td><c:out value="${sess.id}" /></td>
            	<td><c:out value="${sess.creationTime}" /></td>
       		</tr>
     	</c:forEach>
	</table>
</body>
</html>
