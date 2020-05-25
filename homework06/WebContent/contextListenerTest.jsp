<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*,javax.sql.*" %>
<% 
   DataSource dataSource = (DataSource)application.getAttribute("dataSource");
   Connection conn = dataSource.getConnection();
   Statement stmt = conn.createStatement();
   ResultSet rst = stmt.executeQuery("SELECT * FROM books");
%>
<html><head><title>listenerTest</title></head>
<body>
<h4>书籍信息</h4>
	<table border="1">
	<tr><td>书籍号</td><td>书名</td><td>作者</td><td>出版商</td><td>价格</td></tr>
	
	<% while (rst.next()){ %>
		<tr><td><%= rst.getString(1) %></td>
    		<td><%= rst.getString(2) %></td>
    		<td><%= rst.getString(3) %></td>
    		<td><%= rst.getString(4) %></td>
    		<td><%= rst.getDouble(5) %></td>
    	</tr>
	<% } %>
</table>
</body>
</html>
