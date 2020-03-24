package com.mthouse.entities.members;

import java.util.Date;

public class Fine {

    private int id;
    private int contribution_id;
    private int loan_id;
    private int approver_id;
    private Date paid_on;
    private String comment;
    private double accumulated_amount;
    private double amount_paid;
    private double outstanding_balance;
}
