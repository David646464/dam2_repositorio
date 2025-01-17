//David Sánchez peso 77465294Y
package examen.DataBaseManager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import examen.Objects.Alojamiento;
import examen.Objects.CasaRural;
import examen.Objects.Hotel;
import examen.Objects.HotelSpa;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBasemanager {

    private Connection conexion;
    String url = "jdbc:sqlserver://localhost:1433;databaseName=bdalojamientos25;encrypt=true;trustServerCertificate=true";
    String user = "sa";
    String password = "abc123.";


    public DataBasemanager() throws SQLException {
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

    public void insertarAlojamiento(Alojamiento alojamiento) throws SQLException {
        conexion.setAutoCommit(false);
        int codigoError = 0;
        if (existeAlojamiento(alojamiento) == null) {
            try {
                codigoError = 1;
                String sql = "INSERT INTO ALOJAMIENTO (nombre, direccion, localidad, telefono,precio_habitacion,cama_extra,numhabitaciones) VALUES (?, ?, ?, ?,?,?,?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, alojamiento.getNombre());
                preparedStatement.setString(2, alojamiento.getDireccion());
                preparedStatement.setString(3, alojamiento.getLocalidad());
                preparedStatement.setString(4, alojamiento.getTelefono());
                preparedStatement.setDouble(5, alojamiento.getPrecio_habitacion());
                preparedStatement.setDouble(6, alojamiento.getCama_extra());
                preparedStatement.setInt(7, alojamiento.getNomHabitaciones());

                ResultSet generatedKeys;
                synchronized (this) {
                    preparedStatement.executeUpdate();

                    generatedKeys = preparedStatement.getGeneratedKeys();
                }

                if (generatedKeys.next()) {
                    alojamiento.setCodigo(generatedKeys.getInt(1));
                } else if (alojamiento.getCodigo() < 10) {
                    throw new SQLException();
                } else {
                    throw new SQLException();
                }
                if (alojamiento instanceof CasaRural) {
                    codigoError = 2;
                    CasaRural casaRural = (CasaRural) alojamiento;


                    insertarEnHotel(casaRural);


                    conexion.commit();
                } else if (alojamiento instanceof HotelSpa) {
                    codigoError = 3;
                    Hotel hotel = (Hotel) alojamiento;
                    insertarHotel(hotel);
                    codigoError = 4;
                    HotelSpa hotelSpa = (HotelSpa) alojamiento;
                    insertarHotelSpa(hotelSpa);

                    conexion.commit();
                } else if (alojamiento instanceof Hotel) {
                    codigoError = 5;
                    Hotel hotel = (Hotel) alojamiento;
                    insertarHotel(hotel);
                    conexion.commit();
                }
            } catch (Exception e) {
                conexion.rollback();
                switch (codigoError) {
                    case 0 -> {
                        System.out.println("Error al comprobar si existe el alojamiento (" + (alojamiento.getNombre()) + ")");
                    }
                    case 1 -> {
                        System.out.println("Error al insertar el alojamiento (" + (alojamiento.getNombre()) + ")");
                    }
                    case 2 -> {
                        System.out.println("Error al insertar una casa rural (" + (alojamiento.getNombre()) + ")");
                    }
                    case 3 -> {
                        System.out.println("Error al insertar el hotel de un objeto hotelSpa (" + (alojamiento.getNombre()) + ")");
                    }
                    case 4 -> {
                        System.out.println("Error al insertar el hotelspa de un objeto hotelSpa (" + (alojamiento.getNombre()) + ")");
                    }
                    case 5 -> {
                        System.out.println("Error al insertar el hotel de un objeto hotel (" + (alojamiento.getNombre()) + ")");
                    }


                }
            }
        } else {
            System.out.println("Ya existe el alojamiento " + alojamiento.getNombre());
        }
    }

    private void insertarHotel(Hotel hotel) throws SQLException {
        PreparedStatement preparedStatement;
        String sql;
        sql = "INSERT  into HOTEL (cod_hotel, estrellas, hotelsede) VALUES (?,?,?)";
        preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1, hotel.getCodigo());
        preparedStatement.setInt(2, hotel.getEstrellas());
        preparedStatement.setInt(3, hotel.getHotelsede());
        preparedStatement.executeUpdate();
    }

    private void insertarHotelSpa(HotelSpa hotelSpa) throws SQLException {
        PreparedStatement preparedStatement;
        String sql;
        sql = "INSERT  into HOTELSPA(cod_spa, gorro, capacidad) VALUES (?,?,?)";
        preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1, hotelSpa.getCodigo());
        preparedStatement.setString(2, String.valueOf(hotelSpa.getGorro()));
        preparedStatement.setInt(3, hotelSpa.getCapacidad());
        preparedStatement.executeUpdate();
    }

    private void insertarEnHotel(CasaRural casaRural) throws SQLException {
        PreparedStatement preparedStatement;
        String sql;
        sql = "INSERT INTO CASARURAL(cod_casa, alquiler_completa) values (?,?)";
        preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1, casaRural.getCodigo());
        preparedStatement.setString(2, String.valueOf(casaRural.getAlquiler_completa()));
        preparedStatement.executeUpdate();
    }

    private Integer existeAlojamiento(Alojamiento alojamiento) {
        try {
            String sql = "{? = call fn_GetCodigoAlojamiento(?)}";
            CallableStatement cstmt = conexion.prepareCall(sql);
            cstmt.setString(2, alojamiento.getNombre());
            cstmt.registerOutParameter(1, Types.SMALLINT);
            cstmt.execute();
            Integer cod = cstmt.getInt(1);
            if (cod == 0) {
                return null;
            } else {
                return cod;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void crearFuncionNombreExiste() {
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet functions = metaData.getFunctions(null, null, "fn_GetCodigoAlojamiento");
            if (functions.next()) {
                String sqldropFucion = "Drop function fn_GetCodigoAlojamiento";
                Statement stmtdrop = conexion.createStatement();
                stmtdrop.execute(sqldropFucion);
            }
            String sql = "CREATE FUNCTION fn_GetCodigoAlojamiento(@nombre_alojamiento VARCHAR(15)) " + "RETURNS SMALLINT " + "AS " + "BEGIN " + "    DECLARE @numero SMALLINT; " + "    SELECT @numero = codigo " + "    FROM ALOJAMIENTO " + "    WHERE nombre = @nombre_alojamiento; " + "    RETURN @numero; " + "END";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void darDeBajaAlojamiento(String Nombrealojamiento) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seguro que quieres eliminar el alijamiento " + Nombrealojamiento + " . S para confirmar");
        String confirmacion = sc.nextLine();
        if (confirmacion.equals("S")) {
            StringBuilder stringBuilder = new StringBuilder();
            int codigo = 0;
            int tipoAlojamiento = 0;
            String sql = "select ALOJAMIENTO.codigo, " +
                    "       casa     = (select count(*) from CASARURAL where cod_casa = ALOJAMIENTO.codigo)," +
                    "       hotel    = (select count(*) from HOTEL where cod_hotel = ALOJAMIENTO.codigo), " +
                    "       hotelSpa = (select count(*) from HOTELSPA where cod_spa = ALOJAMIENTO.codigo)," +
                    "       ALOJAMIENTO.nombre," +
                    "       sedeHotel = (select nombre from ALOJAMIENTO A where codigo = (select hotelsede from HOTEL where cod_hotel = ALOJAMIENTO.codigo))," +
                    "       alquilerCompleto = (select alquiler_completa from CASARURAL where cod_casa = ALOJAMIENTO.codigo)" +
                    "from ALOJAMIENTO " +
                    "where ALOJAMIENTO.nombre = ?";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, Nombrealojamiento);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("codigo");
                if (rs.getInt("casa") == 1) {
                    tipoAlojamiento = 1;
                } else if (rs.getInt("hotelSpa") == 1) {
                    tipoAlojamiento = 3;
                } else if (rs.getInt("hotel") == 1) {
                    tipoAlojamiento = 2;
                }
            }

            switch (tipoAlojamiento) {
                case 0 -> {
                    System.out.println("No existe ese alojamiento (" + Nombrealojamiento + ")");
                    return;
                }
                case 1 -> {
                    String alquilerCompleto = getAlquielerCompleto(codigo);
                    stringBuilder.append("CASA RURAL:" + Nombrealojamiento + "      Alquiler completo:" + alquilerCompleto);
                }
                case 2 -> {
                    String sede = getSede(codigo);
                    stringBuilder.append("HOTEL:" + Nombrealojamiento + "      SEDE:" + sede);
                }
                case 3 -> {
                    String sede = getSede(codigo);
                    stringBuilder.append("HOTEL SPA:" + Nombrealojamiento + "      SEDE:" + sede);
                }
            }

            stringBuilder.append("\n" + "ACTIVIDADES\n" + getActividades(codigo) + "\n");

            borrarAlojamiento(codigo, tipoAlojamiento);
            System.out.println(stringBuilder.toString());
        }
    }

    private void borrarAlojamiento(int codigo, int tipoAlojamiento) throws SQLException {
        conexion.setAutoCommit(false);
        String sql;
        Statement statement = conexion.createStatement();
        try {
            switch (tipoAlojamiento) {

                case 1 -> {
                    sql = "delete from CASARURAL where cod_casa = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from ALOJAMIENTO_ACTIVIDAD where cod_alojamiento = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from ALOJAMIENTO where codigo = " + codigo;
                    statement.addBatch(sql);
                }
                case 2 -> {
                    sql = "update HOTEL set hotelsede = null where hotelsede = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from HOTEL where cod_hotel = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from ALOJAMIENTO_ACTIVIDAD where cod_alojamiento = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from ALOJAMIENTO where codigo = " + codigo;
                    statement.addBatch(sql);
                }
                case 3 -> {
                    sql = "delete  from HOTELSPA_SERVICIOS where cod_spa = " + codigo;
                    statement.addBatch(sql);

                    sql = "delete from HOTELSPA where cod_spa = " + codigo;
                    statement.addBatch(sql);
                    sql = "update HOTEL set hotelsede = null where hotelsede = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from HOTEL where cod_hotel = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from ALOJAMIENTO_ACTIVIDAD where cod_alojamiento = " + codigo;
                    statement.addBatch(sql);
                    sql = "delete from ALOJAMIENTO where codigo = " + codigo;
                    statement.addBatch(sql);


                }
            }
            statement.executeBatch();
            System.out.println("Se ha borrado correctamente el alojamiento");
            conexion.commit();
        } catch (Exception e) {
            conexion.rollback();
        }
    }

    private String getActividades(int codigo) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();
        String sql = "select  nombre " +
                "from ACTIVIDAD " +
                "where codigo in (select cod_actividad from ALOJAMIENTO_ACTIVIDAD where cod_alojamiento = ?)";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setInt(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        int num = 0;
        while (rs.next()) {
            num++;
            stringBuilder.append(rs.getString("nombre") + " \n");
        }
        stringBuilder.append("===========================\n");
        stringBuilder.append(String.valueOf(num) + " actividades");


        return stringBuilder.toString();
    }

    private String getSede(int codigo) throws SQLException {
        String sql = "select nombre from ALOJAMIENTO where codigo = (select hotelsede from hotel where cod_hotel = ?)";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setInt(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return String.valueOf(rs.getString("nombre"));
        }
        return null;
    }

    private String getAlquielerCompleto(int codigo) throws SQLException {
        String sql = "select alquiler_completa from CASARURAL inner join ALOJAMIENTO on CASARURAL.cod_casa = ALOJAMIENTO.codigo where cod_casa = ?";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setInt(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getString("alquiler_completa");
    }

    public void actualizarPreciosDesdeJson(String file) throws SQLException {
        Statement statement = conexion.createStatement();
        StringBuilder stringBuilder = new StringBuilder();
        double precioAntiguo = 0;
        int codigo = 0;
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
            Type actualizacionesType = new TypeToken<ArrayList<JsonObject>>() {
            }.getType();
            List<JsonObject> actualizaciones = gson.fromJson(jsonObject.get("Actualizaciones"), actualizacionesType);

            for (JsonObject actualizacion : actualizaciones) {
                String nombreAlojamiento = actualizacion.get("nombre").getAsString();
                Double precioNuevo = actualizacion.get("precio_habitacion").getAsDouble();

                String sql = "select * from ALOJAMIENTO where nombre = ?";
                PreparedStatement pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, nombreAlojamiento);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    precioAntiguo = rs.getDouble("precio_habitacion");
                    codigo = rs.getInt("codigo");
                    stringBuilder.append("Codigo:" + String.valueOf(codigo) + " Alojamiento:" + nombreAlojamiento + " Precio antiguo: " + String.valueOf(precioAntiguo) + " Precio nuevo:" + String.valueOf(precioNuevo) + "\n");

                    sql = "Update ALOJAMIENTO set precio_habitacion = " + precioNuevo + " where nombre = '" + nombreAlojamiento + "'";
                    statement.addBatch(sql);
                }else{
                    stringBuilder.append("Error:El alojmiento " + nombreAlojamiento + " no existe en la base de datos\n");
                }

            }
            statement.executeBatch();
            conexion.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }


}
