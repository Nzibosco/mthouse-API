package com.mthouse.controllers.admin;

import com.mthouse.entities.admin.Document;
import com.mthouse.services.admin.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocumentsController {

    @Autowired
    private DocumentService documentService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test (){
        return "Document controller work";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Document> getAll (){
        return documentService.getAll();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Document> getById(@PathVariable int id){
        return documentService.getById(id);
    }

    @GetMapping(value = "/uploader/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Document> getByUploader (@PathVariable int id){
        return documentService.getByUploader(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Document create (@RequestBody Document d){
        return documentService.create(d);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Document update (@RequestBody Document d){
        return documentService.update(d);
    }

    @DeleteMapping (value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete (@PathVariable int id){
        documentService.delete(id);
    }
}
