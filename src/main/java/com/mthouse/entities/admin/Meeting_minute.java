package com.mthouse.entities.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity @Data @Setter @Getter
public class Meeting_minute implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int minuteTakerId;

    @Column(nullable = false)
    private LocalDateTime meeting_date;

    @Column(nullable = false)
    private int attendance;

    @Column(nullable = false)
    private String description;

    @Column
    private String document_link;

    public void setMeetingDate(){
        this.meeting_date = LocalDateTime.now();
    }
}
