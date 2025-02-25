/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresahba1xml;

import Pojos.Departamento;
import Pojos.Empregado;
import Pojos.Familiar;
import Pojos.Telefono;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class EmpresaHBA1XML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Empregado empregado = new Empregado("123G", "Victoria", "Rua");
        //Operaciones.insertarEmpregado(empregado);

        //Departamento departamento = new Departamento("Caiño");
        //Operaciones.insertarDepartamento(departamento);
        //Operaciones.iniciarSesion();
        /*HashSet<Telefono> telefonos = new HashSet<>();
        Telefono telefono = new Telefono("123456785", "Casa");
        Telefono telefono2 = new Telefono("985746228", "Tabajo");
        telefonos.add(telefono);
        telefonos.add(telefono2);
        //Operaciones.insertarTelefonoEmpleado("123G", telefonos);
        Operaciones2.insertarTelefonoEmpleado("12478", telefonos);*/
        /*Map<String, String> telefonos = new HashMap<>();
        telefonos.put("845786589", "Oskar");
        telefonos.put("845786511", "Alfonso");
        Operaciones3.insertarTelefonoEmpleado("12478", telefonos);
        Operaciones3.borrarTelefonoEmpleado("12478","845786511");*/

        /*Session s = Operaciones4.iniciarSesion();
        Transaction tx = s.beginTransaction();

        Operaciones4.addFamiliar(s, "12478", new Familiar("123456", 'M', "PAPITO", new Date(1986, 12, 4), "PASTORIZA", "FERNANDEZ", "OSKI"));
        tx.commit();
        System.out.println("Fmiliar insertar correctamente");*/

        //Operaciones5.addAficcion("12478", "HIPICA");
        Operaciones6.addLugar(1, "MONTEPO");
        System.exit(0);
    }
}
