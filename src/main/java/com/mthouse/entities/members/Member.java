package com.mthouse.entities.members;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @Setter @Getter
public class Member implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    @Column
    private String profile_picture_link;

    @Enumerated(EnumType.STRING)
    private Role member_role;

    @Enumerated(EnumType.STRING)
    private Status member_status;

    public int getId() {
        return this.id;
    }

    public void disableMember (){
        this.member_status = Status.DISABLED;
    }
}
