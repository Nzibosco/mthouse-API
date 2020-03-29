package com.mthouse.entities.accounting;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity @Data @Getter @Setter
public class Accounting_record implements Serializable {

    @Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int recorderId;

    @Column(nullable = false)
    private LocalDateTime record_date;

    @Column(nullable = false)
    private String business_line;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    private Category category;

    public void setDateRecorded(){
        this.record_date = LocalDateTime.now();
    }
}
