package com.example.web.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Expense {
    @Id
    private int id;
    private int account_id;
    private int reoccuring;
    private double amount;
    private String tag;
    private Timestamp tran_date;

    public Expense() {
    }

    public Expense(int id, int account_id, int reoccuring, double amount, String tag, Timestamp tran_date) {
        this.id = id;
        this.account_id = account_id;
        this.reoccuring = reoccuring;
        this.amount = amount;
        this.tag = tag;
        this.tran_date = tran_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getReoccuring() {
        return reoccuring;
    }

    public void setReoccuring(int reoccuring) {
        this.reoccuring = reoccuring;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTran_date() {
        return tran_date;
    }

    public void setTran_date(Timestamp tran_date) {
        this.tran_date = tran_date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
