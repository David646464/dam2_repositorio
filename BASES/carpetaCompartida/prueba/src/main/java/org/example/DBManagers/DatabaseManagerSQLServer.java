package org.example.DBManagers;

import org.example.tarea2.objects.Proxecto;

import java.sql.*;

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
        String sql = "CREATE PROCEDURE pr_DatosProxectos "
                //Datos entrada
                +"@num_proxecto int, "
                //Datos salida
                +"@nome_proxecto varchar(25) OUTPUT, "
                +"@lugar varchar(25) OUTPUT, "
                +"@num_departamento int OUTPUT "
                +"AS "
                +"BEGIN "
                +"    SELECT @nome_proxecto = Nome_Prxecto,@lugar = Lugar,@num_departamento = Num_Departamento from PROXECTO "
                +"    WHERE PROXECTO.Num_proxecto = @num_proxecto "
                +"END";

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
}
