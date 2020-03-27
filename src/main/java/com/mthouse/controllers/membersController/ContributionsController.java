package com.mthouse.controllers.membersController;

import com.mthouse.entities.members.Contribution;
import com.mthouse.services.members.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contribution")
public class ContributionsController {

    @Autowired
    private ContributionService contributionService;

    // test
    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        return "Contribution controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable getAllContributions(){
        return contributionService.getAllContributions();
    }

    @GetMapping(value = "/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable getMemberContributionHistory(@PathVariable int id){
        return contributionService.contributionHistory(id);
    }

    @GetMapping(value= "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Contribution> getContributionById(@PathVariable int id){
        return contributionService.getContributionById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contribution addContribution(@RequestBody Contribution c){
        return contributionService.contribute(c);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contribution updateContribution (@RequestBody Contribution c){
        return contributionService.update(c);
    }
}
