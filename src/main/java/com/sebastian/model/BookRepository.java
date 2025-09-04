package com.sebastian.model;

public interface BookRepository {
    Book findBookById(Integer id) throws BookNotFoundException;
    void addBook(Book book);
}
