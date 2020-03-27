package com.mthouse.services.members;

import com.mthouse.entities.members.Contribution;
import com.mthouse.repositories.membersRepo.ContributionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ContributionService {

    @Autowired
    ContributionRepo contributionRepo;

    // pay a contribution
    @Transactional
    public Contribution contribute (Contribution c) {
        c.setPayDate();
        return contributionRepo.save(c);
    }

    //approve or modify a contribution
    @Transactional
    public Contribution update (Contribution c) {
        return contributionRepo.save(c);
    }

    // get a contribution by id
    @Transactional(readOnly = true)
    public Optional<Contribution> getContributionById(int id){
        return contributionRepo.findById(id);
    }

    // get all contributions
    @Transactional(readOnly = true)
    public Iterable<Contribution> getAllContributions(){
        return contributionRepo.findAll();
    }

    // member -specific contributions history
    @Transactional(readOnly = true)
    public Iterable<Contribution> contributionHistory (int member_id){
        return contributionRepo.getHistory(member_id);
    }

    // delete a contribution
    @Transactional
    public void deleteContribution (int id){
        contributionRepo.deleteById(id);
    }

}
