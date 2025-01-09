package org.example.Tarea5;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea5_3 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        //databaseManagerSQLServer.anhairvehiculosDeUnGson("src/main/java/org/example/Files/InsertarVehiculos.json");
        databaseManagerSQLServer.sacarEnJsonVehiculos("src/main/java/org/example/Files/VehiculosBaseDatos.json");
    }
}
