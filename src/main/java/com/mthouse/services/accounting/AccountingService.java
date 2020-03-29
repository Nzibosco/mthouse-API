package com.mthouse.services.accounting;

import com.mthouse.entities.accounting.Accounting_record;
import com.mthouse.repositories.accountingRepo.AccountingRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountingService {

    @Autowired
    private AccountingRecordRepo accountingRecordRepo;

    @Transactional(readOnly = true)
    public Iterable<Accounting_record> getAll(){
        return accountingRecordRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Accounting_record> getById(int id){
        return accountingRecordRepo.findById(id);
    }

    @Transactional
    public Accounting_record create (Accounting_record a){
        a.setDateRecorded();
        return accountingRecordRepo.save(a);
    }

    @Transactional
    public Accounting_record update (Accounting_record a){
        return accountingRecordRepo.save(a);
    }

    @Transactional
    public void delete (int id){
        accountingRecordRepo.deleteById(id);
    }
}
