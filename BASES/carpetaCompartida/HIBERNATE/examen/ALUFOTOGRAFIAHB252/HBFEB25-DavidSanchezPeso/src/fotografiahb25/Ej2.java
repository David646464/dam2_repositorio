//David Sanchez peso 77465294Y

package fotografiahb25;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Fotografo;
import pojos.Material;

import java.io.Serializable;
import java.util.List;

public class Ej2 {
    private static Session openSession() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion;
    }

    public static void borrarMaterial(String numSerie) {
        Transaction tx = null;
        Session sesion = openSession();
        Query q = sesion.createQuery("select  f.nombre, f.apellidos, m.numeroSerie,m.material,m.marca,m.modelo, f.idFotografo from Fotografo f right join f.materiales  m where m.numeroSerie = :numeroSerie");
        q.setParameter("numeroSerie", numSerie);
        q.setMaxResults(1);
        List<Object[]> result = q.list();
        Object[] fotografo = null;
        if (result.size() != 0) {
            fotografo = result.get(0);
        }

        if (fotografo != null) {
            System.out.println(fotografo[0].toString() + " " + fotografo[1]);
            System.out.println("Equipo a eliminar:" + fotografo[2] + " - " + fotografo[3] + " " + fotografo[4] + " " + fotografo[5]);
            Fotografo fotografo1 = (Fotografo) sesion.get(Fotografo.class, (Serializable) fotografo[6]);
            tx = sesion.beginTransaction();
            try {
                for (Material material : fotografo1.getMateriales()) {
                    if (material.getNumeroSerie().equals(numSerie)) {
                        fotografo1.getMateriales().remove(material);
                        System.out.println("Material borrado correctamente");
                        break;
                    }
                }
                tx.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
                tx.rollback();
            }
        } else {
            System.out.println("El equipo con número de serie " + numSerie + "no existe");
        }
        sesion.close();
    }

    public static void main(String[] args) {
        borrarMaterial("TRI-3001");
    }
}
