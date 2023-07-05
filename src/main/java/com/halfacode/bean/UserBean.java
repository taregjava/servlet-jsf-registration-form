package com.halfacode.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
        private static final long serialVersionUID = 1L;

        private String userName;
        private String userPass;
        private String userEmail;
        private String userCountry;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPass() {
            return userPass;
        }

        public void setUserPass(String userPass) {
            this.userPass = userPass;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserCountry() {
            return userCountry;
        }

        public void setUserCountry(String userCountry) {
            this.userCountry = userCountry;
        }

        public void save() {
            try {
                // Establish database connection
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productapp", "root", "");

                // Prepare and execute the SQL statement
                String sql = "INSERT INTO tbl_user (userName, userPass, userEmail, userCountry) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, userName);
                statement.setString(2, userPass);
                statement.setString(3, userEmail);
                statement.setString(4, userCountry);
                statement.executeUpdate();

                // Close resources
                statement.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }