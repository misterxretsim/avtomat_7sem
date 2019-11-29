package com.example.backweb.model;

public class Book {
    private int id;
    private String author;
    private String date;
    private String title;
    private String body;

    public Book() {
    }

    public Book(int id, String author, String date, String title, String body) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
