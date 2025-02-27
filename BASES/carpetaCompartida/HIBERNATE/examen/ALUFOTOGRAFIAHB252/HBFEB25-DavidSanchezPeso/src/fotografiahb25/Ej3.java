//David Sanchez peso 77465294Y
package fotografiahb25;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Evento;
import pojos.Fotografo;
import pojos.Material;

import java.io.Serializable;
import java.util.List;

public class Ej3 {
    private static Session openSession() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion;
    }

    public static void addFotografoToEvento(String seudonimo, int codEvento) {
        Transaction tx = null;
        Session sesion = openSession();
        Query q = sesion.createQuery("select f.idFotografo from Fotografo f where f.seudonimo = :seudonimo");
        q.setParameter("seudonimo", seudonimo);
        q.setMaxResults(1);

       List<Object[]> result = q.list();
        Object[] fotografo = null;
        if (result.size() != 0) {
            fotografo = result.get(0);
        }
        Integer idFotografo =(Integer) fotografo[0];
        Evento evento = (Evento) sesion.get(Evento.class, codEvento);
        Fotografo fotografo1 = (Fotografo) sesion.get(Fotografo.class, idFotografo);
      try {
            tx = sesion.beginTransaction();
        if (!fotografo1.getEventos().contains(evento)){
            fotografo1.getEventos().add(evento);
        }else{
            System.out.println("Ese evento ya tiene");
        }
        tx.commit();
      }catch (HibernateException e) {
                e.printStackTrace();
                tx.rollback();
            }



    }

    public static void main(String[] args) {
         addFotografoToEvento("Carlios", 12);
    }


}
