package com.mycompany.mavenproject8;

import java.sql.*;

public class Mavenproject8 {

    public static void main(String[] args) {

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/java_test";
        String username = "user";
        String password = "user";

        // JDBC objects
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(url, username, password);

            // Create statement
            stmt = conn.createStatement();

            // Execute query
            String query = "SELECT * FROM employees";
            rs = stmt.executeQuery(query);

            // Process results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(name + " - " + age);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
