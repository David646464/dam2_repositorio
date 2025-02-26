/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresahb2_feb25;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import POJOS.Empregado;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class EMPRESAHB2_FEB25 {

    /**
     * @param args the command line arguments
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        if (sesion != null) {
            System.out.println("Conexión realizada con éxito");
            List<Empregado> lista = sesion.createQuery("from Empregado").list();
            for (Empregado empregado : lista) {
                System.out.println(empregado.getNome());
            }

            sesion.close();
        } else {
            System.out.println("ERROR");
        }

        System.exit(0);
    }
}
