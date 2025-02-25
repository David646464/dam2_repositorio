package empresahba1xml;

import Pojos.Empregado;
import Pojos.Familiar;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Operaciones4 {
    public static Session iniciarSesion() {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        if(sesion != null){
            System.out.println("Conecxion realizada con exito");

        }else{
            System.out.println("ERROR");
        }

        return sesion;
    }

    public static void addFamiliar(Session session, String nss, Familiar familiar){
        Empregado empleado = (Empregado) session.get(Empregado.class, nss);

        if(empleado != null){
            empleado.getFamiliares().add(familiar);
        }
    }
}
