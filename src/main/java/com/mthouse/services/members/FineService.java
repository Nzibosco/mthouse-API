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
