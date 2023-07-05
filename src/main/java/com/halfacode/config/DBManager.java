package com.halfacode.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String JDBC_URL = "jdbc:h2:~/mydatabase"; // Change the database URL as desired
    private static final String JDBC_USERNAME = "sa"; // Change the username as desired
    private static final String JDBC_PASSWORD = ""; // Change the password as desired

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
}