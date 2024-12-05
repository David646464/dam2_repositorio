package org.example.tarea2.tarea1_4;

import org.example.DBManagers.DatabaseManagerMYSQL;
import org.example.tarea2.objects.Proxecto;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerMYSQL databaseManagerMYSQL = new DatabaseManagerMYSQL();
        ArrayList<Proxecto> proxectos = databaseManagerMYSQL.getListaProxectosPorDepartamento("ESTADÍSTICA");
        for (Proxecto proxecto : proxectos) {
            System.out.println(proxecto);
        }

    }
}
