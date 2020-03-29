package com.mthouse.repositories.membersRepo;

import com.mthouse.entities.members.Repayment;
import org.springframework.data.repository.CrudRepository;

public interface RepaymentRepo extends CrudRepository<Repayment, Integer> {

    Iterable<Repayment> findByLoanId(int loanId);
}
