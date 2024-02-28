package com.example.web.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long account_id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "balance")
    private double balence;

    public Account() {
    }

    public Account(Long account_id, long user_id, double balence) {
        this.account_id = account_id;
        this.user_id = user_id;
        this.balence = balence;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public double getBalence() {
        return balence;
    }

    public void setBalence(double balence) {
        this.balence = balence;
    }

}
