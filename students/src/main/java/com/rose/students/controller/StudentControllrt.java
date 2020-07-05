package com.rose.students.controller;

import com.rose.students.dao.StudentDao;
import com.rose.students.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentControllrt {

    @Autowired(required = false)
    private StudentDao studentDao;


    @RequestMapping("hello")
    public  String hello(Model model){
        List<Student> list = studentDao.queryAllStudent();
        model.addAttribute("student", list.get(0));
        return "hello";
}


}
