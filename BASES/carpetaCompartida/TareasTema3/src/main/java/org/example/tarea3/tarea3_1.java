package org.example.tarea3;

import org.example.DBManagers.DatabaseManagerSQLServer;

import java.sql.SQLException;

public class tarea3_1 {
    public static void main(String[] args) throws SQLException {
        /*Crea un método para que mostre a seguinte información: nome do SXBD, número de versión
        do SXBD, número de versión principal do SXBD, número de versión secundario do SXBD,
        nome do conectador JDBC utilizado, número da versión principal do conectador JDBC,
        número da versión secundaria do conectador JDBC, número de versión do conectador JDBC
        utilizado, URL da base de datos, nome do usuario actual conectado á base de datos e si a base
        de datos é de só lectura*/
        DatabaseManagerSQLServer databaseManagerSQLServer = new DatabaseManagerSQLServer();
        databaseManagerSQLServer.infoDatabase();
    }
}
