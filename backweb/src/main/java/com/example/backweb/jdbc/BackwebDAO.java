package com.example.backweb.jdbc;

import com.example.backweb.model.Book;

import java.util.List;

public interface BackwebDAO {
    List<Book> getBooks();
    List<Book> delete(int id);
    List<Book> add(Book book);
}
