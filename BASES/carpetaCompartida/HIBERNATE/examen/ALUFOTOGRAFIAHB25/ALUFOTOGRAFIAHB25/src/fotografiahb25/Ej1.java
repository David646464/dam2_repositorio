package fotografiahb25;

import org.hibernate.Session;
import pojos.Fotografia;
import pojos.Fotografo;

import java.util.Iterator;
import java.util.List;

public class Ej1 {

    private static Session openSession() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion;
    }

public static void imprimirTodasFotografias() {
        Session sesion = openSession();
        List<Fotografo> fotografos = sesion.createQuery("from Fotografo").list();
        for (Fotografo fotografo : fotografos) {
            Iterator iterator = fotografo.getFotografias().iterator();
            while (iterator.hasNext()){
                Fotografia fotografia = (Fotografia) iterator.next();
                System.out.println(fotografia);
            }
        }
        sesion.close();
    }

    public static void main(String[] args) {
        imprimirTodasFotografias();
    }
}
