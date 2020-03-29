package com.mthouse.controllers.accounting;

import com.mthouse.entities.accounting.Accounting_record;
import com.mthouse.services.accounting.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounting")
public class AccRecordsController {

    @Autowired
    AccountingService accountingService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test (){
        return "Accounting controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Accounting_record> getAll (){
        return accountingService.getAll();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Accounting_record> getById(@PathVariable int id){
        return accountingService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Accounting_record create (@RequestBody Accounting_record a){
        return accountingService.create(a);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Accounting_record update (@RequestBody Accounting_record a){
        return accountingService.update(a);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRecord(@PathVariable int id){
        accountingService.delete(id);
    }
}
