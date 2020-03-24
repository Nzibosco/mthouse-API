package com.mthouse.entities.accounting;

import java.util.Date;

public class Accounting_record {

    private int id;
    private int recorder_id;
    private Date record_date;
    private String business_line;
    private String comment;
    private double amount;
    private Category category;
}
