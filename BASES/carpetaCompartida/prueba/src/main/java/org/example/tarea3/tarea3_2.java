package org.example.tarea3;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea3_2 {
    public static void main(String[] args) throws SQLException {
        /*a) Método que mostre información de todas as táboas de usuario da base de datos BDEmpresa.
        b) Método que reciba un esquema e unha táboa como parámetros e visualice as súas columnas.
        Mostrarase para cada columna, o nome, tipo de datos, tamaño e si admite valores nulos ou non.
        c) Método que mostre información de todos os procedementos da base de datos BDEmpresa.
        d) Método que reciba un esquema e unha táboa como parámetros e visualice as súas columnas de clave
        primaria.
        e) Método que reciba un esquema e unha táboa e visualice as súas columnas de clave foráneas.
        Mostrarase para cada columna de clave foránea a columna e a táboa a que referencia.*/


        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        //a)
        databaseManagerSQLServer.tablesInfo("bdempresa");
        //b)
        //databaseManagerSQLServer.tableColumnsInfo("dbo","EMPREGADO");
        //c)
        //databaseManagerSQLServer.proceduresInfo();
        //d)
        //databaseManagerSQLServer.primaryKeyColumnsInfo("dbo","EMPREGADO");
        //e)
        //databaseManagerSQLServer.foreignKeyColumnsInfo("dbo","EMPREGADO");
    }
}
