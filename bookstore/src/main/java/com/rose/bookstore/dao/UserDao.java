package com.rose.bookstore.dao;

import com.rose.bookstore.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserDao {
    public int insertNewUser(@Param("user")User user);

    public int getIdLast();

    public User queryById(@Param("id")Integer id);

    public String getPassword(@Param("id")Integer id);

    public int ModifyUser(@Param("user")User user);

}
