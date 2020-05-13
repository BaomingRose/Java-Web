package com.dao;
import java.util.ArrayList;
import com.model.Customer;
public interface CustomerDao extends Dao {
    //添加客户方法
    public boolean addCustomer (Customer customer) throws DaoException;
 	// 按id查询客户方法
	public Customer findById (int id) throws DaoException;
    // 查询所有客户方法
    public ArrayList<Customer> findAllCustomer () throws DaoException;   
    //删除
    public boolean deleteCustomer(String custName) throws DaoException;
    //修改
    public boolean updateCustomer(Customer customer) throws DaoException;

}

