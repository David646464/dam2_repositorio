/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresahba1xml;

import Pojos.Departamento;
import Pojos.Empregado;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class Operaciones {
    
    public static void insertarEmpregado(Empregado emp){
        Session sesion = iniciarSesion();
        Transaction tx = null;
        
        try{
            tx = sesion.beginTransaction();
            sesion.save(emp);
            tx.commit();
        }catch(HibernateException e){
            System.out.println("ERROR");
        }
    }

    public static Session iniciarSesion() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        if(sesion != null){
            System.out.println("Conecxion realizada con exito");
            
        }else{
            System.out.println("ERROR");
        }
        
        return sesion;
    }
    
    public static void insertarDepartamento(Departamento dpt){
        Session sesion = iniciarSesion();
        Transaction tx = null;
        
        try{
            tx = sesion.beginTransaction();
            sesion.save(dpt);
            tx.commit();
            System.out.println("Departamento insertado");
        }catch(HibernateException e){
            System.out.println("ERROR");
        }
    }
    
    public static void loadDepartamento(int numdepartamento){
        
        Session sesion = iniciarSesion();
        try{
            Departamento departamento = (Departamento) sesion.load(Departamento.class, numdepartamento);
            System.out.println("Numero de departamento: " + departamento.getNumDepartamento());
            System.out.println("Nombre de departamento: " + departamento.getNomeDepartamento());
        }catch (Exception e){
            System.out.println("ERROR");
        }  
    }
    
    public static void getEmpleado(String nssEmpregado){
        
        Session sesion = iniciarSesion();
        try{
            Empregado empregado = (Empregado) sesion.get(Empregado.class, nssEmpregado);
            System.out.println("NSS empregado: " + empregado.getNss());
            System.out.println("Nombre empregado:" + empregado.getNome());
        }catch (Exception e){
            System.out.println("ERROR");
        }  
    }
    
    public static void eliminarEmpleado(String nssEmpregado){
        Session session = iniciarSesion();
        Transaction tx = null;
        
        try{
            Empregado empregado = (Empregado) session.get(Empregado.class, nssEmpregado);
            tx = session.beginTransaction();
            session.save(empregado);
            session.delete(empregado);
            tx.commit();
        }catch (Exception e){
            
        }
    }
    
    /*public static void insertarTelefonoEmpleado(String nss, HashSet<String> telefonos){
        Session sesion = iniciarSesion();
        Transaction tx = sesion.beginTransaction();
        
        try {
            Empregado e = (Empregado) sesion.get(Empregado.class, nss);
            System.out.println("empregado "+e.toString());
            e.setTelefonos(telefonos);
            System.out.println(e);
            tx.commit();
        } catch (HibernateException e){
            System.out.println("ERROR"+e.getMessage());
            tx.rollback();
        }
        
        sesion.close();
    }*/
    
    public static Empregado getEmpregado(String nss){
        Session s = iniciarSesion();
        
        Empregado e = (Empregado) s.get(Empregado.class, nss);
        s.close();
        
        return e;
                
    }
    
    /*public static void borrarTelefonoEmpleado(String nss, String telefono){
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
    }*/
    
    public static void borrarEmpleado(String nss){
        Session sesion = iniciarSesion();
        Transaction tx = sesion.beginTransaction();
        
        try {
            Empregado e = (Empregado) sesion.get(Empregado.class, nss);
            System.out.println("empregado "+e.toString());
            sesion.delete(e);
            System.out.println("empregado "+e.toString());
            tx.commit();
            System.out.println("Telefonos asociados al empleado con nss " + nss + " borrados");
        } catch (HibernateException e){
            System.out.println("ERROR"+e.getMessage());
            tx.rollback();
        }
        
        sesion.close();
    }
}
