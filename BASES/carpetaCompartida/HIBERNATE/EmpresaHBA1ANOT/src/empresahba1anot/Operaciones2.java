package empresahba1anot;

import Pojos.Empregado;
import Pojos.Telefono;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

public class Operaciones2 {
    private static Session iniciarSesion() {
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
            //e.getTelefonos().addAll(telefonos);
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
