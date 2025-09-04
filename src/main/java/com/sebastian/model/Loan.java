package com.sebastian.model;

import java.time.LocalDate;

public class Loan {
    private Integer id = 1; 
    private User user; 
    private Book book; 
    private LocalDate loanDate;

    public Loan(User user, Book book) {
        this.id = id++;
        this.user = user;
        this.book = book;
        this.loanDate = LocalDate.now();
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
