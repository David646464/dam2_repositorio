package org.example.tarea7;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea7_1 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.crearTablasFamiliares();
    }
}
