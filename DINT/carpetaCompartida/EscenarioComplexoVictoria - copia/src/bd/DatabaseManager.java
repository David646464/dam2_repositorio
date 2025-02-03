/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

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

   

    

    public static int conectar(String ipServidor, String porto, String usuario, String clinica, String contrasinal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

}
