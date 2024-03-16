package com.example.web.Controller;

import com.example.web.Model.Expense;
import com.example.web.Model.Income;
import com.example.web.Model.User;
import com.example.web.Repo.expenseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.web.Controller.databaseConnection.getConnection;

public class expenseController implements expenseRepo {

    Expense expense;
    ArrayList<Expense> expenseArrayList = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void addExpense(int accountId, int reoccurring, double amount, String tag) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO expense(account_id, reoccuring, amount, tag) VALUES (?,?,?,?)");
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
    public ArrayList<Expense> selectExpense(int accountId) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM expense WHERE account_id=?");
            stmt.setInt(1, accountId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                expense = new Expense(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getTimestamp(6)
                );
                expenseArrayList.add(expense);
            }
            return expenseArrayList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Expense out) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE expense SET reoccuring=?, amount=?, tag=? WHERE transaction_id_out=?;");
            stmt.setInt(1, out.getReoccuring());
            stmt.setDouble(2, out.getAmount());
            stmt.setInt(3, out.getId());
            stmt.setString(4, out.getTag());

            stmt.executeUpdate();
        }catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int transaction_id_out) throws SQLException {
        stmt = conn.prepareStatement("DELETE FROM expense WHERE transaction_id_out=?;");
        stmt.setInt(1, transaction_id_out);
        stmt.executeUpdate();
    }
}
