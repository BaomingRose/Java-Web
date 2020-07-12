package com.rose.bookstore.controller;

import com.rose.bookstore.dao.OrderDao;
import com.rose.bookstore.pojo.OrderForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class AdminImageOrderController {
    @Autowired(required = false)
    private OrderDao orderDao;

    @RequestMapping("bookstore/show_all_order")
    public String showAllOrder(Model model) {
        ArrayList<OrderForm> order_list = orderDao.queryUndoneOrder();
        model.addAttribute("order_list", order_list);

        return "show_undone_order";
    }

    @RequestMapping("bookstore/doneOrder")
    public String doneOrder(@Param("book_id")String book_id) {
        orderDao.doneOrder(Integer.parseInt(book_id));

        return "forward:/bookstore/show_all_order";
    }
}
