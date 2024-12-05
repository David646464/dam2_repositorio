package org.example.tarea2.tarea1_2;

import org.example.DBManagers.DatabaseManagerMYSQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerMYSQL databaseManagerMYSQL = new DatabaseManagerMYSQL();
        databaseManagerMYSQL.imprimirInformacionDeEmpregadoPorLocalidade("Santiago");
    }
}
