package com.mthouse.services.members;

import com.mthouse.entities.members.Member;
import com.mthouse.repositories.membersRepo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;


    // login a member
    @Transactional(readOnly = true)
    public Member authenticate (String email, String password){
        return memberRepo.findByEmailAndPassword(email, password);
    }

    // add a member to the database
    @Transactional
    public Member addMember (Member m){
        m.setJoinedDate();
        m.setStatus();
       return memberRepo.save(m);
    }

    @Transactional(readOnly = true)
    public Iterable getAllMembers () {
        return memberRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> getMemberById(int id) {
        return memberRepo.findById(id);
    }


    @Transactional
    public Member update(Member m){
        return memberRepo.save(m);
    }

    /**
     * Desactivate a member

     On UI side, the person deleting a member will maintain the same member JSON.
     the API request will send the the member JSON, and internally, Java API updates the status to 'DISABLED'.
     */
    @Transactional
    public Member removeMember(Member m){
        m.disableMember();
        return memberRepo.save(m);
    }

    //delete a member
    @Transactional
    public void deleteMember(int id){
       memberRepo.deleteById(id);
    }
}
