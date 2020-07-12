package com.rose.bookstore.controller;

import com.rose.bookstore.dao.BookDao;
import com.rose.bookstore.dao.UserDao;
import com.rose.bookstore.pojo.Book;
import com.rose.bookstore.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ShowBooksController {
    @Autowired(required = false)
    private BookDao bookDao;

    @Autowired(required = false)
    private UserDao userDao;

    private boolean isLoged(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if (user == null) {
            return false;
        }
        return true;
    }

    @RequestMapping("bookstore/bookdatas")
    public String showData(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String page_str = request.getParameter("page");
        if (page_str == null) {
            //System.out.println("page_str == null");
            page_str = "0";
        }
        int page = 0;
        try {
            page = Integer.parseInt(page_str);
        } catch (Exception e) {
            System.out.println(e);
            page = 0;
        }
        if (page < 0) {
            page = 0;
        }
        model.addAttribute("page", page);

        ArrayList<Book> list_books = null;
        try {
            list_books = bookDao.queryRangeBooks(page * 15);
            /*
            for (int i = 0; i < list_books.size(); ++i) {
                System.out.println(list_books.get(i));
            }
            */
            model.addAttribute("booklist", list_books);
        } catch (Exception e) {
            System.out.println(e);
            page = 0;
            model.addAttribute("page", page);
            try {
                response.sendRedirect("bookstore/bookdatas?page=0");
            } catch (IOException ioe) {
                System.out.println(ioe);
                return "login";
            }
        }

        if (user == null) {
            // System.out.println("user == null");
            return "showBooksUnlog";
        } else {
            model.addAttribute("user", user);
        }

        return "showBooksLoged";
    }

    @RequestMapping("bookstore/usrQueryVague")
    public String queryVague(@Param("search_str")String search_str, HttpServletRequest request, Model model) {
        ArrayList<Book> book_list =  bookDao.queryVague(search_str);
        model.addAttribute("booklist", book_list);
        model.addAttribute("page", 0);

        if (isLoged(request)) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            model.addAttribute("user", user);
            return "showBooksLoged";
        } else {
            return "showBooksUnLog";
        }
    }

    @RequestMapping("bookstore/showDetail")
    public String showDetail(@Param("book_id")String book_id, @Param("book_name")String book_name, @Param("book_author")String book_author, @Param("book_publisher")String book_publisher, @Param("book_price")String book_price, @Param("book_category")String book_category, Model model) {
        Book book = new Book(Integer.parseInt(book_id), book_name, book_author, book_publisher, Double.parseDouble(book_price), book_category);
        model.addAttribute("book", book);

        return "show_single_detail";
    }

    @RequestMapping("bookstore/byCategory")
    public String queryByCategory(@Param("category")String category, Model model, HttpServletRequest request) {
        model.addAttribute("page", 0);
        ArrayList<Book> book_list =  bookDao.queryByCategory(category);
        model.addAttribute("booklist", book_list);

        if (isLoged(request)) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            model.addAttribute("user", user);
            return "showBooksLoged";
        }

        return "showBooksUnLog";
    }
}
