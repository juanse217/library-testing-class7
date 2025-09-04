package com.sebastian.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sebastian.model.Book;
import com.sebastian.model.BookNotFoundException;
import com.sebastian.model.BookRepository;;

public class MemoryBookRepository implements BookRepository {
    private List<Book> books;

    public MemoryBookRepository(){
        books = new ArrayList<>();
    }

    @Override
    public Book findBookById(Integer id) throws BookNotFoundException{
       Optional<Book> bookOptional = books.stream().filter(x -> x.getId() == id).findFirst();
       return bookOptional.orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    
}
