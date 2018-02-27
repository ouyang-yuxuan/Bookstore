package com.model.bookstore;

public class CartItem {

    private Books book;// 图书对象的成员变量
    private Integer number;// 购买的数量；

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
