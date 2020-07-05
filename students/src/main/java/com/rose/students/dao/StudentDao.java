package com.rose.students.dao;

import com.rose.students.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface StudentDao {
    public int insertNewStudnet(@Param("student")Student student);

    public List<Student> queryAllStudent();
}


