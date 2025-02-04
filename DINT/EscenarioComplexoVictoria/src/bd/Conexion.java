/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM 2 
 */
public class Conexion {
    private static Connection conexion;

    public static int conectar(String url,String porto,String usuario,String bd,String clave){
        
        try 
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadenaConexion="jdbc:mysql://"+url+":"+porto+"/"+bd+"?user="+usuario+"&password="+clave+"&serverTimezone=UTC";
            //System.out.println("Cadena de conexion:"+cadenaConexion);
            conexion=DatabaseManager.getInstance(usuario,clave,url,porto);
            return 0;
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return -2;
        }
    }    
    
    public static Connection getConexion()
    {
        return conexion;
    }
    
}


