package org.example.tarea3;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea3_7 {
    public static void main(String[] args) throws SQLException {
        /*Engade ao programa creado na tarefa1, un método que reciba unha consulta (por ex. SELECT *
        FROM proxecto) e imprima o número de columnas recuperadas, e por cada columna: o nome, tipo,
        tamaño e si admite ou non nulos.*/
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.queryInfo("bdempresa","sa","abc123.","select * from EMPREGADO;");
    }
}
