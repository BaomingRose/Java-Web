package com.rose.bookstore.pojo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Cart {
    HashMap<Integer, BookItem> items = null;

    public Cart () {
        items = new HashMap<Integer, BookItem>();
    }

    //增加一种书
    public void add(BookItem bookItem) {
        int bookid = bookItem.getBook().getId();
        if (items.containsKey(bookid)) {
            BookItem bit = (BookItem)items.get(bookid);
            bit.setNum(bit.getNum() + bookItem.getNum());
        } else {
            items.put(bookid, bookItem);
        }
    }

    //从购物车删除一本书
    public void remove(Integer bookid) {
        if (items.containsKey(bookid)) {
            BookItem bit = (BookItem)items.get(bookid);
            bit.setNum(bit.getNum() - 1);
            if (bit.getNum() <= 0) {
                items.remove(bookid);
            }
        }
    }

    //返回购物车中BookItem的集合
    public Collection<BookItem> getItems() {
        return items.values();
    }

    public double getTotal() {
        double amount = 0.0;
        for (Iterator<BookItem> i = getItems().iterator(); i.hasNext(); ) {
            BookItem item = (BookItem) i.next();
            Book book = (Book) item.getBook();
            amount += item.getNum() * book.getPrice();
        }
        return roundOff(amount);
    }

    // 对数值进行四舍五入并保留两位小数
    private double roundOff(double x) {
        long val = Math.round(x * 100); // cents
        return val / 100.0;
    }

    // 清空购物车方法
    public void clear() {
        items.clear();
    }
}
