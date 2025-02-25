package empresahba1anot;

import Pojos.Empregado;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Operaciones5 {
    public static Session iniciarSesion() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        if(sesion != null){
            System.out.println("Conecxion realizada con exito");

        }else{
            System.out.println("ERROR");
        }

        return sesion;
    }

    public static void addAficcion(String nss, String aficcion){
        Session sesion = iniciarSesion();
        Transaction tx = sesion.beginTransaction();
        Empregado e = (Empregado) sesion.get(Empregado.class, nss);

        if(e != null){
            e.getAficciones().add(aficcion);
            try {
                tx.commit();
                System.out.println("Aficcion Agregado");
            } catch (HibernateException error){
                System.out.println("ERROR"+error.getMessage());
                tx.rollback();
            }
        }
        sesion.close();
    }
}
