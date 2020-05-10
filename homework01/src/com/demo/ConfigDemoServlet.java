package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigDemoServlet
 */
@WebServlet(
		urlPatterns = { "/configDemo.do" }, 
		initParams = { 
				@WebInitParam(name = "email", value = "hacker@163.com"), 
				@WebInitParam(name = "telephone", value = "8890123")
		})
public class ConfigDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//2. 使用ServletConfig检索Servlet的初始化参数。
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletConfig config = this.getServletConfig();
		String email = config.getInitParameter("email");
		String phone = config.getInitParameter("telephone");
		String servletName = config.getServletName();
		
		PrintWriter out = response.getWriter();
		
		out.println("Servlet名称：" + servletName);
		out.println("<br/>");
		out.println("Emain地址：" + email);
		out.println("<br/>");
		out.println("电话：" + phone);
		
		//3. 为ServletContext配置初始化参数
		ServletContext context = getServletContext();
		String admin_mail = context.getInitParameter("admin-email");
		context.log(admin_mail);
	}

}
