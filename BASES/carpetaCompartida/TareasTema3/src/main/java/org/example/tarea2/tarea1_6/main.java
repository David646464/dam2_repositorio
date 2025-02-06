package org.example.tarea2.tarea1_6;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        //a)
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.imprimirTiposDeResultset();
    }
}
