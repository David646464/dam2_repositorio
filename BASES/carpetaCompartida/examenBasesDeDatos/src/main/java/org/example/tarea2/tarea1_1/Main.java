package org.example.tarea2.tarea1_1;

import org.example.DBManagers.DatabaseManagerMYSQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerMYSQL databaseManagerMYSQL = new DatabaseManagerMYSQL();
        //A)
        /* int filasAfectadas = databaseManagerMYSQL.aumentarSueldoEnUnDepartamento(100, "PERSOAL");
        System.out.println("Filas afectadas: " + filasAfectadas);*/
        //B)
        /*        int filasAfectadas = databaseManagerMYSQL.novoDepartamento(10, "DEPARTAMENTOPrueba", 0010010);
        */
        //C)
        int filasAfectadas = databaseManagerMYSQL.borrarEmpregadoDeUnProxecto("0110010", 7);
        System.out.println("Filas afectadas: " + filasAfectadas);
    }

}
