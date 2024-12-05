package org.example.Connections;

import java.sql.*;

public class MainSelects {
    public static void main(String[] args) {
        imprimirTablaDeUnaBDMySql("empregado");
    }

    private static void imprimirTablaDeUnaBDMySql(String tabla) {
        String url = "jdbc:mysql://127.0.0.1:3306/bdempresa";
        String user = "root";
        String password = "abc123.";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            //Hacer un select de la tabla
            String sql = "SELECT * FROM " + tabla;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Table " + tabla + ":");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }


}
