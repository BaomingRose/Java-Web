# Customer Manager
注：MVC设计模式，M为一个普通的类（提供了Customer的属性，还有setter和getter），通过jsp文件展示用户视图，通过Servlet类控制逻辑。<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过浏览器首先访问initCustomer.jsp，展示给用户初始界面，其中有查询选项、插入选项、和全部显示选项。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查询选项：为一个表单，提过一个text文本框，通过输入用户ID，点击查询按钮（submit控件），则访问SelectCustomerServlet类，逻辑为访问数据库中的Customer所有信息传递给request传递到displayCustomer.jsp将客户信息展示给用户。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;插入选项：一个超链接，直接访问InsertCustomerServlet，处理逻辑为插入数据到数据库。插入成功则重定向到initCustomer.jsp。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全部显示：也是一个超链接，首先访问到ShowAllCustomers（Servlet），处理逻辑为访问数据库中表中所有数据，然后重定向到showCustmer.jsp展示给用户所有数据。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其中全部显示的数据表格中，有两个列分别为删除和修改，在每个数据的后面。<br/>
全部显示showCustmer.jsp的代码如下：<br/>
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr><td>客户ID</td><td>客户名</td><td>邮箱</td>
			<td>余额</td><td>修改</td><td>删除</td>
		</tr>
		<c:forEach var="customer" items="${customerList}" >
   		<tr><td>${customer.id}</td>
       		<td>${customer.name}</td>
       		<td>${customer.email}</td>
       		<td>${customer.balance}</td>
       		<td><a href="ActionServlet?id=${customer.name}&method=alter">修改</a></td>
       		<td><a href="ActionServlet?id=${customer.name}&method=delete">删除</a></td>
       	</tr>
		</c:forEach>
	</table>
</body>
</html>
```
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;观察上面的修改和删除行，链接的url的查询参数是ActionServlet.java区分修改和删除的重要参数,其中通过id将要删除的名字传给处理逻辑，通过method来判断是删除还是修改，ActionServlet.java的doGET方法就是处理修改或者删除<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如果是删除，则实行删除逻辑，然后重定向到ShowAllCustomers（Servlet），再展示给用户删除后的数据。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这里的修改界面没有实现：如果是修改则重定向到修改界面，然后提交修改的信息在创建一个处理修改逻辑的Servlet类。
