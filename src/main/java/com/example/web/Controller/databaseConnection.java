package com.example.web.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/x-pense_db";
        String uname = "root";
        String pass = "";
        return DriverManager.getConnection(url, uname, pass);


    }
}
