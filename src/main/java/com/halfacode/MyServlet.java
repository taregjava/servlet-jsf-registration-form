package com.halfacode;

import com.halfacode.config.DBManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection connection = DBManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM MYTABLE")) {

            out.println("<html><body>");
            out.println("<h2>Data from the H2 database:</h2>");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                out.println("<p>Name: " + name + ", Age: " + age + "</p>");
            }

            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h2>Error occurred while accessing the database.</h2>");
            out.println("</body></html>");
        }
    }
}