package com.mthouse.entities.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity @Data @Setter @Getter
public class Document implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private int uploaderId;

    @Column(nullable = false)
    private LocalDateTime date_uploaded;

    @Column(nullable = false)
    private String document_summary;

    @Column(nullable = false)
    private String document_link;

    public void setDateUploaded(){
        this.date_uploaded = LocalDateTime.now();
    }
}
