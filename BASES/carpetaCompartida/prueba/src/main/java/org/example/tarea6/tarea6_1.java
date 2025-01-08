package org.example.tarea6;

import org.example.DBManagers.DatabaseMigrateSqlServerToMySql;

import java.sql.SQLException;

public class tarea6_1 {
    public static void main(String[] args) throws SQLException {
        DatabaseMigrateSqlServerToMySql databaseMigrateSqlServerToMySql = new DatabaseMigrateSqlServerToMySql();
        databaseMigrateSqlServerToMySql.migrate();
    }
}
