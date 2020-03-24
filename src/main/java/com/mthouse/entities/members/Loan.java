package com.mthouse.entities.members;

import java.util.Date;

public class Loan {

    private int id;
    private int member_id;
    private int cosigner_id;
    private int loan_duration;
    private Date date_issued;
    private int first_approver_id;
    private int second_approver_id;
    private String reason;
    private double amount;
    private double interest_rate;
    private double current_balance;
}
