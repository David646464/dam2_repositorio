package org.example.CampoDePruebas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMigrateSqlServerToMySql {
    private Connection MySqlconexion;
    private String MySqlurl = "jdbc:mysql://127.0.0.1:3306/empresanew";
    private String MySqluser = "root";
    private String MySqlpassword = "abc123.";

    private Connection SqlServerconexion;
    private String SqlServerurl = "jdbc:sqlserver://localhost:1433;databaseName=empresanew;encrypt=true;trustServerCertificate=true";
    private String SqlServeruser = "sa";
    private String SqlServerpassword = "abc123.";

    public DatabaseMigrateSqlServerToMySql() throws SQLException {
        try {
            MySqlconexion = DriverManager.getConnection(MySqlurl, MySqluser, MySqlpassword);
            MySqlconexion.setAutoCommit(false);
            SqlServerconexion = DriverManager.getConnection(SqlServerurl, SqlServeruser, SqlServerpassword);
            SqlServerconexion.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void migrate() throws SQLException {
        //Crear la base de datos
        migrateDatabase();
        //Crear las tablas en el otro
        migrateTables();
        //Migrar la información qu contiene cada tabla
        migrateInfo();
        //Poner las claves foraneas
        migrateForeignKeys();


    }

    private void migrateForeignKeys() {
    try {
        DatabaseMetaData databaseMetaData = SqlServerconexion.getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, "dbo", null, new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            ResultSet foreignKeys = databaseMetaData.getImportedKeys(null, "dbo", tableName);
            while (foreignKeys.next()) {
                String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
                String pkTableName = foreignKeys.getString("PKTABLE_NAME");
                String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
                String sql = "ALTER TABLE " + tableName + " ADD CONSTRAINT " + tableName + "_" + fkColumnName + "_fk FOREIGN KEY (" + fkColumnName + ") REFERENCES " + pkTableName + "(" + pkColumnName + ");";
                MySqlconexion.prepareStatement(sql).execute();
            }
        }
        MySqlconexion.commit();
    } catch (SQLException e) {
        //mensaje de error porque hay datos con clave foranea sin referencia existente
        System.err.println("Error al migrar las claves foraneas ya que no existe la referencia:\n " + e.getMessage());

    }
}

    private void migrateInfo() {
        try {
            //TODO: Migrate data
            DatabaseMetaData databaseMetaData = SqlServerconexion.getMetaData();
            ResultSet tables = databaseMetaData.getTables(null, "dbo", null, new String[]{"TABLE"});
            while (tables.next()) {
                int numColumns = 0;
                String tableName = tables.getString("TABLE_NAME");
                StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
                ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null);
                while (columns.next()) {
                    numColumns++;
                    String columnName = columns.getString("COLUMN_NAME");
                    sql.append(columnName).append(",");
                }
                sql.deleteCharAt(sql.length() - 1);
                sql.append(")");
                ResultSet data = SqlServerconexion.createStatement().executeQuery("SELECT * FROM " + tableName);
                sql.append(" VALUES (");
                String original = sql.toString();
                while (data.next()) {
                    sql = new StringBuilder(original);
                    for (int i = 1; i <= numColumns; i++) {
                        sql.append(detectarString(data.getString(i))).append(",");
                    }
                    sql.deleteCharAt(sql.length() - 1);
                    sql.append(")");
                    MySqlconexion.prepareStatement(sql.toString()).execute();
                }
            }
            MySqlconexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String detectarString(String string) {
       try {
           Integer num = Integer.valueOf(string);
       }catch (Exception e){
           return "'" + string + "'";
       }
       return string;
    }

    private void migrateTables() throws SQLException {
        DatabaseMetaData databaseMetaData = SqlServerconexion.getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, "dbo", null, new String[]{"TABLE"});
        List<String> tablesWithoutForeignKeys = new ArrayList<>();
        List<String> tablesWithForeignKeys = new ArrayList<>();

        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            ResultSet foreignKeys = databaseMetaData.getImportedKeys(null, "dbo", tableName);
            if (foreignKeys.next()) {
                tablesWithForeignKeys.add(tableName);
            } else {
                tablesWithoutForeignKeys.add(tableName);
            }
        }

        // Create tables without foreign keys first
        for (String tableName : tablesWithoutForeignKeys) {
            createTable(databaseMetaData, tableName);
        }

        // Create tables with foreign keys
        for (String tableName : tablesWithForeignKeys) {
            createTable(databaseMetaData, tableName);
        }
    }


    private void createTable(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + "(");
        ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null);
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            String columnType = columns.getString("TYPE_NAME");
            int columnSize = columns.getInt("COLUMN_SIZE");
            boolean isNullable = columns.getInt("NULLABLE") == 1;
            switch (columnType) {
                case "int":
                    sql.append(columnName).append(" INT,");
                    break;
                case "varchar":
                    sql.append(columnName).append(" VARCHAR(").append(columnSize).append("),");
                    break;
                case "date":
                    sql.append(columnName).append(" DATE,");
                    break;
                case "float":
                    sql.append(columnName).append(" FLOAT,");
                    break;
                case "char":
                    sql.append(columnName).append(" CHAR(").append(columnSize).append("),");
                    break;
                case "int identity":
                    sql.append(columnName).append(" INT AUTO_INCREMENT,");//hardcoded
                    break;
                case "datetime":
                    sql.append(columnName).append(" DATETIME,");
                    break;
                case "bit":
                    sql.append(columnName).append(" BIT,");
                    break;
                case "decimal":
                    sql.append(columnName).append(" DECIMAL,");
                    break;
            }
        }
        sql.deleteCharAt(sql.length() - 1);

       // Handle primary keys
       ResultSet primaryKeys = databaseMetaData.getPrimaryKeys(null, null, tableName);
       StringBuilder primaryKeySql = new StringBuilder(", PRIMARY KEY (");
       boolean hasPrimaryKey = false;
       while (primaryKeys.next()) {
           if (hasPrimaryKey) {
               primaryKeySql.append(", ");
           }
           primaryKeySql.append(primaryKeys.getString("COLUMN_NAME"));
           hasPrimaryKey = true;
       }
       if (hasPrimaryKey) {
           primaryKeySql.append(")");
           sql.append(primaryKeySql);
       }
//        // Handle foreign keys
//        ResultSet foreignKeys = databaseMetaData.getImportedKeys(null, null, tableName);
//        while (foreignKeys.next()) {
//            String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
//            String pkTableName = foreignKeys.getString("PKTABLE_NAME");
//            String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
//            sql.append(", FOREIGN KEY (").append(fkColumnName).append(") REFERENCES ").append(pkTableName.toLowerCase()).append("(").append(pkColumnName).append(")");
//        }
        sql.append(")");
        MySqlconexion.prepareStatement(sql.toString()).execute();
        MySqlconexion.commit();
    }

    private void migrateDatabase() {
        try {
            String sql = "DROP DATABASE IF EXISTS bdempresa";
            MySqlconexion.prepareStatement(sql).execute();
            sql = "CREATE DATABASE bdempresa";
            MySqlconexion.prepareStatement(sql).execute();
            MySqlconexion.commit();

            // Update the connection URL to include the database name
            MySqlconexion.close();
            MySqlconexion = DriverManager.getConnection(MySqlurl, MySqluser, MySqlpassword);
            MySqlconexion.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
