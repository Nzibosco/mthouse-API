package com.mthouse.controllers.membersController;

import com.mthouse.dtos.Login;
import com.mthouse.entities.members.Member;
import com.mthouse.services.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MembersController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test () {
        return "Members Controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable getMembers (){
       return memberService.getAllMembers();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Member> getMemberById(@PathVariable int id){
        return memberService.getMemberById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @PutMapping(value ="/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member updateMemberDetails (@RequestBody Member m){
        return memberService.update(m);
    }

    @PutMapping(value = "/remove", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member removeMember (@RequestBody Member m){
        return memberService.removeMember(m);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member login (@RequestBody Login login){
        return memberService.authenticate(login.getEmail(), login.getPassword());
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteMember (@PathVariable int id){
        memberService.deleteMember(id);
    }
}
