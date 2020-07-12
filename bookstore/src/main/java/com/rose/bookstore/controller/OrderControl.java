package com.rose.bookstore.controller;

import com.rose.bookstore.dao.OrderDao;
import com.rose.bookstore.pojo.Cart;
import com.rose.bookstore.pojo.OrderForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class OrderControl {
    @Autowired(required = false)
    private OrderDao orderDao;

    @RequestMapping("bookstore/show_order_submit")
    public String showOrderSubmit(@Param("book_id")String book_id, @Param("book_name")String book_name, @Param("book_num")String book_num, @Param("book_price")String book_price, Model model) {
        model.addAttribute("bookid", book_id);
        model.addAttribute("bookname", book_name);
        model.addAttribute("booknum", book_num);
        model.addAttribute("bookprice", book_price);
        return "show_order";
    }

    @RequestMapping(value = "bookstore/submit_order", method = RequestMethod.POST)
    public String submitOrder(@Param("bookid")String bookid, @Param("bookname")String bookname, @Param("username")String username, @Param("useraddress")String useraddress, @Param("userphone")String userphone, @Param("booknum")String booknum, @Param("bookprice")String bookprice, HttpSession session) {
        int num = Integer.parseInt(booknum);
        OrderForm orderForm = new OrderForm(0, username, useraddress, userphone, Integer.parseInt(bookid), bookname, false, num, Double.parseDouble(bookprice) * num);
        orderDao.insertOrder(orderForm);

        Cart cart = (Cart)session.getAttribute("cart");
        for (int i = 0; i < num; ++i) {
            cart.remove(Integer.parseInt(bookid));
        }
        session.setAttribute("cart", cart);

        return "order_success";
    }
}
