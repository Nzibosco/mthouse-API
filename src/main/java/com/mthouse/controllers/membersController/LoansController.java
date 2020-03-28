package com.mthouse.controllers.membersController;


import com.mthouse.entities.members.Loan;
import com.mthouse.services.members.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/loan")
public class LoansController {

    @Autowired
    private LoanService loanService;

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test (){
        return "Loans controller work";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Loan> getLoans(){
        return loanService.getAllLoans();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Loan> getLoanById(@PathVariable int id){
        return loanService.getLoanById(id);
    }

    @GetMapping(value = "/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Loan> getMemberLoanHistory(@PathVariable int id){
        return loanService.getLoanHistory(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan addLoan(@RequestBody Loan l){
        return loanService.applyForALoan(l);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan updateLoan (@RequestBody Loan l){
        return loanService.update(l);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteALoan (@PathVariable int id){
        loanService.deleteALoan(id);
    }
}
