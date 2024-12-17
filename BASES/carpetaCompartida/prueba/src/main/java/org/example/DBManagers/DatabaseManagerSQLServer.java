package org.example.DBManagers;

import org.example.tarea2.objects.Departamento;
import org.example.tarea2.objects.Proxecto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManagerSQLServer {
    private Connection conexion;
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bdempresa;encrypt=true;trustServerCertificate=true";
    String user = "sa";
    String password = "abc123.";

    public DatabaseManagerSQLServer() throws SQLException {
        try {
            conexion = DriverManager.getConnection(url, user, password);
            conexion.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void createpr_cambioDomicilio() {
        String sql = "CREATE PROCEDURE pr_cambioDomicilio " +
                "@NSS_cliente varchar(15), " +
                "@rua_domicilio VARCHAR(30), " +
                "@numero_domicilio int, " +
                "@piso_domicilio VARCHAR(4), " +
                "@CP_domicilio CHAR(5), " +
                "@localidade_domicilio VARCHAR(25) " +
                "AS " +
                "BEGIN " +
                "    UPDATE EMPREGADO " +
                "    SET Rua = @rua_domicilio, " +
                "        Numero_rua = @numero_domicilio, " +
                "        Piso = @piso_domicilio, " +
                "        CP = @CP_domicilio, " +
                "        Localidade = @localidade_domicilio " +
                "    WHERE NSS = @NSS_cliente " +
                "END";

        Statement stmt = null;
        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(sql);  // Ejecuta la creación del procedimiento
            conexion.commit();  // Confirmar los cambios
            System.out.println("Procedimiento almacenado creado exitosamente.");
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();  // Revertir cambios en caso de error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();  // Cerrar Statement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int sp_cambioDomicilio(String NSS, String rua, int numero, String piso, String CP, String localidade) {
        String sql = "{call pr_cambioDomicilio(?, ?, ?, ?, ?, ?)}";
        CallableStatement cstmt = null;
        int filasAfectadas = 0;
        try {
            cstmt = conexion.prepareCall(sql);
            cstmt.setString(1, NSS);
            cstmt.setString(2, rua);
            cstmt.setInt(3, numero);
            cstmt.setString(4, piso);
            cstmt.setString(5, CP);
            cstmt.setString(6, localidade);
            filasAfectadas = cstmt.executeUpdate();  // Ejecuta el procedimiento almacenado
            conexion.commit();  // Confirmar los cambios
            System.out.println("Procedimiento almacenado ejecutado exitosamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filasAfectadas;
    }

    public void createpr_DatosProxectos() {
        String sql = "CREATE PROCEDURE pr_DatosProxectos " +
                "@num_proxecto int, " +
                "@nome_proxecto varchar(25) " +
                "OUTPUT, @lugar varchar(25) OUTPUT," +
                " @num_departamento int OUTPUT " +
                "AS " +
                " BEGIN" +
                " SELECT @nome_proxecto = Nome_Prxecto,@lugar = Lugar,@num_departamento = Num_Departamento " +
                " from PROXECTO     " +
                " WHERE PROXECTO.Num_proxecto = @num_proxecto " +
                "END";
        Statement stmt = null;
        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(sql);  // Ejecuta la creación del procedimiento
            conexion.commit();  // Confirmar los cambios
            System.out.println("Procedimiento almacenado creado exitosamente.");
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();  // Revertir cambios en caso de error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();  // Cerrar Statement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Proxecto pr_DatosProxectos(int i) {
        String sql = "{call pr_DatosProxectos(?, ?, ?, ?)}";
        CallableStatement cstmt = null;
        Proxecto proxecto = null;
        try {
            cstmt = conexion.prepareCall(sql);
            cstmt.setInt(1, i);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.registerOutParameter(4, Types.INTEGER);
            cstmt.execute();  // Ejecuta el procedimiento almacenado
            String nomeProxecto = cstmt.getString(2);
            String lugar = cstmt.getString(3);
            int numDepartamento = cstmt.getInt(4);
            proxecto = new Proxecto(i, nomeProxecto, lugar, numDepartamento);
            conexion.commit();  // Confirmar los cambios
            System.out.println("Procedimiento almacenado ejecutado exitosamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proxecto;
    }

    public void createpr_DepartControlaProxe() {
        String sql = "create procedure pr_DepartControlaProxe "
                + "@num_proxectos_controla int"
                + " AS "
                + "begin "
                + "select * from DEPARTAMENTO D where"
                + "        @num_proxectos_controla <= (select count(*) from PROXECTO P where P.num_departamento = D.num_departamento)"
                + "end";

        Statement stmt = null;
        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(sql);  // Ejecuta la creación del procedimiento
            conexion.commit();  // Confirmar los cambios
            System.out.println("Procedimiento almacenado creado exitosamente.");
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();  // Revertir cambios en caso de error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();  // Cerrar Statement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Departamento> pr_DepartControlaProxe(int i) {
        String sql = "{call pr_DepartControlaProxe(?)}";
        CallableStatement cstmt = null;
        List<Departamento> departamentos = new ArrayList(){
        };
        try {
            cstmt = conexion.prepareCall(sql);
            cstmt.setInt(1, i);
              // Ejecuta el procedimiento almacenado
            String algo = cstmt.toString();
            ResultSet resultSet = cstmt.executeQuery();
            while (resultSet.next()){
                int NumDep = resultSet.getInt(1);
                String NomeDep = resultSet.getString(2);
                String NSSdirige = resultSet.getString(3);
                Date dataDireccion = resultSet.getDate(4);
                departamentos.add(new Departamento(NumDep,NomeDep,NSSdirige,dataDireccion));
            }
            System.out.println("Procedimiento almacenado ejecutado exitosamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departamentos;

    }

    public void imprimirTiposDeResultset() {

    }

    public void ejecutarSentencia(String bd, String user, String password ,String sql) throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+bd+";encrypt=true;trustServerCertificate=true";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String[] sqls = sql.split(";");
        for (String s : sqls){
            statement.execute(s);
            ResultSet resultSet = statement.getResultSet();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSetMetaData.getColumnName(i) + " ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        }

    }

    public void infoDatabase() {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            //Nome base de datos
            System.out.println("Nome base de datos: " + metaData.getDatabaseProductName());
            //Número de versión do SXBD
            System.out.println("Número de versión do SXBD: " + metaData.getDatabaseProductVersion());
            //Número de versión principal do SXBD
            System.out.println("Número de versión principal do SXBD: " + metaData.getDatabaseMajorVersion());
            //Número de versión secundario do SXBD
            System.out.println("Número de versión secundario do SXBD: " + metaData.getDatabaseMinorVersion());
            //Nome do conectador JDBC utilizado
            System.out.println("Nome do conectador JDBC utilizado: " + metaData.getDriverName());
            //Número da versión principal do conectador JDBC
            System.out.println("Número da versión principal do conectador JDBC: " + metaData.getDriverMajorVersion());
            //Número da versión secundaria do conectador JDBC
            System.out.println("Número da versión secundaria do conectador JDBC: " + metaData.getDriverMinorVersion());
            //Número de versión do conectador JDBC utilizado
            System.out.println("Número de versión do conectador JDBC utilizado: " + metaData.getDriverVersion());
            //URL da base de datos
            System.out.println("URL da base de datos: " + metaData.getURL().split(";")[0]);
            //Nome do usuario actual conectado á base de datos
            System.out.println("Nome do usuario actual conectado á base de datos: " + metaData.getUserName());
            //Si a base de datos é de só lectura
            System.out.println("A base de datos é de só lectura: " + metaData.isReadOnly());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tablesInfo(String bd) {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet tables = metaData.getTables(bd, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Táboa: " + tableName);
                ResultSet columns = metaData.getColumns(null, null, tableName, "%");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    int columnSize = columns.getInt("COLUMN_SIZE");
                    boolean isNullable = columns.getInt("NULLABLE") == 1;
                    System.out.println("    Columna: " + columnName + " Tipo: " + columnType + " Tamaño: " + columnSize + " Admite valores nulos: " + isNullable);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tableColumnsInfo(String dbo, String empregado) {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet columns = metaData.getColumns(null, dbo, empregado, "%");
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");
                boolean isNullable = columns.getInt("NULLABLE") == 1;
                System.out.println("Columna: " + columnName + " Tipo: " + columnType + " Tamaño: " + columnSize + " Admite valores nulos: " + isNullable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void proceduresInfo() {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet procedures = metaData.getProcedures(null, null, "%");
            while (procedures.next()) {
                String procedureName = procedures.getString("PROCEDURE_NAME");
                System.out.println("Procedemento: " + procedureName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void primaryKeyColumnsInfo(String dbo, String empregado) {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, dbo, empregado);
            while (primaryKeys.next()) {
                String columnName = primaryKeys.getString("COLUMN_NAME");
                System.out.println("Columna de clave primaria: " + columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void foreignKeyColumnsInfo(String dbo, String empregado) {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet foreignKeys = metaData.getImportedKeys(null, dbo, empregado);
            while (foreignKeys.next()) {
                String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
                String pkTableName = foreignKeys.getString("PKTABLE_NAME");
                String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
                System.out.println("Columna de clave foránea: " + fkColumnName + " Taboa de referencia: " + pkTableName + " Columna de referencia: " + pkColumnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryInfo(String bd, String user, String password, String sql) {
        try {
           String url = "jdbc:sqlserver://localhost:1433;databaseName="+bd+";encrypt=true;trustServerCertificate=true";
            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            System.out.println("Número de columnas recuperadas: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Nome: " + resultSetMetaData.getColumnName(i) + " Tipo: " + resultSetMetaData.getColumnTypeName(i) + " Tamaño: " + resultSetMetaData.getColumnDisplaySize(i) + " Admite valores nulos: " + resultSetMetaData.isNullable(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
