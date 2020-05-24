package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao2;
import com.dao.DaoException;
import com.model.BookBean;

/**
 * Servlet implementation class BookQueryServlet
 */
@WebServlet("/BookQueryServlet")
public class BookQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String bookid = request.getParameter("bookid");
		BookDao2 dao = new BookDao2();
		BookBean book = null;
		
		try {
			book = dao.findById(bookid);
			//System.out.println(bookid);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (book != null) {
			request.getSession().setAttribute("book", book);
			response.sendRedirect("display.jsp");	
		} else {
			response.sendRedirect("errorPage.jsp");
		}	
	}

}
