package com.rose.bookstore.dao;

import com.rose.bookstore.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface BookDao {
    public int insertNewBook(@Param("book")Book book);

    public ArrayList<Book> queryAllBooks();

    public Book queryById(@Param("id")Integer id);

    public ArrayList<Book> queryByName(@Param("name")String name);

    public ArrayList<Book> queryByAuthor(@Param("author")String author);

    public ArrayList<Book> queryByPublisher(@Param("publisher")String publisher);

    public ArrayList<Book> queryByCategory(@Param("category")String category);

    public int DeleteBook(@Param("id")Integer id);

    public int ModifyBook(@Param("book")Book book);

    public ArrayList<Book> queryRangeBooks(Integer start, Integer num);
}
