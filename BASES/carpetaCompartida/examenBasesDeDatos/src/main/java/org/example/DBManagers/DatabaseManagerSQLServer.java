package org.example.DBManagers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.Tarea5.objects.Vehiculo;
import org.example.Tarea5.objects.VehiculoEmpresa;
import org.example.Tarea5.objects.VehiculoRenting;
import org.example.tarea2.objects.Departamento;
import org.example.tarea2.objects.Proxecto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        List<Departamento> departamentos = new ArrayList() {
        };
        try {
            cstmt = conexion.prepareCall(sql);
            cstmt.setInt(1, i);
            // Ejecuta el procedimiento almacenado
            String algo = cstmt.toString();
            ResultSet resultSet = cstmt.executeQuery();
            while (resultSet.next()) {
                int NumDep = resultSet.getInt(1);
                String NomeDep = resultSet.getString(2);
                String NSSdirige = resultSet.getString(3);
                Date dataDireccion = resultSet.getDate(4);
                departamentos.add(new Departamento(NumDep, NomeDep, NSSdirige, dataDireccion));
            }
            System.out.println("Procedimiento almacenado ejecutado exitosamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departamentos;

    }

    public void imprimirTiposDeResultset() {

    }

    public void ejecutarSentencia(String bd, String user, String password, String sql) throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + bd + ";encrypt=true;trustServerCertificate=true";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String[] sqls = sql.split(";");
        for (String s : sqls) {
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
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + bd + ";encrypt=true;trustServerCertificate=true";
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

    public void crearTablasVehiculos() {
        try {
            //Si existen las borra

            Statement statement = conexion.createStatement();
            String sql = "CREATE TABLE VEHICULO" +
                    "(" +
                    "    codVehiculo     int IDENTITY(1,1)," +
                    "    Matricula       CHAR(10)," +
                    "    Marca           VARCHAR(20)," +
                    "    Modelo          VARCHAR(20)," +
                    "    TipoCombustible char(1)," +
                    "    constraint PK_VEHICULO PRIMARY KEY (codVehiculo)," +
                    "    constraint CK_VEHICULO_TIPOCOMBUSTIBLE CHECK (TipoCombustible IN ('G', 'D'))," +
                    "    constraint CK_VEHICULO_MATRICULA CHECK (" +
                    "        Matricula LIKE '[A-Z][A-Z][0-9][0-9][0-9][0-9][A-Z][A-Z][A-Z]' OR\n" +
                    "        Matricula LIKE '[A-Z][A-Z][0-9][0-9][0-9][0-9][A-Z]' " +
                    "    )" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Táboa VEHICULO creada exitosamente.");
            sql = "CREATE TABLE VEHICULO_EMPRESA" +
                    "(" +
                    "    codVehiculoEmpresa    int IDENTITY(1,1)," +
                    "    codVehiculo           int," +
                    "    FechaCompra           DATE," +
                    "    Precio                DECIMAL(10, 2)," +
                    "    constraint PK_VEHICULO_EMPRESA PRIMARY KEY (codVehiculoEmpresa)," +
                    "    constraint FK_VEHICULO_VE FOREIGN KEY (codVehiculo) REFERENCES VEHICULO(codVehiculo)" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Táboa VEHICULO_EMPRESA creada exitosamente.");
            sql = "CREATE TABLE VEHICULO_RENTING" +
                    "(" +
                    "    codVehiculoRenting    int IDENTITY(1,1)," +
                    "    codVehiculo           int," +
                    "    FechaInicio           DATE," +
                    "    PrecioMensual         DECIMAL(10, 2)," +
                    "    numMeses              int," +
                    "    constraint PK_VEHICULO_RENTING PRIMARY KEY (codVehiculoRenting)," +
                    "    constraint FK_VEHICULO_VR FOREIGN KEY (codVehiculo) REFERENCES VEHICULO(codVehiculo)" +
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Táboa VEHICULO_RENTING creada exitosamente.");
            conexion.commit();

        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void anhadirVehiculo(Vehiculo vehiculo) throws SQLException {
        try {

            conexion.setAutoCommit(false);

            if (VehiculoExiste(vehiculo.getMatricula())) {
                throw new SQLException("Ya existe un vehículo con la matrícula " + vehiculo.getMatricula());
            }

            String sql = "INSERT INTO VEHICULO (matricula, marca, modelo, tipocombustible) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, vehiculo.getMatricula());
            preparedStatement.setString(2, vehiculo.getMarca());
            preparedStatement.setString(3, vehiculo.getModelo());
            preparedStatement.setString(4, String.valueOf(vehiculo.getTipoConbustible()));

            ResultSet generatedKeys;
            synchronized (this) {
                preparedStatement.executeUpdate();
                generatedKeys = preparedStatement.getGeneratedKeys();
            }
            if (generatedKeys.next()) {
                vehiculo.setCodvehiculo(generatedKeys.getInt(obtenerClavePrimariaTabla("VEHICULO")));
            }


            if (vehiculo instanceof VehiculoRenting) {
                sql = "INSERT INTO VEHICULO_RENTING (codVehiculo, FechaInicio, PrecioMensual, numMeses) VALUES (?, ?, ?, ?)";
                preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setInt(1, vehiculo.getCodvehiculo());
                preparedStatement.setDate(2, ((VehiculoRenting) vehiculo).getFechaInicio());
                preparedStatement.setFloat(3, ((VehiculoRenting) vehiculo).getPrecioMensual());
                preparedStatement.setInt(4, ((VehiculoRenting) vehiculo).getNumMeses());
                preparedStatement.executeUpdate();
            } else {
                sql = "INSERT INTO VEHICULO_EMPRESA (codVehiculo, FechaCompra, Precio) VALUES (?, ?, ?)";
                preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setInt(1, vehiculo.getCodvehiculo());
                preparedStatement.setDate(2, ((VehiculoEmpresa) vehiculo).getFechaCompra());
                preparedStatement.setFloat(3, ((VehiculoEmpresa) vehiculo).getPrecio());
                preparedStatement.executeUpdate();
            }


            conexion.commit();

        } catch (SQLException e) {

            e.printStackTrace();
            conexion.rollback();
        } finally {

            try {
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean VehiculoExiste(String matricula) {
        try {
            String sql = "SELECT * FROM VEHICULO WHERE matricula = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, matricula);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int obtenerClavePrimariaTabla(String table) {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, table);
            if (primaryKeys.next()) {
                return primaryKeys.getInt("KEY_SEQ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void anhairvehiculosDeUnGson(String file) {
        try {
            conexion.setAutoCommit(false);

            Gson gson = new Gson();
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
            Type vehiculoListType = new TypeToken<ArrayList<JsonObject>>() {
            }.getType();
            List<JsonObject> vehiculosJson = gson.fromJson(jsonObject.get("vehiculos"), vehiculoListType);

            for (JsonObject vehiculoJson : vehiculosJson) {
                try {
                    String matricula = vehiculoJson.get("matricula").getAsString();
                    if (matriculaEsCorrecta(matricula)) {
                        String marca = vehiculoJson.get("marca").getAsString();
                        String modelo = vehiculoJson.get("modelo").getAsString();
                        char tipo = vehiculoJson.get("tipo").getAsCharacter();

                        if (vehiculoJson.has("vehiculoPropio")) {
                            JsonObject vehiculoPropioJson = vehiculoJson.getAsJsonObject("vehiculoPropio");
                            Date fechaCompra = Date.valueOf(vehiculoPropioJson.get("fechaCompra").getAsString());
                            float precio = vehiculoPropioJson.get("precio").getAsFloat();

                            VehiculoEmpresa vehiculoEmpresa = new VehiculoEmpresa(tipo, modelo, marca, matricula, fechaCompra, precio);
                            anhadirVehiculo(vehiculoEmpresa);
                        } else if (vehiculoJson.has("vehiculoRenting")) {
                            JsonObject vehiculoRentingJson = vehiculoJson.getAsJsonObject("vehiculoRenting");
                            Date fechaInicio = Date.valueOf(vehiculoRentingJson.get("fechaInicio").getAsString());
                            float precioMensual = vehiculoRentingJson.get("precioMensual").getAsFloat();
                            int numMeses = vehiculoRentingJson.get("meses").getAsInt();

                            VehiculoRenting vehiculoRenting = new VehiculoRenting(tipo, modelo, marca, matricula, fechaInicio, precioMensual, numMeses);
                            anhadirVehiculo(vehiculoRenting);
                        }
                    } else {
                        throw new SQLException("La matrícula " + matricula + " no es correcta.");
                    }
                } catch (Exception e) {
                    System.err.println("Error procesando el vehículo: " + e.getMessage());
                }
            }

            conexion.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean matriculaEsCorrecta(String matricula) {
        String regex = "^[0-9]{4}[A-Z]{3}$|^[A-Z]{2}[0-9]{4}[A-Z]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matricula);
        return matcher.matches();
    }

    public void sacarEnJsonVehiculos(String file) {
    try {
        Gson gson = new Gson();
        List<JsonObject> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM VEHICULO_RENTING";
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int codVehiculo = resultSet.getInt("codVehiculo");
            Date fechaInicio = resultSet.getDate("FechaInicio");
            float precioMensual = resultSet.getFloat("PrecioMensual");
            int numMeses = resultSet.getInt("numMeses");
            String sqlVehiculo = "SELECT * FROM VEHICULO WHERE codVehiculo = " + codVehiculo;
            Statement statementVehiculo = conexion.createStatement();
            ResultSet resultSetVehiculo = statementVehiculo.executeQuery(sqlVehiculo);
            if (resultSetVehiculo.next()) {
                String matricula = resultSetVehiculo.getString("Matricula").trim();
                String marca = resultSetVehiculo.getString("Marca");
                String modelo = resultSetVehiculo.getString("Modelo");
                char tipoCombustible = resultSetVehiculo.getString("TipoCombustible").charAt(0);

                JsonObject vehiculoJson = new JsonObject();
                vehiculoJson.addProperty("matricula", matricula);
                vehiculoJson.addProperty("marca", marca);
                vehiculoJson.addProperty("modelo", modelo);
                vehiculoJson.addProperty("tipo", String.valueOf(tipoCombustible));

                JsonObject vehiculoRentingJson = new JsonObject();
                vehiculoRentingJson.addProperty("fechaInicio", fechaInicio.toString());
                vehiculoRentingJson.addProperty("precioMensual", precioMensual);
                vehiculoRentingJson.addProperty("meses", numMeses);

                vehiculoJson.add("vehiculoRenting", vehiculoRentingJson);
                vehiculos.add(vehiculoJson);
            }
        }

        sql = "SELECT * FROM VEHICULO_EMPRESA";
        statement = conexion.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int codVehiculo = resultSet.getInt("codVehiculo");
            Date fechaCompra = resultSet.getDate("FechaCompra");
            float precio = resultSet.getFloat("Precio");
            String sqlVehiculo = "SELECT * FROM VEHICULO WHERE codVehiculo = " + codVehiculo;
            Statement statementVehiculo = conexion.createStatement();
            ResultSet resultSetVehiculo = statementVehiculo.executeQuery(sqlVehiculo);
            if (resultSetVehiculo.next()) {
                String matricula = resultSetVehiculo.getString("Matricula").trim();
                String marca = resultSetVehiculo.getString("Marca");
                String modelo = resultSetVehiculo.getString("Modelo");
                char tipoCombustible = resultSetVehiculo.getString("TipoCombustible").charAt(0);

                JsonObject vehiculoJson = new JsonObject();
                vehiculoJson.addProperty("matricula", matricula);
                vehiculoJson.addProperty("marca", marca);
                vehiculoJson.addProperty("modelo", modelo);
                vehiculoJson.addProperty("tipo", String.valueOf(tipoCombustible));

                JsonObject vehiculoPropioJson = new JsonObject();
                vehiculoPropioJson.addProperty("fechaCompra", fechaCompra.toString());
                vehiculoPropioJson.addProperty("precio", precio);

                vehiculoJson.add("vehiculoPropio", vehiculoPropioJson);
                vehiculos.add(vehiculoJson);
            }
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("vehiculos", gson.toJsonTree(vehiculos));
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(jsonObject, writer);
        }

    } catch (SQLException | IOException e) {
        throw new RuntimeException(e);
    }
}

     public void eliminarDePartamentoConReasignamiento(String departamentoAEliminar, String departamentoReasignar, String jsonFile) throws SQLException {
        conexion.setAutoCommit(false);
        try {
            // Obtener el código del departamento a eliminar
            int codDepartamentoAEliminar = obtenerCodigoDepartamento(departamentoAEliminar);
            int codDepartamentoReasignar = obtenerCodigoDepartamento(departamentoReasignar);

            if (codDepartamentoAEliminar == -1 || codDepartamentoReasignar == -1) {
                throw new SQLException("Uno de los departamentos proporcionados no existe.");
            } else if (codDepartamentoAEliminar == codDepartamentoReasignar) {
                throw new SQLException("Los departamentos proporcionados son iguales.");
            }

            // Visualizar datos del departamento a eliminar
            System.out.println("Datos del departamento a eliminar:");
            visualizarDatosDepartamento(codDepartamentoAEliminar);
            System.out.println("Datos del departamento a reasignar:");
            visualizarDatosDepartamento(codDepartamentoReasignar);

            // Visualizar datos de los empleados pertenecientes al departamento a eliminar
            List<JsonObject> empleadosReasignados = visualizarDatosEmpleados(codDepartamentoAEliminar, codDepartamentoReasignar);

            // Visualizar datos de los proyectos que controla el departamento a eliminar
            List<JsonObject> proyectosReasignados = visualizarDatosProyectos(codDepartamentoAEliminar, codDepartamentoReasignar);

            // Eliminar el departamento y reasignar empleados y proyectos
            eliminarDepartamento(codDepartamentoAEliminar, codDepartamentoReasignar);

            // Generar archivo JSON con la información de la actualización
            generarArchivoJson(empleadosReasignados, proyectosReasignados, codDepartamentoAEliminar, departamentoAEliminar, jsonFile);
            
            conexion.commit();
        } catch (SQLException | IOException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int obtenerCodigoDepartamento(String nombreDepartamento) throws SQLException {
        //Comprobar si existe el procidemiento y si no lo crea
        comprobarExitencia();
        String sql = "{call pr_ObtenerCodigoDepartamento(?, ?)}";
        CallableStatement cstmt = conexion.prepareCall(sql);
        cstmt.setString(1, nombreDepartamento);
        cstmt.registerOutParameter(2, Types.INTEGER);
        cstmt.execute();
        return cstmt.getInt(2);
    }

    private void comprobarExitencia() {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet procedures = metaData.getProcedures(null, null, "pr_ObtenerCodigoDepartamento");
            if (!procedures.next()) {
                String sql = "CREATE PROCEDURE pr_ObtenerCodigoDepartamento " +
                        "@nome_departamento VARCHAR(25), " +
                        "@num_departamento INT OUTPUT " +
                        "AS " +
                        "BEGIN " +
                        "    SELECT @num_departamento = Num_Departamento " +
                        "    FROM DEPARTAMENTO " +
                        "    WHERE Nome_Departamento = @nome_departamento " +
                        "END";
                Statement stmt = conexion.createStatement();
                stmt.executeUpdate(sql);
                conexion.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void visualizarDatosDepartamento(int codDepartamento) throws SQLException {
        String sql = "SELECT * FROM DEPARTAMENTO WHERE Num_Departamento = ?";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setInt(1, codDepartamento);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("Departamento: " + rs.getString("Nome_Departamento"));
        }
    }

    private List<JsonObject> visualizarDatosEmpleados(int codDepartamentoAEliminar, int codDepartamentoReasignar) throws SQLException {
        List<JsonObject> empleadosReasignados = new ArrayList<>();
        String sql = "SELECT * FROM EMPREGADO WHERE Num_departamento_pertenece = ?";
        PreparedStatement pstmt = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setInt(1, codDepartamentoAEliminar);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            JsonObject empleadoJson = new JsonObject();
            empleadoJson.addProperty("NSS", rs.getString("NSS"));
            empleadoJson.addProperty("Nombre", rs.getString("Nome"));
            empleadoJson.addProperty("Apelido1", rs.getString("Apelido_1"));
            empleadoJson.addProperty("Apelido2", rs.getString("Apelido_2"));
            empleadoJson.addProperty("NuevoDepartamento", codDepartamentoReasignar);
            empleadosReasignados.add(empleadoJson);

            imprimirElEmpleadoporPantalla(rs);
            rs.updateInt("Num_departamento_pertenece", codDepartamentoReasignar);
            rs.updateRow();
        }
        return empleadosReasignados;
    }

    private void imprimirElEmpleadoporPantalla(ResultSet rs) {
        try {
            System.out.println("Empleado: " + rs.getString("Nome") + " " + rs.getString("Apelido_1") + " " + rs.getString("Apelido_2"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<JsonObject> visualizarDatosProyectos(int codDepartamentoAEliminar, int codDepartamentoReasignar) throws SQLException {
        List<JsonObject> proyectosReasignados = new ArrayList<>();
        String sql = "SELECT * FROM PROXECTO WHERE Num_Departamento = ?";
        PreparedStatement pstmt = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pstmt.setInt(1, codDepartamentoAEliminar);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            JsonObject proyectoJson = new JsonObject();
            proyectoJson.addProperty("Num_proxecto", rs.getInt("Num_proxecto"));
            proyectoJson.addProperty("Nombre", rs.getString("Nome_Prxecto"));
            proyectoJson.addProperty("NuevoDepartamentoControla", codDepartamentoReasignar);
            proyectosReasignados.add(proyectoJson);
            
            imprimirElProyectoporPantalla(rs);

            rs.updateInt("Num_Departamento", codDepartamentoReasignar);
            rs.updateRow();
        }
        return proyectosReasignados;
    }

    private void imprimirElProyectoporPantalla(ResultSet rs) {
        try {
            System.out.println("Proyecto: " + rs.getString("Nome_Prxecto"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarDepartamento(int codDepartamentoAEliminar, int codDepartamentoReasignar) throws SQLException {
        String sql = "DELETE FROM DEPARTAMENTO WHERE Num_Departamento = ?";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setInt(1, codDepartamentoAEliminar);
        pstmt.executeUpdate();
    }

    private void generarArchivoJson(List<JsonObject> empleadosReasignados, List<JsonObject> proyectosReasignados, int codDepartamentoAEliminar, String nombreDepartamentoAEliminar, String jsonFile) throws IOException {
        JsonObject jsonObject = new JsonObject();
        JsonArray empleadosArray = new JsonArray();

        empleadosReasignados.forEach(empleadosArray::add);
        jsonObject.add("EmpleadosReasignados", empleadosArray);
        for (JsonElement jsonElement : empleadosArray) {

        }

        JsonArray proyectosArray = new JsonArray();
        proyectosReasignados.forEach(proyectosArray::add);
        jsonObject.add("ProyectosReasignados", proyectosArray);

        JsonObject departamentoEliminado = new JsonObject();
        departamentoEliminado.addProperty("Num_departamento", codDepartamentoAEliminar);
        departamentoEliminado.addProperty("Nombre", nombreDepartamentoAEliminar);
        jsonObject.add("DepartamentoEliminado", departamentoEliminado);

        try (FileWriter writer = new FileWriter(jsonFile)) {
            Gson gson = new Gson();
            gson.toJson(jsonObject, writer);
        }
    }

    public void crearTablasFamiliares() {
    try {
        Statement statement = conexion.createStatement();
        String sql = "CREATE TABLE FAMILIAR" +
                "(" +
                "    NSS_empregado VARCHAR(15) NOT NULL," +
                "    Numero SMALLINT NOT NULL," +
                "    NSS VARCHAR(15) NOT NULL," +
                "    Nome VARCHAR(25) NOT NULL," +
                "    Apelido1 VARCHAR(25) NOT NULL," +
                "    Apelido2 VARCHAR(25)," +
                "    DataNacemento DATE," +
                "    Parentesco VARCHAR(20) NOT NULL," +
                "    Sexo CHAR(1) DEFAULT 'M' CHECK (Sexo IN ('H', 'M'))," +
                "    CONSTRAINT PK_FAMILIAR PRIMARY KEY (NSS_empregado, NSS)," +
                "    CONSTRAINT CK_FAMILIAR_SEXO CHECK (Sexo IN ('H', 'M'))," +
                "    CONSTRAINT FK_FAMILIAR_EMPREGADO FOREIGN KEY (NSS_empregado) REFERENCES EMPREGADO(NSS)"+
                ")";
        statement.addBatch(sql);

        statement.executeBatch();
        conexion.commit();
        System.out.println("Táboa FAMILIAR creada exitosamente con el trigger.");
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

    public void createTriggerFamiliar() {
        String triggerSql = "CREATE TRIGGER trg_CalculateNumero " +
                "ON FAMILIAR " +
                "INSTEAD OF INSERT " +
                "AS " +
                "BEGIN " +
                "    DECLARE @NSS_empregado VARCHAR(15), @Numero SMALLINT, @NSS VARCHAR(15), @Nome VARCHAR(25), @Apelido1 VARCHAR(25), @Apelido2 VARCHAR(25), @DataNacemento DATE, @Parentesco VARCHAR(20), @Sexo CHAR(1); " +
                "    SELECT @NSS_empregado = NSS_empregado, @NSS = NSS, @Nome = Nome, @Apelido1 = Apelido1, @Apelido2 = Apelido2, @DataNacemento = DataNacemento, @Parentesco = Parentesco, @Sexo = Sexo " +
                "    FROM inserted; " +
                "    SELECT @Numero = ISNULL(MAX(Numero), 0) + 1 " +
                "    FROM FAMILIAR " +
                "    WHERE NSS_empregado = @NSS_empregado; " +
                "    INSERT INTO FAMILIAR (NSS_empregado, Numero, NSS, Nome, Apelido1, Apelido2, DataNacemento, Parentesco, Sexo) " +
                "    VALUES (@NSS_empregado, @Numero, @NSS, @Nome, @Apelido1, @Apelido2, @DataNacemento, @Parentesco, @Sexo); " +
                "END;";
        try {
            Statement statement = conexion.createStatement();
            statement.executeUpdate(triggerSql);
            conexion.commit();
            System.out.println("Trigger creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anhadirFamiliar(String nssEmpregado, String nss, String nombre, String apelido1, String apelido2, LocalDate fechaNacimineto, String parentesco, char sexo) {
        try {
            String sql = "INSERT INTO FAMILIAR (NSS_empregado, NSS, Nome, Apelido1, Apelido2, DataNacemento, Parentesco, Sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nssEmpregado);
            preparedStatement.setString(2, nss);
            preparedStatement.setString(3, nombre);
            preparedStatement.setString(4, apelido1);
            preparedStatement.setString(5, apelido2);
            preparedStatement.setDate(6, Date.valueOf(fechaNacimineto));
            preparedStatement.setString(7, parentesco);
            preparedStatement.setString(8, String.valueOf(sexo));
            preparedStatement.executeUpdate();
            conexion.commit();
            System.out.println("Familiar añadido exitosamente.");
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
