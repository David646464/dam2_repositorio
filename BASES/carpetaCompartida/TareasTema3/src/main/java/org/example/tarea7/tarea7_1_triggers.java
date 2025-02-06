package org.example.tarea7;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;
import java.time.LocalDate;

public class tarea7_1_triggers {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.crearTablasFamiliares();
        databaseManagerSQLServer.anhadirFamiliar("0010010","25435545","Juan2","Perez","Garcia", LocalDate.now(),"Hermano",'H');

    }
}
