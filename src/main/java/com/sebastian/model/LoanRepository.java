package com.sebastian.model;

public interface LoanRepository {
    Loan findById(Integer id) throws LoanNotFoundException;
    Loan findByUser(User user) throws LoanNotFoundException;
    void addLoan(Loan loan);
}
