package com.example.web.Controller;

import com.example.web.Model.User;
import com.example.web.Repo.userRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.web.Controller.databaseConnection.getConnection;

public class userController implements userRepo{

    userRepo urepo;
    private static final String SQL_SELECT = "SELECT * FROM user";
    private static final String SQL_SELECT_login = "SELECT * FROM user WHERE userName = ? AND hashpass = ?";
    private static final String SQL_INSERT = "INSERT INTO user(userName, email, hashpass) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE user SET userName=?, firstName=?, lastName=?, email=?, hashpass=? WHERE userId = ?";
    private static final String SQL_DELETE = "DELETE FROM user WHERE userId = ?";

    @Override
    public User login(String userName, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND hashpass = ?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        (long) rs.getInt(1),
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
        Connection con = null;
        PreparedStatement stmt = null;

        try{
            con = getConnection();
            stmt = con.prepareStatement("INSERT INTO user(username, fname, lname, email, hashpass) VALUES (?,?,?,?,?)");
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
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(User userId) throws SQLException {
        return 0;
    }

    @Override
    public User insert(String userName, String email, String password) throws SQLException {
        return null;
    }
}
