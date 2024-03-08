package com.example.web.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class User {
    @Id
    private Long user_id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String hashpass;
    private Timestamp account_created;

    public User() {
    }

    public User(Long user_id, String username, String firstName, String lastName, String email, String hashpass, Timestamp account_created) {
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashpass = hashpass;
        this.account_created = account_created;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashpass() {
        return hashpass;
    }

    public void setHashpass(String hashpass) {
        this.hashpass = hashpass;
    }

    public Timestamp getAccount_created() {
        return account_created;
    }

    public void setAccount_created(Timestamp account_created) {
        this.account_created = account_created;
    }

}
