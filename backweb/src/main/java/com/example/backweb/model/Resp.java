package com.example.backweb.model;

import java.util.List;

public class Resp {
    private String method;
    private boolean status;
    private List<Book> book;

    public Resp(String method, boolean status, List<Book> book) {
        this.method = method;
        this.status = status;
        this.book = book;
    }

    public Resp() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
