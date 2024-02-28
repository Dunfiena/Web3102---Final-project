package com.example.web.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Expense {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="account_id")
    private int account_id;

    @Column(name="reoccuring")
    private int reoccuring;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_date")
    private Timestamp tran_date;

    public Expense() {
    }

    public Expense(Long id, int account_id, int reoccuring, double amount, Timestamp tran_date) {
        this.id = id;
        this.account_id = account_id;
        this.reoccuring = reoccuring;
        this.amount = amount;
        this.tran_date = tran_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

}
