package com.rose.bookstore.controller;

import com.rose.bookstore.dao.BookDao;
import com.rose.bookstore.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ResourceBundle;

@Controller
public class AdminImageBooksController {
    @Autowired(required = false)
    private BookDao bookDao;

    @RequestMapping("bookstore/insertBook")
    public String insertBook() {
        return "admin_insert";
    }

    @RequestMapping(value = "bookstore/insertControl", method = RequestMethod.POST)
    public String insertControl(HttpServletRequest request) throws ServletException, IOException {
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        String publisher = request.getParameter("book_publisher");
        double price = Double.parseDouble(request.getParameter("book_price"));
        String category = request.getParameter("book_category");

        Book book = new Book(0, name, author, publisher, price, category);
        bookDao.insertNewBook(book);

        ///D:/javacode/bookstore/target/classes/
        String path = ResourceUtils.getURL("classpath:").getPath();
        int id = bookDao.getIdLast();
        path = path + "static/img/book_img/" + id + ".jpg";

        //String path = request.getServletContext().getRealPath("/");
        //System.out.println(path);

        Part p = request.getPart("book_img");
        p.write(path);

        return "admin_insert_success";
    }

    @RequestMapping("bookstore/deleteControl")
    public String deleteControl(@Param("book_id")String book_id, HttpServletResponse response) {
        int bookid = Integer.parseInt(book_id);

        bookDao.DeleteBook(bookid);

        return "forward:/bookstore/admin_queryAllBooks";

        /*
        try {
            response.sendRedirect("/bookstore/admin_queryAllBooks");
        } catch (IOException e) {
            System.out.println(e);
        }
        */
    }

    @RequestMapping("bookstore/alterSelect")
    public String alterSelect(@Param("book_id")int book_id, Model model) throws ServletException, IOException{
        Book book = bookDao.queryById(book_id);
        model.addAttribute("book", book);

        return "admin_alter";
    }

    @RequestMapping(value = "bookstore/alterControl", method = RequestMethod.POST)
    public String alterControl(@Param("book_id")String book_id, @Param("book_name")String book_name, @Param("book_author")String book_author, @Param("book_publisher")String book_publisher, @Param("book_price")String book_price, @Param("book_category")String book_category, HttpServletRequest request) throws ServletException, IOException{
        Book book = new Book(Integer.parseInt(book_id), book_name, book_author, book_publisher, Double.parseDouble(book_price), book_category);
        bookDao.ModifyBook(book);

        String path = ResourceUtils.getURL("classpath:").getPath();
        int id = book.getId();
        path = path + "static/img/book_img/" + id + ".jpg";

        Part p = request.getPart("book_img");
        if (p.getSize() > 0) {
            p.write(path);
        }

        return "forward:/bookstore/admin_queryAllBooks";
    }
}
