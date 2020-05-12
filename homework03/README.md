## 作业三 Web组件重用与JavaBean的使用 



1. include静态指令的使用。

编写hello.jsp页面，其中声明一个变量userName，用于获取请求地址后查询串参数userName的值；使用<%@ include>静态指令包含response.jsp页面，通过response.jsp页面显示userName的值，用下面两种方法实现。执行代码并查看运行结果。

方法一：response.jsp页面中通过JSP表达式直接输出变量userName的值。

方法二：通过pageContext作用域属性，在主页面和子页面间共享userName的值，降低主页面和子页面的依赖性。

 

2. \<jsp:include\>动作指令的使用。

编写main.jsp页面，其中声明一个变量userName，用于获取请求地址后查询串参数userName的值；在main.jsp页面中使用\<jsp:include\>动作包含subpage.jsp页面，通过subpage.jsp页面显示userName的值；执行代码并查看运行结果。

//无法显示，分别执行，subpage.jsp没有得到userName的值



3. \<jsp:useBean>、\<jsp:setProperty>、\<jsp:getProperty>动作的使用

从HTML页面login.html中输入用户名和口令等，然后提交给display. jsp页面，在该页面中通过JavaBeans保存数据并输出。

【步骤1】创建UserBean.java，包含username, password, email三个私有数据成员和相应的访问器和设置器。

【步骤2】编写登录页面login.html，部分代码如下，补充关键代码：

```
<html>
<body>
	Please input:\<br>
	<form action=         >


		UserName:<input type="text" name="username"><br>
		Password:<input type="password" name="password"><br>
		Email:<input type="text"name="email"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>
```

【步骤3】编写display.jsp页面，使用JavaBeans显示输入的信息，部分代码如下，补充关键代码：

```
<%@ page import="com.beans.UserBean" %>

​                       

​                       

<html>
<body>
  	UserName:                     <br>
  	Password:                     <br>
  	Email:                       <br>
</body>
</html>

 
```

4. 使用JavaBean构造一个简单的计算器，能够进行“+、—、*、/”运算。

【步骤1】编写实现简单计算器的JavaBean：SimpleCalculator.java，包含first、second、operator、result四个成员变量和相应的访问器与设置器，一个calculator方法根据运算符获取运算结果。

【步骤2】编写calculate.jsp页面，用户通过表单输入两个操作数和运算符，调用该页面自身处理该表单，通过调用SimpleCalculator类的实例实现运算逻辑，并显示运算结果。

 

 