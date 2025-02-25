package empresahba1anot;

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
        Session s = iniciarSesion();
        Transaction tx;

        Empregado empleado = (Empregado) session.get(Empregado.class, nss);

        if(empleado != null){
            familiar.setNumero(empleado.getFamiliares().size() + 1);
            empleado.getFamiliares().add(familiar);

            try{
                tx = s.beginTransaction();
                tx.commit();
                System.out.println("Familiar insertado correctamento");
            } catch (Exception e) {
                System.out.println("ERRRROOOOORRRRr");
                throw new RuntimeException(e);
            }
        }
    }
}
