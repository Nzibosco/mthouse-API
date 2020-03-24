package com.mthouse.entities.members;

import java.util.Date;

public class Contribution {

    private int id;
    private int member_id;
    private Date due_date;
    private Date paid_on;
    private int approver_id;
    private int getContribution_month;
    private int contribution_year;
    private double amount;
    private String comment;

}
