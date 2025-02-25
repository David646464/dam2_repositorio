/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresahb2_feb25;

import POJOS.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Operaciones {
    public static void conectarHibernate() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        if (sesion != null) {
            System.out.println("Conexión realizada con éxito");
            sesion.close();
        } else {
            System.out.println("ERROR");
        }
    }

    private static Session openSession() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion;
    }

    public static void NewCurso(String nombreCurso, Integer horas) {
        Curso curso = new Curso();
        curso.setNome(nombreCurso);
        curso.setHoras(horas);
        curso.setEdiciones(new ArrayList<>());
        Session session = openSession();
        session.beginTransaction();
        session.save(curso);
        session.getTransaction().commit();
        session.close();
        System.out.println("Curso agregado exitosamente");
    }

    public static void NewEdicion(int codigoCurso, Date data, String lugar) {
        Edicion edicion = new Edicion();
        edicion.setData(data);
        edicion.setLugar(lugar);
        Session session = openSession();
        session.beginTransaction();
        Curso curso = (Curso) session.get(Curso.class, codigoCurso);




        Empregadofixo empregadofixo = (Empregadofixo) session.get(Empregadofixo.class, "0010010");
        edicion.setId(new EdicionId(curso.getCodigo()));
        edicion.setCurso(curso);
        edicion.setProfessor(empregadofixo);
        curso.getEdiciones().add(edicion);
        session.save(curso);
        session.getTransaction().commit();
        session.close();
        System.out.println("Edicion agregado exitosamente");
    }

    public static void crearEdicionCurso(int codigo, Date fecha, String lugar, String profesor) {
        Session sesion = openSession();
        Transaction tx = null;
        Edicion ed;
        Curso curso = (Curso) sesion.get(Curso.class, codigo);
        if (curso != null) {
            List ediciones = curso.getEdiciones();
            ed = new Edicion(fecha, lugar, new Empregadofixo(profesor));
            ediciones.add(ed);
            ed.setCurso(curso);
            ed.setId(new EdicionId(curso.getCodigo()));
            curso.setEdiciones(ediciones);
            try {
                tx = sesion.beginTransaction();
                sesion.save(curso);
                tx.commit();
                System.out.println("Edición añadida con éxito");
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }


    public static void imprimirTodosLosEmpleadosConConsultas(){
        Session sesion = openSession();
        List<Empregado> empleados = sesion.createQuery("from Empregado").list();
        for (Empregado empregado : empleados) {
            System.out.println(empregado.toString());
        }
        sesion.close();
    }

    public static void imprimirTodosLosEmpleadosPorLocalidad(String localidad){
        Session sesion = openSession();
        Query query = sesion.createQuery("from Empregado e where e.localidade = ?");
        query.setString(0, localidad);
        List<Empregado> empleados = query.list();
        for (Empregado empregado : empleados) {
            System.out.println(empregado.toString());
        }
    }

   public static void imprimirTodaLaInfomacionDeLosEmpleadosConConsultas() {
    Session sesion = openSession();
    Query q = sesion.createQuery("from Empregado e order by e.apelido1, e.apelido2, e.nome");
    List<Empregado> empleados = q.list();
    for (Empregado empregado : empleados) {
        String tipoEmpleado = (empregado instanceof Empregadofixo) ? "Fixo" : "Temporal";
        System.out.println(empregado.toString());
        System.out.println("Tipo de empleado: " + tipoEmpleado);
      //Proxectos
        System.out.println("Proxectos:");
        System.out.println(empregado.getProxectos().size());
        for (Proxecto proxecto : empregado.getProxectos()) {
            System.out.println(proxecto.getNomeProxecto());
        }

    }
    sesion.close();


}

    public static void main(String[] args) {
        Operaciones.imprimirTodaLaInfomacionDeLosEmpleadosConConsultas();
    }


}
