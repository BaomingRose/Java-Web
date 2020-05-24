<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.BookBean, com.dao.BookDAO, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%! ArrayList<BookBean> bookList = new ArrayList<BookBean>(); %>
<%! BookBean book = new BookBean(); %>

<%
	BookDAO dao = new BookDAO();
	bookList = dao.findAllBookBean();
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>显示所有书籍</title>
</head>
<body>
	<table border="1">
		<tr><td>书号</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>数量</td>
		</tr>
		<%
  			for (int i = 0; i < bookList.size(); ++i) {
  				book = bookList.get(i);
		%>

   		<tr><td><%= book.getId() %></td>
       		<td><%= book.getTitle() %></td>
       		<td><%= book.getAuthor() %></td>
       		<td><%= book.getPublisher() %></td>
       		<td><%= book.getPrice() %></td>
        </tr>
        
		<%
  			}
		%>
</table>

</body>
</html>