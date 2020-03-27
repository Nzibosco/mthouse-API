package com.mthouse.entities.members;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity @Data @Getter @Setter
public class Contribution implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int member_id;

    @Column
    private LocalDateTime due_date;

    @Column(nullable = false)
    private LocalDateTime paid_on;

    @Column
    private int approver_id;

    @Column(nullable = false)
    private int contribution_month;

    @Column(nullable = false)
    private int contribution_year;

    @Column(nullable = false)
    private double amount;

    @Column
    private String comment;

    public void setPayDate (){
        this.paid_on = LocalDateTime.now();
    }
}
