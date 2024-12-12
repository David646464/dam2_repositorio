package org.example.tarea2.tarea1_5;

import org.example.DBManagers.DatabaseManagerMYSQL;
import org.example.DBManagers.DatabaseManagerSQLServer;
import org.example.tarea2.objects.Departamento;
import org.example.tarea2.objects.Proxecto;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();

        //a)
        //databaseManagerSQLServer.createpr_cambioDomicilio();
        //System.out.println(databaseManagerSQLServer.sp_cambioDomicilio("0010010", "Prueba", 1, "1-P", "36826", "LocalidadePrueba"));

        //b)
        //databaseManagerSQLServer.createpr_DatosProxectos();
        //Proxecto proxecto = databaseManagerSQLServer.pr_DatosProxectos(1);
        //System.out.println(proxecto);

        //c)
        //databaseManagerSQLServer.createpr_DepartControlaProxe();
        //List<Departamento> list = databaseManagerSQLServer.pr_DepartControlaProxe(3);
        //for (Departamento departamento : list){
        //    System.out.println(departamento.toString());
        //}

        //d)
         
    }
}
