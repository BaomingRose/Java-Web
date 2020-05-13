package com.dao;
import java.sql.*;
import java.util.ArrayList;
import com.model.Customer;
public class CustomerDaoImpl implements CustomerDao {
	// 插入一条客户记录
	public boolean addCustomer(Customer customer)  throws DaoException {  	  
   	   	String sql = "INSERT INTO customer VALUES(?,?,?,?)";
   	   
   	   	try ( Connection conn = getConnection();
   	   		PreparedStatement pstmt = conn.prepareStatement(sql) 
   	   	) { 
   	   		pstmt.setInt(1,customer.getId());
   	   		pstmt.setString(2,customer.getName());
   	   		pstmt.setString(3,customer.getEmail());
   	   		pstmt.setDouble(4,customer.getBalance());
   	   		pstmt.executeUpdate();
   	   		return true;
   	   	} catch(SQLException se) {
   	   		System.out.println(se);
   	   		return false;
   	   	}
	} 
	
	// 按id查询客户记录
	public Customer findById(int id) throws DaoException{ 
		String sql = "SELECT id,name,email,balance" +
	  		             " FROM customer WHERE id =?";
		Customer  customer = new Customer();
		try (
    		Connection conn = getConnection();
    	    PreparedStatement pstmt = conn.prepareStatement(sql)
    	) {
			pstmt.setInt(1, id);
			//System.out.println(id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if(rst.next()) {
					customer.setId(rst.getInt("id"));
					customer.setName(rst.getString("name"));
					customer.setEmail(rst.getString("email"));
					customer.setBalance(rst.getDouble("balance"));
				}
				
			}
		} catch (SQLException se) {
   	  		return null;
   	  	}
   	  	return customer;
	}
	
	// 查询所有客户信息
	public ArrayList<Customer> findAllCustomer() throws DaoException {  	  
   	  	
   	  	ArrayList<Customer> custList = new ArrayList<Customer>();
   	  	String sql = "SELECT * FROM customer";
   	  	try( 
   	  		Connection conn = getConnection();
   	  		PreparedStatement pstmt = conn.prepareStatement(sql);
   	  		ResultSet rst = pstmt.executeQuery()
   	  	) {  		 
   	  		while (rst.next()) {
   	  			Customer  customer = new Customer();
   	  			customer.setId(rst.getInt("id"));
   	  			customer.setName(rst.getString("name"));
   	  			customer.setEmail(rst.getString("email"));
   	  			customer.setBalance(rst.getDouble("balance"));	
   	  			custList.add(customer);	
   	  		}	     
   	  		return custList;
   	  	} catch (SQLException e) {
   	  		e.printStackTrace();
   	  		return null;
   	  	}
	}
	
	public boolean deleteCustomer(String custName) throws DaoException {
		String sql = "delete from customer where name = ?";
		
		try (
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = conn.prepareStatement(sql)
	    ) {
			pstmt.setString(1, custName);
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
    public boolean updateCustomer(Customer customer) throws DaoException {
    	String sql = "update customer set id=?, email=?, balance=? where name=?";
    	try (
    	    Connection conn = getConnection();
    	    PreparedStatement pstmt = conn.prepareStatement(sql)
    	) {
    		pstmt.setInt(1, customer.getId());
    		pstmt.setString(2, customer.getEmail());
    		pstmt.setDouble(3, customer.getBalance());
    		pstmt.setString(4, customer.getName());
    		
    		pstmt.executeUpdate();
    		
    		return true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
}

