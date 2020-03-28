package com.mthouse.services.members;

import com.mthouse.entities.members.Loan;
import com.mthouse.repositories.membersRepo.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepo loanRepo;

    @Transactional
    public Loan applyForALoan (Loan l){
        l.setDateApplied();
        return loanRepo.save(l);
    }

    // to be used to update, approve, modify, or any other thing
    // that would result in changing data store for a particular Loan.
    @Transactional
    public Loan update (Loan l){
        return loanRepo.save(l);
    }

    @Transactional (readOnly = true)
    public Optional<Loan> getLoanById(int id){
        return loanRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Loan> getAllLoans (){
        return loanRepo.findAll();
    }

    // helper function for web master to be able to delete a loan conveniently.
    @Transactional
    public void deleteALoan(int id){
        loanRepo.deleteById(id);
    }

}
