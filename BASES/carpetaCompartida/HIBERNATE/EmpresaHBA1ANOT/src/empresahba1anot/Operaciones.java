/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresahba1anot;

import Pojos.Departamento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Pojos.Empregado;

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
            System.out.println("Empledo insertado correctamente");
        }catch(HibernateException e){
            rollback();
            System.out.println("ERROR");
        }
    }

    private static Session iniciarSesion() {
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

    private static void rollback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
