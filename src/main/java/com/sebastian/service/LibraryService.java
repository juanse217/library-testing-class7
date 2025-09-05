package com.sebastian.service;

import java.util.List;

import com.sebastian.exceptions.BookNotFoundException;
import com.sebastian.exceptions.LoanNotFoundException;
import com.sebastian.model.Book;
import com.sebastian.model.Loan;
import com.sebastian.model.User;
import com.sebastian.repository.memory.MemoryBookRepository;
import com.sebastian.repository.memory.MemoryLoanRepository;

public class LibraryService {
    private MemoryBookRepository bookRepository;
    private MemoryLoanRepository loanRepository;
    

    public LibraryService(MemoryBookRepository bookRepository, MemoryLoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public Book getBook(Integer id) throws BookNotFoundException{
        return bookRepository.findBookById(id);
    }

    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public void loanBook(User user, Book book){
        loanRepository.addLoan(new Loan(user, book));
    }
    
    public List<Loan> getLoanByUser(User user) throws LoanNotFoundException{
        return loanRepository.findByUser(user);
    }
}
