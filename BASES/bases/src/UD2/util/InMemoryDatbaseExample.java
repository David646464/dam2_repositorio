package UD2.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class InMemoryDatabaseExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Create an in-memory SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            statement = connection.createStatement();

            // Create a table
            String createTableSQL = "CREATE TABLE students (id INTEGER PRIMARY KEY, name TEXT)";
            statement.execute(createTableSQL);

            // Insert data
            String insertDataSQL = "INSERT INTO students (name) VALUES ('Alice'), ('Bob'), ('Charlie')";
            statement.execute(insertDataSQL);

            // Query data
            String querySQL = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(querySQL);

            // Print the results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}