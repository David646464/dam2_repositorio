package empresahba1xml;

import Pojos.Departamento;
import Pojos.Empregado;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Operaciones6 {
    public static Session iniciarSesion() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        if(sesion != null){
            System.out.println("Conecxion realizada con exito");

        }else{
            System.out.println("ERROR");
        }

        return sesion;
    }

    public static void addLugar(int numDEpartamento, String lugar){
        Session sesion = iniciarSesion();
        Transaction tx = sesion.beginTransaction();
        Departamento d = (Departamento) sesion.get(Departamento.class, numDEpartamento);

        if(d != null){
            d.getLugares().add(lugar);
            try {
                tx.commit();
                System.out.println("lugar Agregado");
            } catch (HibernateException error){
                System.out.println("ERROR"+error.getMessage());
                tx.rollback();
            }
        }
        sesion.close();
    }
}
