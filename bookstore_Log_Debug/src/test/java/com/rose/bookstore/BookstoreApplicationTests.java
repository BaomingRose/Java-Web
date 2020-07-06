package com.rose.bookstore;

import com.rose.bookstore.dao.BookDao;
import com.rose.bookstore.dao.UserDao;
import com.rose.bookstore.pojo.Book;
import com.rose.bookstore.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class BookstoreApplicationTests {
    @Autowired(required = false)
    public BookDao bookDao;

    @Autowired(required = false)
    public UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){

        /*
        Book book = new Book(1,"C++语言", "rose", "高教", 30.0, "计算机");
        // bookDao.insertNewBook(book);
        // bookDao.DeleteBook(book.getId());
        // bookDao.ModifyBook(book);
        // Book book2 = new Book(2, "Python入门", "David", "人民教育", 50.0, "科学");
        Book book2 = new Book(5, "Java入门实践", "高斯林", "清华出版社", 70.0, "CS");
        int res = 1000;
        try {
            res = bookDao.insertNewBook(book2);
        } catch (Exception e) {
            System.out.println();
            System.out.println(e);
            System.out.println();
        } finally {
            System.out.println();
            System.out.println();
            System.out.println(res);
            System.out.println();
            System.out.println();
        }

        ArrayList<Book> list_book = bookDao.queryAllBooks();

        for (int i = 0; i < list_book.size(); ++i) {
            System.out.println(list_book.get(i).getPublisher());
        }
        */

        /*
        User user = new User(1, "rose", "111");
        userDao.insertNewUser(user);
        int last_id = userDao.getIdLast();
        System.out.println();
        System.out.println(last_id);
        System.out.println();
        */

        ArrayList<Book> list_book = bookDao.queryRangeBooks(1,2);
        for (int i = 0; i < list_book.size(); ++i) {
            System.out.println(list_book.get(i));
        }
    }
}
