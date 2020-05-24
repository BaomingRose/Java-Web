package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.BookBean;

public class BookDao2 implements Dao {
	// 插入一条客户记录
	public boolean addBookBean(BookBean bookBean)  throws DaoException {  	  
		String sql = "INSERT INTO books VALUES(?,?,?,?,?)";
		try {
			Connection conn = getConnection();
		   	PreparedStatement pstmt = conn.prepareStatement(sql);
		   	
		   	pstmt.setString(1, bookBean.getId());
		   	pstmt.setString(2, bookBean.getTitle());
		   	pstmt.setString(3, bookBean.getAuthor());
		   	pstmt.setString(4, bookBean.getPublisher());
		   	pstmt.setDouble(5, bookBean.getPrice());
		   	pstmt.executeUpdate();
		   	return true;
		} catch(SQLException se) {
		 	System.out.println(se);
			return false;
		}
	} 
		
	// 按id查询客户记录
	public BookBean findById(String id) throws DaoException { 
		String sql = "SELECT * FROM books WHERE BOOKID = ?";
		BookBean book = new BookBean();
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//System.out.println(pstmt);
			
			try (ResultSet rst = pstmt.executeQuery()) {
				if(rst.next()) {
					book.setId(rst.getString("BOOKID"));
					//System.out.println(rst.getString("BOOKID"));
					book.setTitle(rst.getString("TITLE"));
					//调式：字母打错
					book.setAuthor(rst.getString("AUTHOR"));
					book.setPublisher(rst.getString("PUBLISHER"));
					book.setPrice(rst.getDouble("PRICE"));
				} else {
					System.out.println("rst not exist");
				}
			}
		} catch (SQLException se) {
			  System.out.println("sql异常");
			  se.printStackTrace();
		   	  return null;
		}
		return book;
	}
			
	// 查询所有客户信息
	public ArrayList<BookBean> findAllBookBean() throws DaoException {  	  
			
		ArrayList<BookBean> bookList = new ArrayList<BookBean>();
		String sql = "SELECT * FROM books";
		try {
			Connection conn = getConnection();
		   	PreparedStatement pstmt = conn.prepareStatement(sql);
		   	ResultSet rst = pstmt.executeQuery();
		   				 		 
		   	while (rst.next()) {
		   		//调式错误：因为把book写在外面，只使用了一个对象，
		   		//相当于List的所有对象都被book所引用，导致List所有对象都被修改成最后一个了
		   		BookBean  book = new BookBean();
		   		book.setId(rst.getString("BOOKID"));
		   		book.setTitle(rst.getString("TITLE"));
		   		book.setAuthor(rst.getString("AUTHOR"));
		   		book.setPublisher(rst.getString("PUBLISHER"));
		   		book.setPrice(rst.getDouble("PRICE"));
		   		bookList.add(book);	
		   		//System.out.println(book.getId());
		   	}
		   	return bookList;
		} catch (SQLException e) {
			e.printStackTrace();
		   	return null;
		}
	}
}
