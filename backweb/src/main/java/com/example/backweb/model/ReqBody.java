package com.example.backweb.model;

public class ReqBody {
    private String method;
    private Book post;

    public ReqBody() {
    }

    public ReqBody(String method, Book post) {
        this.method = method;
        this.post = post;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Book getPost() {
        return post;
    }

    public void setPost(Book post) {
        this.post = post;
    }
}
