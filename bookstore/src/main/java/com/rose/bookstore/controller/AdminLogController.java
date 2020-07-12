package com.rose.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AdminLogController {
    @RequestMapping("bookstore/admin_log")
    public String admin_log() {
        return "admin_log";
    }

    @RequestMapping(value = "bookstore/admin_log_check", method = RequestMethod.POST)
    public String admin_log_check(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        //System.out.println(userid);
        //System.out.println(password);

        if (userid.equals("root") && password.equals("1")) {
            HttpSession session = request.getSession();
            session.setAttribute("userid", userid);
            session.setAttribute("password", password);

            return "admin_init";

            /*
            try {
                response.sendRedirect("");
            } catch (IOException e) {
                System.out.println(e);
            }
            */
        }
        return "admin_log";
    }

    @RequestMapping("bookstore/adminInit")
    public String adminInit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        String password = (String)session.getAttribute("password");
        if (userid == null || password == null) {
            return "";
        }

        return "admin_init";
    }
}
