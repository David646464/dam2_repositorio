package org.example.Tarea5;

import org.example.DBManagers.DatabaseManagerSQLServer;
import org.example.Tarea5.objects.VehiculoEmpresa;
import org.example.Tarea5.objects.VehiculoRenting;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class tarea5_2 {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new  DatabaseManagerSQLServer();
       databaseManagerSQLServer.crearTablasVehiculos();
        VehiculoEmpresa vehiculoEmpresa = new VehiculoEmpresa('D',"Ibiza","Seat","1227DCC",
                Date.valueOf(LocalDate.now()),200);
       VehiculoRenting vehiculoRenting = new VehiculoRenting('D',"Ibiza","Seat","1227DCC",Date.valueOf(LocalDate.now()),200,2);
       databaseManagerSQLServer.anhadirVehiculo(vehiculoRenting);
       databaseManagerSQLServer.anhadirVehiculo(vehiculoEmpresa);

    }
}
