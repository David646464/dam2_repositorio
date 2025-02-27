//David Sanchez peso 77465294Y

package fotografiahb25;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Ej1 {

    private static Session openSession() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion;
    }

public static void listarFotografos() {
        Session sesion = openSession();
        Query q = sesion.createQuery("select f.id, f.nombre, f.apellidos, count(fa) from Fotografo f  left join f.fotografias fa group by f.id, f.nombre, f.apellidos order by count(fa) desc ,f.nombre, f.apellidos");
          List<Object[]> result = q.list();
         System.out.printf("%-15s %-30s  %-15s%n", "Codig Fotografo", "Nome Completo", "Num Fotografias");
        for (Object[] row : result) {
              System.out.printf("%-15s %-30s %-15d%n", row[0], row[1].toString() + row[2], row[3]);
        }
        sesion.close();
    }

    public static void main(String[] args) {
        listarFotografos();
    }
}
