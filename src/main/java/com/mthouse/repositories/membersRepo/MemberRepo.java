package com.mthouse.repositories.membersRepo;

import com.mthouse.entities.members.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MemberRepo extends CrudRepository<Member, Integer> {
    public Optional<Member> findByEmailAndPassword (String email, String password);

}
