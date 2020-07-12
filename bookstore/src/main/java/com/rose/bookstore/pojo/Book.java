package com.rose.bookstore.pojo;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private double price;
    private String category;

    public Book(int id, String name, String author, String publisher, double price, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "book_id=" + id +
                "&book_name=" + name +
                "&book_author=" + author +
                "&book_publisher=" + publisher +
                "&book_price=" + price +
                "&book_category=" + category;
    }
}
