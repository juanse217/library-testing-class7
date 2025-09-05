package com.sebastian.repository.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sebastian.exceptions.LoanNotFoundException;
import com.sebastian.model.Loan;
import com.sebastian.model.User;
import com.sebastian.repository.LoanRepository;

public class MemoryLoanRepository implements LoanRepository {

    private List<Loan> loans;

    public MemoryLoanRepository() {
        loans = new ArrayList<>();
    }

    @Override
    public Loan findById(Integer id) throws LoanNotFoundException {
        Optional<Loan> loanOption = loans.stream().filter(x -> x.getId() == id).findFirst();

        return loanOption.orElseThrow(() -> new LoanNotFoundException("Loan not found"));
    }

    @Override
    public List<Loan> findByUser(User user) throws LoanNotFoundException {
        ArrayList<Loan> list = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUser().equals(user))
                list.add(loan);
        }

        return list;
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

}
