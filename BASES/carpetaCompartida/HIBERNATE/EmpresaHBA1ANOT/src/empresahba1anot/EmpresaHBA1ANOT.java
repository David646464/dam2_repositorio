/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresahba1anot;

import Pojos.Departamento;
import Pojos.Empregado;
import Pojos.Familiar;
import Pojos.Telefono;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class EmpresaHBA1ANOT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Empregado empregado = new Empregado("12478", "DAVID", "Rua");
        //Operaciones.insertarEmpregado(empregado);
        
        //Departamento departamento = new Departamento("PEPA");
        //Operaciones.insertarDepartamento(departamento);
        
       //Operaciones.loadDepartamento(1);
       //Operaciones.getEmpleado("123G");

        // HashSet<Telefono> telefonos = new HashSet<>();
        // Telefono telefono = new Telefono("578494682", "Chando");
        // Telefono telefono2 = new Telefono("476812395", "RR");
        // telefonos.add(telefono);
        // telefonos.add(telefono2);
        // Operaciones2.insertarTelefonoEmpleado("12478", telefono);
        // System.exit(0);

        /*Map<String, String> telefonos = new HashMap<>();
        telefonos.put("695874123", "Oskar");
        telefonos.put("325687419", "Alfonso");
        Operaciones3.insertarTelefonoEmpleado("12478", telefonos);
        Operaciones3.borrarTelefonoEmpleado("12478","695874123");*/
//        Session s = Operaciones4.iniciarSesion();
//        Transaction tx = s.beginTransaction();
//
//        Operaciones4.addFamiliar(s, "12478", new Familiar("77777777", "VIPO", "PAPITO","Rodriguez",  new Date(1986, 12, 4), "Novio", 'H'));
//        tx.commit();
//        System.out.println("Fmiliar insertar correctamente");

        Operaciones5.addAficcion("12478", "FUTBOL");
        Operaciones6.addLugar(2, "BUEU");
        System.exit(0);
    }
    
}
