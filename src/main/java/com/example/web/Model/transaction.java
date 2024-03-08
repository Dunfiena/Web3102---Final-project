package com.example.web.Model;

import java.util.Date;

public class transaction {
    int id;
    String type;
    Date date;
    double amount;
    boolean reOccurring;

    public transaction(int id, String type, Date date, double amount, boolean reOccurring) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.reOccurring = reOccurring;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isReOccurring() {
        return reOccurring;
    }

    public void setReOccurring(boolean reOccurring) {
        this.reOccurring = reOccurring;
    }
}
