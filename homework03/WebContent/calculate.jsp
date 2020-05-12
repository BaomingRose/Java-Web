<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.beans.SimpleCalculator"%>

<jsp:useBean id="calculator" class="com.beans.SimpleCalculator">
    <jsp:setProperty name="calculator" property="*"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calculate.jsp" method="post">
		第一个数：<input type="text" name="first">
		<select name="operator">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		第二个数：<input type="text" name="second">
		<input type="submit" value="计算">
	</form>
	
	<%
		try {
			calculator.cal();
		} catch(Exception e) {
			e.printStackTrace();
		}
	%>
	
	<%= calculator.getResult() %>

</body>
</html>