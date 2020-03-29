package com.mthouse.controllers.membersController;

import com.mthouse.entities.members.Fine;
import com.mthouse.services.members.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fine")
public class FinesController {

    @Autowired
    private FineService fineService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(){
        return "Fine controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Fine> getFines(){
        return fineService.getAllFines();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Fine> getFineById(@PathVariable int id){
        return fineService.getFineById(id);
    }

    @GetMapping(value = "/member/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Fine> getFineByMember (@PathVariable int id){
        return fineService.getMemberHistory(id);
    }

    @GetMapping(value = "/contribution/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Fine> getFineByContribution (@PathVariable int id){
        return fineService.getFineByContribution(id);
    }

    @GetMapping(value = "/loan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Fine> getFineByLoan (@PathVariable int id){
        return fineService.getFineByLoan(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Fine createFine(@RequestBody Fine f){
        return fineService.createFine(f);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Fine updateFine(@RequestBody Fine f){
        return fineService.updateFine(f);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFine (@PathVariable int id){
        fineService.deleteAFine(id);
    }
}
