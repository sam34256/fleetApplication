package com.example.demo3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class Connectivity {
    public Connection connection;
   public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/fleet_management_system", "root", "1558");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
