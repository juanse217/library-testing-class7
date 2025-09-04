package com.sebastian.model;

import com.sebastian.exceptions.BookNotFoundException;

public interface BookRepository {
    Book findBookById(Integer id) throws BookNotFoundException;
    void addBook(Book book);
}
