package com.sebastian.repository;

import com.sebastian.exceptions.LoanNotFoundException;
import com.sebastian.model.Loan;
import com.sebastian.model.User;

public interface LoanRepository {
    Loan findById(Integer id) throws LoanNotFoundException;
    Loan findByUser(User user) throws LoanNotFoundException;
    void addLoan(Loan loan);
}
