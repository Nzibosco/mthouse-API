package com.mthouse.services.admin;

import com.mthouse.entities.admin.Document;
import com.mthouse.repositories.adminRepo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo documentRepo;

    @Transactional(readOnly = true)
    public Iterable<Document> getAll (){
        return documentRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Document> getById(int id){
        return documentRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Document> getByUploader(int uploaderId){
        return documentRepo.findByUploaderId(uploaderId);
    }

    @Transactional
    public Document create (Document d){
        d.setDateUploaded();
        return documentRepo.save(d);
    }

    @Transactional
    public Document update (Document d){
        return documentRepo.save(d);
    }

    @Transactional
    public void delete (int id){
        documentRepo.deleteById(id);
    }
}
