package com.mthouse.services.members;

import com.mthouse.entities.members.Fine;
import com.mthouse.repositories.membersRepo.FineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FineService {

    @Autowired
    private FineRepo fineRepo;

    @Transactional(readOnly = true)
    public Iterable<Fine> getAllFines(){
        return fineRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Fine> getFineById(int id){
        return fineRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Fine> getMemberHistory(int member_id){
        return fineRepo.findByMemberId(member_id);
    }

    @Transactional(readOnly = true)
    public Iterable<Fine> getFineByContribution(int contribution_id){
        return fineRepo.findByContributionId(contribution_id);
    }

    @Transactional(readOnly = true)
    public Iterable<Fine> getFineByLoan (int loan_id){
        return fineRepo.findByLoanId(loan_id);
    }

    @Transactional
    public Fine createFine(Fine f){
        f.setDatePaid();
        return fineRepo.save(f);
    }

    @Transactional
    public Fine updateFine(Fine f){
        return fineRepo.save(f);
    }

    @Transactional
    public void deleteAFine(int id){
        fineRepo.deleteById(id);
    }
}
