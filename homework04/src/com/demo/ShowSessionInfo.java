package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSessionInfo
 */
@WebServlet("/ShowSessionInfo")
public class ShowSessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);
		String id = session.getId();
		long creationTime = session.getCreationTime();
		Date date1 = new Date(creationTime);
		long lastAccess = session.getLastAccessedTime();
		Date date2 = new Date(lastAccess);
		int count = 0;
		if (session.getAttribute("count") == null) {
			count = 1;
		} else {
			count = (int)session.getAttribute("count");
			++count;
		}
		session.setAttribute("count", count);
		
		PrintWriter out = response.getWriter();
		out.print("<h1 style=\"text-align: center\">Welcome Back.</h1>");
		out.print("<br/>");
		out.print("<h2 style=\"text-align: center\">Infomation about your session</h2>");
		out.print("<br/>");
		
		//使用align属性不居中，只好使用center标签
		out.println("<center>");
		out.println("<table border=\"1px align=\"center\"\">");
		out.println("<thead style=\"background:yello\">");
	    out.println("<tr>      <th>Info Type</th>      <th>Value</th>    </tr></thead>");
	   
	    out.println("<tbody>");
	    out.println("<tr>   <td>" + "ID" + "</td>   <td>" + id + "</td>  </tr>");
	    //Date的toLocaleString方法年月日时分秒格式
	    out.println("<tr>   <td>" + "Creation Time" + "</td>  <td>" + date1.toLocaleString() + "</td> </tr>");
	    out.println("<tr>   <td>" + "Time of last Access" + "</td>  <td>" + date2.toLocaleString() + "</td> </tr>");
	    out.println("<tr>   <td>" + "Access number" + "</td>  <td>" + count + "</td> </tr>");    
	    out.println("</tbody></table>");
	    out.println("</center>");

	  
	}

}
