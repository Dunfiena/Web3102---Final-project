package com.example.web.Controller;

import com.example.web.Model.Income;
import com.example.web.Model.User;
import com.example.web.Repo.incomeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.web.Controller.databaseConnection.getConnection;

public class incomeController implements incomeRepo {
    Income income;
    ArrayList<Income> incomeArrayList = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void addIncome(int accountId, int reoccurring, double amount, String tag) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO income(account_id, reoccuring, amount, tag) VALUES (?,?,?,?)");
            stmt.setInt(1, accountId);
            stmt.setInt(2, reoccurring);
            stmt.setDouble(3, amount);
            stmt.setString(4, tag);

            stmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Income> selectIncome(int accountId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM income WHERE account_id=?");
            stmt.setInt(1, accountId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                income = new Income(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getTimestamp(6)
                );
                incomeArrayList.add(income);
            }
            return incomeArrayList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Income in) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE income SET reoccuring=?, amount=?, tag=? WHERE transaction_id_in=?;");
            stmt.setInt(1, in.getReoccuring());
            stmt.setDouble(2, in.getAmount());
            stmt.setInt(3, in.getId());

            stmt.executeUpdate();
        }catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int transaction_id_in) throws SQLException {
        stmt = conn.prepareStatement("DELETE FROM income WHERE transaction_id_in=?;");
        stmt.setInt(1, transaction_id_in);
        stmt.executeUpdate();
    }
}
