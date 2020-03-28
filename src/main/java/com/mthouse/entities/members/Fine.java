package com.mthouse.entities.members;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity @Data @Getter @Setter
public class Fine {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int contributionId;

    @Column
    private int loanId;

    @Column
    private int approver_id;

    @Column (nullable = false)
    private LocalDateTime paid_on;

    @Column(nullable = false)
    private String comment;

    @Column
    private double accumulated_amount;

    @Column(nullable = false)
    private double amount_paid;

    @Column
    private double outstanding_balance;

    public void setDatePaid(){
        this.paid_on = LocalDateTime.now();
    }
}
