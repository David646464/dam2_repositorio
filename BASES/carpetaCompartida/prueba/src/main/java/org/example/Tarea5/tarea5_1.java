package org.example.Tarea5;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea5_1 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.ejecutarSentencia("bdempresa","sa","abc123.","select * from EMPREGADO;select * from DEPARTAMENTO;");
    }
}
