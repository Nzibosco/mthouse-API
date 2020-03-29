package com.mthouse.controllers.membersController;

import com.mthouse.entities.members.Repayment;
import com.mthouse.services.members.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/repayment")
public class RepaymentsController {

    @Autowired
    private RepaymentService repaymentService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test (){
        return "Repayment controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repayment> getAll(){
        return repaymentService.getAllRepayments();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Repayment> getById(@PathVariable int id){
        return repaymentService.getRepaymemtById(id);
    }

    @GetMapping(value = "/loan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Repayment> getByLoan(@PathVariable int id){
        return repaymentService.getByLoanId(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Repayment createRepayment(@RequestBody Repayment r){
        return repaymentService.createRepayment(r);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Repayment updateRepayment(@RequestBody Repayment r){
        return repaymentService.update(r);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRepayment(@PathVariable int id){
        repaymentService.deleteRepayment(id);
    }
}
