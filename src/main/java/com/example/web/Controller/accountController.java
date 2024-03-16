package com.example.web.Controller;

import com.example.web.Model.Account;
import com.example.web.Model.User;
import com.example.web.Repo.accountRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.web.Controller.databaseConnection.getConnection;

public class accountController implements accountRepo {

    Account account;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void registerAccount(int userId, double balance) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO account(user_id, balance) VALUES (?,?)");
            stmt.setInt(1, userId);
            stmt.setDouble(2, balance);

            stmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public Account getAccount(int userId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM account where user_id=?");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                account = new Account(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3)
                );
                return account;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return account;    }

    @Override
    public void update(Account account) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE account SET balance=? WHERE account_id=?;");
            stmt.setDouble(1, account.getBalence());
            stmt.setInt(2, account.getAccount_id());

            stmt.executeUpdate();
        }catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int accountId) throws SQLException {
        stmt = conn.prepareStatement("DELETE FROM account WHERE account_id=?;");
        stmt.setInt(1, accountId);
        stmt.executeUpdate();
    }
}
