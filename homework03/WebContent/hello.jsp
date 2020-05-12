<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 方法一： -->
	<%! String userName; %>
	<%
		userName = request.getParameter("userName");
	%>

	
	<!-- 方法二： -->
	<%
		userName = request.getParameter("userName");
		pageContext.setAttribute("userName", userName);
	%>
	
	<%@ include file="response.jsp" %>
</body>
</html>