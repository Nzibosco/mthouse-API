package com.mthouse.repositories.membersRepo;

import com.mthouse.entities.members.Fine;
import org.springframework.data.repository.CrudRepository;

public interface FineRepo extends CrudRepository<Fine, Integer> {

    public Iterable<Fine> findByContributionId(int contributionId);
    public Iterable<Fine> findByLoanId(int loanId);
}
