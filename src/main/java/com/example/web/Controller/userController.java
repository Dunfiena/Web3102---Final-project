package com.example.web.Controller;

import com.example.web.Model.User;
import com.example.web.Repo.userRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.web.Controller.databaseConnection.getConnection;

public class userController implements userRepo{

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    User user = null;

    @Override
    public User login(String userName, String password){
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE username=? AND hashpass=?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getTimestamp(7)

                );
                return user;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    @Override
    public void registerUser(String userName, String fname, String lname, String email, String password) throws SQLException {
        try{
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO user(username, fname, lname, email, hashpass) VALUES (?,?,?,?,?)");
            stmt.setString(1, userName);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setString(4, email);
            stmt.setString(5, password);

            stmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void update(User user) throws SQLException {
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE user SET username=?, fname=?, lname=?, email=?, hashpass=? WHERE user_id=?;");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getHashpass());
            stmt.setInt(6, user.getUser_id());

            stmt.executeUpdate();
        }catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int userId) throws SQLException {
        stmt = conn.prepareStatement("DELETE FROM user WHERE user_id=?;");
        stmt.setInt(1, userId);
        stmt.executeUpdate();
    }

}
