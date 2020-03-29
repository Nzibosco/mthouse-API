package com.mthouse.services.members;

import com.mthouse.entities.members.Repayment;
import com.mthouse.repositories.membersRepo.RepaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RepaymentService {

    @Autowired
    private RepaymentRepo repaymentRepo;

    @Transactional(readOnly = true)
    public Iterable<Repayment> getAllRepayments(){
        return repaymentRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Repayment> getRepaymemtById(int id){
        return repaymentRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Repayment> getByLoanId(int loanId){
        return repaymentRepo.findByLoanId(loanId);
    }

    @Transactional
    public Repayment createRepayment(Repayment r){
        r.setDatePaid();
        return repaymentRepo.save(r);
    }

    @Transactional
    public Repayment update (Repayment r){
        return repaymentRepo.save(r);
    }

    @Transactional
    public void deleteRepayment(int id){
        repaymentRepo.deleteById(id);
    }
}
