package com.mthouse.repositories.membersRepo;

import com.mthouse.entities.members.Member;
import org.springframework.data.repository.CrudRepository;


public interface MemberRepo extends CrudRepository<Member, Integer> {
    public Member findByEmailAndPassword (String email, String password);

}
