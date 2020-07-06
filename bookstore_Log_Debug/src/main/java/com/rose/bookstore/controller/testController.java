package com.rose.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @RequestMapping("bookstore/test")
    public String test() {
        return "test";
    }
}
