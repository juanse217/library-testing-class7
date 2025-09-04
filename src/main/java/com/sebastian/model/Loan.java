package com.sebastian.model;

import java.time.LocalDate;

public class Loan {
    private Integer id; 
    private User user; 
    private Book book; 
    private LocalDate loanDate;

    public Loan(Integer id, User user, Book book, LocalDate loanDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    
    
}
