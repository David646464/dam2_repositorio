//David Sanchez peso 77465294Y

package fotografiahb25;

import org.hibernate.Session;

public class Ej4 {
      private static Session openSession() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion;
    }
}
