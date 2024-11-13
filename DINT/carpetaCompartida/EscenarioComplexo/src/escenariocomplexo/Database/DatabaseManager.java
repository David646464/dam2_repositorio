/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escenariocomplexo.Database;

import escenariocomplexo.Objects.Can;
import escenariocomplexo.Objects.Vacinacion;
import escenariocomplexo.Objects.Raza;
import escenariocomplexo.Objects.Propietario;
import escenariocomplexo.Objects.Vacina;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class DatabaseManager {

    private static String user;
    private static String passWord;
    private static final String databaseName = "clinica";
    private static Connection connection;
    private static int numError = 0;

    public static String getUser() {
        return user;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        return null;
    }

    public static int getNumError() {
        return numError;
    }

    private DatabaseManager(String user, String passWord, String ip, String port) {
        this.user = user;
        this.passWord = passWord;
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + databaseName;
        
        try {
            Connection connection2 = DriverManager.getConnection(url, user, passWord);
            System.out.println("Conexión exitosa a la base de datos.");
            this.connection = connection2;
            numError = 0;
        } catch (SQLException e) {
            String sqlState = e.getSQLState();
            if (sqlState != null) {
                switch (sqlState) {
                    case "28000":  // SQLState para error de autenticación (usuario/contraseña) en algunos DBMS
                        numError = 1;
                        break;
                    case "08001":  // SQLState para error de conexión de red (host o puerto incorrecto) en algunos DBMS
                    case "08006":  // Otro posible código para problemas de conexión
                        numError = 2;
                        break;
                    default:
                        numError = 3;
                        break;
                }
            } else {
                System.out.println("Error de SQL sin código de estado específico: " + e.getMessage());
            }
        }
    }

    public static Connection getInstance(String user, String passWord, String ip, String port) {
        if (connection == null) {
            new DatabaseManager(user, passWord, ip, port);
        }

        if (connection == null) {
            return null;
        }
        return connection;
    }

    public static Connection getInstance() {
        return connection;
    }

    public static ArrayList<Raza> recuperarTodalasRazas() {
        try {
            ArrayList resultado = new ArrayList();
            System.out.print(connection.isClosed());
            Statement stmt = connection.createStatement();
            String consulta = "select codRaza, descripcion from razas order by descripcion";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Raza c = new Raza(rs.getInt(1), rs.getString(2));
                resultado.add(c);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Insertar raza
    public static int insertarRaza(Raza c) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "insert into razas (descripcion) VALUES ('" + c.getDescripcion() + "')";
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    

    // Recuperar a ultima dose aplicada dunha vacuna a un can
    public static int recuperarUltimaDoseDunhaVacinaParaOCan(String chip, int codVacina) {
        try {
            int resultado = 0;
            Statement stmt = connection.createStatement();
            String consulta = "select max(dose)from vacinacions where chip='" + chip + "' and codVacina=" + codVacina;
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getInt(1);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Recuperar todas las vacunas
    public static ArrayList recuperarTodalasVacinas() {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select codVacina, nomeVacina, numTotalDoses from vacinas order by nomeVacina";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Vacina c = new Vacina(rs.getInt(1), rs.getString(2), rs.getInt(3));
                resultado.add(c);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Recuperar todos los propietarios
    public static ArrayList recuperarTodolosPropietarios() {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select dni, nome, ap1, ap2, tlf, email from propietarios order by nome";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Propietario c = new Propietario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                resultado.add(c);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Inserir perro
    public static int inserirCan(Can c) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "insert into cans (chip, nome, codRaza, dniPropietario) VALUES ('" + c.getChip() + "','" + c.getNombre() + "'," + c.getCodRaza() + ",'" + c.getDniPropietario() + "')";
            System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    //Insertar propietario
    public static int insertarPropietario(Propietario c) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "insert into propietarios (dni, nome, ap1, ap2, tlf, email) VALUES ('" + c.getDni() + "','" + c.getNome() + "','" + c.getAp1() + "','" + c.getAp2() + "','" + c.getTlf() + "','" + c.geteMail() + "')";
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    //Recuperar todos los perros de un propietario
    public static ArrayList recuperarTodolosCansDunPropietario(String dniPropietario) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select chip, nome, codRaza from cans where dniPropietario='" + dniPropietario + "' order by nome";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Can c = new Can(rs.getString(1), rs.getString(2), rs.getInt(3), dniPropietario);
                resultado.add(c);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Recuperar todas las vacunaciones de un perro
    public static ArrayList recuperarTodalasVacinacionsDunCan(String chip) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select codVacinacion, codVacina, data, observacions, dose from vacinacions where chip='" + chip + "' order by codVacinacion";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Vacinacion c = new Vacinacion(rs.getInt(1), chip, rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                resultado.add(c);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Recuperar una vacuna dado su codigo
    public static ArrayList recuperarUnhaVacinaDadoSeuCodigo(int codVacuna) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select nomeVacina, numTotalDoses from vacinas where codVacina=" + codVacuna;
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Vacina c = new Vacina(codVacuna, rs.getString(1), rs.getInt(2));
                resultado.add(c);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Comprobar si un DNI existe
    public static int existeDNI(String DNI) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "select dni from propietarios where dni='" + DNI + "'";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //Comprobar si un chip existe
    public static int existeChip(String chip) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "select chip from cans where chip='" + chip + "'";
            System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //Eliminar una vacunacion dado su codigo
    public static int eliminarUnhaVacinacionDadoSeuCodigo(int codVacinacion) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "delete from vacinacions where codVacinacion=" + codVacinacion;
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static int inserirVacinacion(Vacinacion c) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "insert into vacinacions (chip, codVacina, data, observacions, dose) values ('" + c.getChip() + "'," + c.getCodVacina() + ",'" + c.getData() + "','" + c.getObservacions() + "'," + c.getDose() + ")";
            System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    //Comprobar si existe una vacinacion de dose superior para un can
    public static int existeVacinacionDeDoseSuperior(int codVacina, int dose, String chip) {
        try {
            int resultado = 0;
            Statement stmt = connection.createStatement();
            String consulta = "select count(*) from vacinacions where codVacina=" + codVacina + " and dose>" + dose + " and chip='" + chip + "'";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getInt(1);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
