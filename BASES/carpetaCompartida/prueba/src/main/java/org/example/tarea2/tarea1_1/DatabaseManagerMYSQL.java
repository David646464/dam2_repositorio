package org.example.tarea2.tarea1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManagerMYSQL {
    private Connection conexion;
    String url = "jdbc:mysql://127.0.0.1:3306/bdempresa";
    String user = "root";
    String password = "abc123.";

    public DatabaseManagerMYSQL() {
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public int aumentarSueldoEnUnDepartamento(int aumento, String nomeDepartamento){
        int filasAfectadas = 0;
        try {
            String sql = "UPDATE empregado SET Salario = Salario + ? WHERE Num_departamento_pertenece = (SELECT Num_departamento FROM departamento WHERE Nome_departamento = ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, aumento);
            preparedStatement.setString(2, nomeDepartamento);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filasAfectadas;
    }
}
