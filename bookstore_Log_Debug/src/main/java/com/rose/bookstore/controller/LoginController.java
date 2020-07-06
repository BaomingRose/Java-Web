package com.rose.bookstore.controller;

import com.rose.bookstore.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired(required = false)
    private UserDao userDao;

    @RequestMapping("bookstore/login")
    public String login() {
        return "login";
    }

    @RequestMapping("bookstore/sign_up")
    public String sign() {
        return "sign_up";
    }

    @RequestMapping(value = "bookstore/log_check", method = RequestMethod.POST)
    public String log_check(HttpServletRequest request) {
        String id = request.getParameter("userid");
        String password = request.getParameter("password");

        if (id.isEmpty() || password.isEmpty()) {
            return "log_fail";
        }
        // System.out.println(id);
        // System.out.println(password);

        String right_password = null;
        try {
            int Id = Integer.parseInt(id);
            right_password = userDao.getPassword(Id);
        } catch (Exception e) {
            System.out.println(e);
            return "log_fail";
        }

        if (right_password == null) {
            return "log_fail";
        }

        if (right_password.equals(password)) {
            return "test";
        }

        return "log_fail";
    }
}
