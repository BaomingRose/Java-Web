package com.rose.bookstore.pojo;

public class OrderForm {
    private int id;
    private String userName;
    private String userAddress;
    private String userPhone;
    private int bookid;
    private String bookName;
    private boolean done;
    private int num;
    private double price;

    public OrderForm(int id, String userName, String userAddress, String userPhone, int bookid, String bookName, boolean done, int num, double price) {
        this.id = id;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.bookid = bookid;
        this.bookName = bookName;
        this.done = done;
        this.num = num;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
