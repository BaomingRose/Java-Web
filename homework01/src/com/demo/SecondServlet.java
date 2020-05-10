package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		Student student = (Student)request.getAttribute("student");
		String sno = student.getSno();
		String name = student.getName();
		
		PrintWriter out = response.getWriter();
		out.println(sno);
		out.println("<br/>");
		out.println(name);
		out.println("<script type = \"text/javascript\">");
		out.println("setTimeout(\"history.back();\", 5000);");
		out.println("</script>");
	}

}
