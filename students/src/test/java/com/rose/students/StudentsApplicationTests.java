package com.rose.students;

import com.rose.students.dao.StudentDao;
import com.rose.students.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentsApplicationTests {
    @Autowired(required = false)
    public StudentDao studentDao;



    @Test
    void contextLoads() {
    }


    @Test
    public void test(){

        Student student=new Student(1,"242");
        studentDao.insertNewStudnet(student);

    }


}
