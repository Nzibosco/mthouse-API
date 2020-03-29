package com.mthouse.entities.members;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity @Data @Getter @Setter
public class Repayment implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int loanId;

    @Column
    private LocalDateTime due_date;

    @Column(nullable = false)
    private LocalDateTime paid_on;

    @Column
    private double amount_due;

    @Column(nullable = false)
    private double amount_paid;

    @Column
    private double outstanding_balance;

    public void setDatePaid(){
        this.paid_on = LocalDateTime.now();
    }
}
