package org.example.Tarea5;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea5_2 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new  DatabaseManagerSQLServer();
        databaseManagerSQLServer.crearTablasVehiculos();
    }
}
