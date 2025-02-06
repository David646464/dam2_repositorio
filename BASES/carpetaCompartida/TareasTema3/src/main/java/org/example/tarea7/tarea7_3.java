package org.example.tarea7;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea7_3 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.anhadirFamiliaresDeUnJson("src/main/java/org/example/Files/Familiares.json");
    }
}
