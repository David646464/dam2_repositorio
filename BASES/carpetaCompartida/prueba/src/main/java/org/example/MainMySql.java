package org.example;

import java.sql.*;

public class MainMySql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/bdempresa";
        String user = "root";
        String password = "abc123.";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("Tables in the database:");
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
