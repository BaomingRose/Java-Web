package com.rose.bookstore.controller;

import com.rose.bookstore.dao.UserDao;
import com.rose.bookstore.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {
    @Autowired(required = false)
    private UserDao userDao;

    @RequestMapping(value = "bookstore/doSignUp", method =  RequestMethod.POST)
    public String doSignUp(HttpServletRequest request, Model model) {
        String password = request.getParameter("password");
        String confirmpass = request.getParameter("confirmpass");

        //System.out.println(password);
        //System.out.println(confirmpass);

        if (password.isEmpty()) {
            return "sign_up";
        }

        if (password.equals(confirmpass)) {
            String username = request.getParameter("username");
            User user = new User(0, username, password);
            userDao.insertNewUser(user);
            int newid = userDao.getIdLast();
            user.setId(newid);
            model.addAttribute("user", user);
            return "sign_result";
        } else {
            return "sign_up";
        }
    }
}
