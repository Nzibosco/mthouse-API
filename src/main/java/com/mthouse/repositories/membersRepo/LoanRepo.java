package com.mthouse.repositories.membersRepo;

import com.mthouse.entities.members.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepo extends CrudRepository<Loan, Integer> {

    public Iterable<Loan> findByMemberId(int memberId);
}
