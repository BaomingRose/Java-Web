package com.rose.bookstore.controller;

import com.rose.bookstore.dao.BookDao;
import com.rose.bookstore.pojo.Book;
import com.rose.bookstore.pojo.BookItem;
import com.rose.bookstore.pojo.Cart;
import com.rose.bookstore.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class CartController {
    @Autowired(required = false)
    private BookDao bookDao;

    @RequestMapping("bookstore/shopping_cart")
    public String showCart(HttpSession session, Model model) {
        Cart cart = (Cart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        if (cart == null) {
            return "show_null_cart";
        }
        if (user == null) {
            return "login";
        }

        double total = cart.getTotal();
        Collection<BookItem> bookitems = cart.getItems();
        model.addAttribute("bookitems", bookitems);
        model.addAttribute("user", user);
        model.addAttribute("total", total);

        return "show_cart";
    }

    @RequestMapping("bookstore/add_cart")
    public String addCart(@Param("book_num")String book_num, @Param("book_id")String book_id, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if (user == null) {
            return "login";
        }

        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        Book book = bookDao.queryById(Integer.parseInt(book_id));
        BookItem bookItem = new BookItem(book, Integer.parseInt(book_num));
        cart.add(bookItem);
        session.setAttribute("cart", cart);

        return "forward:/bookstore/shopping_cart";
    }

    @RequestMapping("bookstore/remove_cart")
    public String remove_cart(@Param("book_id")String book_id, HttpSession session) {

        Cart cart = (Cart)session.getAttribute("cart");
        cart.remove(Integer.parseInt(book_id));

        return "forward:/bookstore/shopping_cart";
    }
}
