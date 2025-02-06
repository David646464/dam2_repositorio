package org.example.tarea7;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea7_2 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.anhadirFamiliar("0010010","25435545","Juan2","Perez","Garcia", java.time.LocalDate.now(),"Hermano",'H');
    }
}
