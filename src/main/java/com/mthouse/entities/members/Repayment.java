package com.mthouse.entities.members;

import java.util.Date;

public class Repayment {

    private int id;
    private int loan_id;
    private Date due_date;
    private Date paid_on;
    private double amount_due;
    private double amount_paid;
    private double outstanding_balance;
}
