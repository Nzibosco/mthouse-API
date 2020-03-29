package com.mthouse.entities.accounting;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Data @Setter @Getter
public class Business_line {

    @Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int author_id;

    @Column(nullable = false)
    private LocalDateTime date_created;

    @Column(nullable = false, unique = true)
    private String line_name;

    @Column(nullable = false)
    private String description;

    public void setDate(){
        this.date_created = LocalDateTime.now();
    }
}
