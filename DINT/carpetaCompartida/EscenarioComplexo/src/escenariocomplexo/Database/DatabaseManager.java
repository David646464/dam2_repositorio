/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escenariocomplexo.Database;

import escenariocomplexo.Objects.Can;
import escenariocomplexo.Objects.Cita;
import escenariocomplexo.Objects.ListadoPerrucaria;
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

    public static int inserirCitaPerruqueria(Cita cita) {

        try {
            Statement stmt = connection.createStatement();
            String consulta = "INSERT INTO citasperrucaria (chip, data, hora) VALUES ('" + cita.getChip() + "', '" + cita.getData() + "', " + cita.getHora() + ")";
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static int eliminarCitaPorCodigo(Object valueAt) {
        ListadoPerrucaria listadoPerrucaria = (ListadoPerrucaria) valueAt;
        
        try {
            Statement stmt = connection.createStatement();
            String consulta = "delete from citasperrucaria where codCita=" + listadoPerrucaria.getCodCita();
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    
    public static int eliminarPropietario(Object valueAt) {
        Propietario propietario = (Propietario) valueAt;
        try {
            Statement stmt = connection.createStatement();
            String consulta = "delete from propietarios where dni='" + propietario.getDni() + "'";
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
            return 0;
        } catch (SQLException e) {
            return -1;
        }
    }

    public static Vector recuperarTodaAsCitasDePerrucaria() {
       try
        {
            Vector resultado=new Vector();
            Statement stmt = connection.createStatement();
            String consulta= "SELECT citasperrucaria.codCita, propietarios.nome, propietarios.ap1, propietarios.ap2, cans.nome, citasperrucaria.data, "
                    + "citasperrucaria.hora FROM citasperrucaria, cans, propietarios "
                    + "where citasperrucaria.chip=cans.chip and cans.dnipropietario=propietarios.dni "
                    + " order by citasperrucaria.data";
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next())
            {
                ListadoPerrucaria c = new ListadoPerrucaria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                resultado.addElement(c);
            }
            return resultado;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean propietariotenCans(Propietario propietario) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "SELECT COUNT(*) FROM `cans` WHERE dniPropietario = '"+propietario.getDni() +"'";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            rs.next();
            String i = rs.getString(1);
            
            return Integer.valueOf(i) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public static void eliminarCansDunPropietario(Propietario propietario) {
        try {
            Statement stmt = connection.createStatement();
            String consulta = "DELETE FROM `cans` WHERE where dniPropietario = '" + propietario.getDni() +"'";
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarPropietariioDoscans(Propietario propietario) {
        //UPDATE `cans` SET `dniPropietario`='[value-4]' WHERE dniPropietario = 
        
        try {
            Statement stmt = connection.createStatement();
            String consulta = "UPDATE cans SET dniPropietario = 0  where dniPropietario = '" + propietario.getDni() +"'";
            //System.out.println(consulta);
            stmt.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int modoficarPropietario(Propietario c) {
        
        try
        {
            Statement stmt = connection.createStatement();
            String consulta = "UPDATE propietarios SET dni = '" + c.getDni() +  "', nome = '" + c.getNome() + "', ap1 = '" + c.getAp1() + "', ap2 = '" + c.getAp2() + "', tlf = '" + c.getTlf() + "', eMail = '" + c.geteMail() + "' WHERE dni = '" + c.getDni() + "'";
            stmt.executeUpdate(consulta);
            return 0;
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            return -1;
        }
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
    
    
    public static ArrayList recuperarTodolosPropietariosPororden(String orden,boolean tipo) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "";
           if (tipo){
                consulta = "select dni, nome, ap1, ap2, tlf, email from propietarios order by " + orden + " asc" ;
           }else{
                consulta = "select dni, nome, ap1, ap2, tlf, email from propietarios order by " + orden + " desc" ;
           }
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

    //Obtener las citas de una fecha
    public static ArrayList citasPorFecha(String fecha) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select * from citasperrucaria where data='" + fecha + "'";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Cita cita = new Cita(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
                resultado.add(cita);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public static ArrayList<Cita> getCitasEntreFechas(String fechaDesde, String fechaAta) {
        try {
            ArrayList resultado = new ArrayList();
            Statement stmt = connection.createStatement();
            String consulta = "select * from citasperrucaria where data <='" + fechaAta + "' and data >='"+ fechaDesde + "'";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Cita cita = new Cita(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
                resultado.add(cita);
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
     
    }
     
     public static Vector recuperarTodaAsCitasDePerrucariaEntreDuasDatas(String dataInicial, String dataFinal)
    {
        try
        {
            Vector resultado=new Vector();
            Statement stmt = connection.createStatement();
            String consulta= "SELECT citasperrucaria.codCita, propietarios.nome, propietarios.ap1, propietarios.ap2, cans.nome, citasperrucaria.data, "
                    + "citasperrucaria.hora FROM citasperrucaria, cans, propietarios "
                    + "where citasperrucaria.chip=cans.chip and cans.dnipropietario=propietarios.dni "
                    + "and citasperrucaria.data>='"+dataInicial+"' and citasperrucaria.data<='"+dataFinal+"'"
                    + " order by citasperrucaria.data";
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next())
            {
                ListadoPerrucaria c = new ListadoPerrucaria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                resultado.addElement(c);
            }
            return resultado;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }       

}
