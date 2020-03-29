package com.mthouse.repositories.adminRepo;

import com.mthouse.entities.admin.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepo extends CrudRepository<Document, Integer> {
    public Iterable<Document> findByUploaderId(int uploaderId);
}
