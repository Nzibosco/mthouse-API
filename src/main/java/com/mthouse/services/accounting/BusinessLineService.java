package com.mthouse.services.accounting;

import com.mthouse.entities.accounting.Business_line;
import com.mthouse.repositories.accountingRepo.BusinessLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BusinessLineService {

    @Autowired
    private BusinessLineRepo businessLineRepo;

    @Transactional(readOnly = true)
    public Iterable<Business_line> getAll(){
        return businessLineRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Business_line> getbyId(int id){
        return businessLineRepo.findById(id);
    }

    @Transactional
    public Business_line create (Business_line b){
        b.setDate();
        return businessLineRepo.save(b);
    }

    @Transactional
    public Business_line update(Business_line b){
        return businessLineRepo.save(b);
    }

    @Transactional
    public void delete(int id){
        businessLineRepo.deleteById(id);
    }

}
