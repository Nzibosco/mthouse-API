package com.mthouse.entities.members;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity @Data @Getter @Setter
public class Loan {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int memberId;

    @Column (nullable = false)
    private int cosigner_id;

    @Column (nullable = false)
    private LocalDateTime loanRequestDate;

    @Column(nullable = false)
    private int loan_duration;

    @Column
    private LocalDateTime date_issued;

    @Column
    private int first_approver_id;

    @Column
    private int second_approver_id;

    @Column (nullable = false)
    private String reason;

    @Column (nullable = false)
    private double amount;

    @Column
    private double interest_rate;

    @Column
    private double current_balance;

    @Enumerated(EnumType.STRING)
    private LoanStatus loan_status;

    public void setDateApplied (){
        this.loanRequestDate = LocalDateTime.now();
    }
}
