package com.mthouse.controllers.accounting;


import com.mthouse.entities.accounting.Business_line;
import com.mthouse.services.accounting.BusinessLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/line")
public class BusinessLineController {

    @Autowired
    private BusinessLineService businessLineService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test (){
        return "Business Line controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Business_line> getAll (){
        return businessLineService.getAll();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Business_line> getById(@PathVariable int id){
        return businessLineService.getbyId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Business_line create (@RequestBody Business_line b){
        return businessLineService.create(b);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Business_line update (@RequestBody Business_line b){
        return businessLineService.update(b);
    }

    @DeleteMapping (value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void  delete (@PathVariable int id){
        businessLineService.delete(id);
    }
}
