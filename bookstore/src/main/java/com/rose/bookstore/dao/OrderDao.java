package com.rose.bookstore.dao;

import com.rose.bookstore.pojo.OrderForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface OrderDao {
    public ArrayList<OrderForm> queryAllOrder();

    public ArrayList<OrderForm> queryUndoneOrder();

    public void doneOrder(@Param("orderId")Integer orderId);

    public void insertOrder(@Param("orderForm")OrderForm orderForm);

    public int getIdLast();
}
