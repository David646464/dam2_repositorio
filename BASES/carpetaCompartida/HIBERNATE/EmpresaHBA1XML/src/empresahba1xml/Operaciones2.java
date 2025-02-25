/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresahba1xml;

import Pojos.Empregado;
import Pojos.Telefono;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class Operaciones2 {
    public static Session iniciarSesion() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        if(sesion != null){
            System.out.println("Conecxion realizada con exito");
            
        }else{
            System.out.println("ERROR");
        }
        
        return sesion;
    }
    
    public static void insertarTelefonoEmpleado(String nss, HashSet<Telefono> telefonos){
        Session sesion = iniciarSesion();
        Transaction tx = sesion.beginTransaction();
        
        try {
            Empregado e = (Empregado) sesion.get(Empregado.class, nss);
            System.out.println("empregado "+e.toString());
            //e.setTelefonos(telefonos);
            System.out.println(e);
            tx.commit();
        } catch (HibernateException e){
            System.out.println("ERROR"+e.getMessage());
            tx.rollback();
        }
        
        sesion.close();
    }
    
    public static void borrarTelefonoEmpleado(String nss, Telefono telefono){
        Session sesion = iniciarSesion();
        Transaction tx = sesion.beginTransaction();

        try {
            Empregado e = (Empregado) sesion.get(Empregado.class, nss);
            System.out.println("empregado "+e.toString());
            e.getTelefonos().remove(telefono);
            tx.commit();
            System.out.println("Telefono borrado");
        } catch (HibernateException e){
            System.out.println("ERROR"+e.getMessage());
            tx.rollback();
        }
        
        sesion.close();
    }
}
