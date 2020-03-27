package com.mthouse.repositories.membersRepo;

import com.mthouse.entities.members.Contribution;
import org.springframework.data.repository.CrudRepository;

public interface ContributionRepo extends CrudRepository<Contribution, Integer> {
    Iterable<Contribution> findByMemberId(int memberId);
}
