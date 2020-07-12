package com.rose.bookstore.controller;

import com.rose.bookstore.dao.BookDao;
import com.rose.bookstore.pojo.Book;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AdminActionController {
    @Autowired(required = false)
    private BookDao bookDao;

    @RequestMapping("bookstore/admin_queryAllBooks")
    public String queryAllBooks(HttpServletRequest request, Model model) {
        HttpSession session =  request.getSession();
        String userid = (String)session.getAttribute("userid");
        String password = (String)session.getAttribute("password");
        if (userid == null || password == null) {
            return "";
        }

        ArrayList<Book> book_list = bookDao.queryAllBooks();
        model.addAttribute("book_list", book_list);

        return "admin_show_all_books";
    }

    @RequestMapping("bookstore/queryVague")
    public String queryVague(@Param("str_vague")String str_vague, Model model) {
        ArrayList<Book> book_list = bookDao.queryVague(str_vague);
        model.addAttribute("book_list", book_list);

        return "admin_show_all_books";
    }
}
