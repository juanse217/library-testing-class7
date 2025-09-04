package com.sebastian.repository;

import com.sebastian.exceptions.BookNotFoundException;
import com.sebastian.model.Book;

public interface BookRepository {
    Book findBookById(Integer id) throws BookNotFoundException;
    void addBook(Book book);
}
