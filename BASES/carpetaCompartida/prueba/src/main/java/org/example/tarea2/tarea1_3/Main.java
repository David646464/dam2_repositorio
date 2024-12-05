package org.example.tarea2.tarea1_3;

import org.example.DBManagers.DatabaseManagerMYSQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerMYSQL databaseManagerMYSQL = new DatabaseManagerMYSQL();
        //A)
        //databaseManagerMYSQL.cambiarDepartamentoQueDirigeUnproyecto("PERSOAL", 7);
        //B)
        //Proxecto proxecto = new Proxecto(11, "ProxectoPrueba", "Santiago", 5);
        //databaseManagerMYSQL.novoProxecto(proxecto);
        //C)
        databaseManagerMYSQL.borrarProxectoCascada(10);

    }
}
