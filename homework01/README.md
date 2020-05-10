# 作业一 Servlet技术及应用


### 1．简单的综合应用，掌握Servlet将请求转发给另一个Servlet的方法。

【步骤1】创建一个名为input.html的HTML页面，其中包括一个表单，表单中包含两个文本域，分别供用户输入学号和姓名，该页面也包含提交和重置按钮。

【步骤2】 定义一个名为com.demo.Student类，其中包括学号sno和姓名name两个private的成员变量，定义访问和修改sno和name的方法。

【步骤3】编写名为FirstServlet的Servlet，要求当用户在input.html中输入信息后点击“提交”按钮，请求FirstServlet对其处理。在FirstServlet中使用表单请求参数（学号和姓名）创建一个Student对象并将其作为属性存储在请求作用域中，然后通过请求对象的getRequestDispatcher()方法获得RequestDispatcher()对象，将请求转发到SecondServlet。

【步骤4】在SecondServlet中取出请求作用域中存储的Student对象，并显示输出该学生的学号和姓名，5秒钟之后，自动返回input.html页面。

### 2. 使用ServletConfig检索Servlet的初始化参数。

【步骤1】编写ConfigDemoServlet程序，通过注释为其添加初始化参数email、telephone,在Servlet中读取该servlet的名称和初始化参数email、telephone，并将这两个参数的值在响应的HTML文本中输出。

【步骤3】在浏览器的地址栏中输入下面URL请求该Servlet： http://localhost:8080/ homework01/configDemo.do
  
### 3. 为ServletContext配置初始化参数

在web.xml文件中为当前web应用添加两个名为admin-email和admin-tel的ServletContext初始化参数，在ConfigDemoServlet中获取这两个参数的参数值，使用ServletContext对象将admin-email和admin-tel的参数值写入日志文件中，并查看日志文件。

### 4. 编写一个名为CountServlet的Servlet程序：

1）使用成员变量保存该Servlet被访问的次数，试打开多个浏览器窗口模拟多个用户同时访问该Servlet，观察该Servlet被访问次数的变化。

2）修改该Servlet，通过ServletContext属性保存被多用户同时访问的次数，体会用ServletContext在应用作用域共享数据的方法。

