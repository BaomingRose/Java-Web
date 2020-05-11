<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>counter</title>
</head>
<body>
	<%
		int count = 0;
		synchronized(application) {
			if (application.getAttribute("times") == null) {
	            count = 1;
	        } else {
	            count = (int)application.getAttribute("times");
	            ++count;
	        }
	        application.setAttribute("times", count);
		}
	%>
	<h1>该页面已经被访问<font color="blue"><%=count%></font>次了！！</h1>
</body>
</html>