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

import java.lang.reflect.Type;
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


    public static void imprimirTodosLosEmpleadosConConsultas() {
        Session sesion = openSession();
        List<Empregado> empleados = sesion.createQuery("from Empregado").list();
        for (Empregado empregado : empleados) {
            System.out.println(empregado.toString());
        }
        sesion.close();
    }

    public static void imprimirTodosLosEmpleadosPorLocalidad(String localidad) {
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
            System.out.print("Proxectos:");
            System.out.println(empregado.getEmpregadoProxectos().size());
            for (EmpregadoProxecto proxecto : empregado.getEmpregadoProxectos()) {
                System.out.println(proxecto.getProxecto().getNomeProxecto());
            }

        }
        sesion.close();


    }

    private static void imprimirEmpleados() {
        //a
        Session sesion = openSession();
        Query q = sesion.createQuery("from Empregado e order by e.apelido1, e.apelido2, e.nome");
        List<Empregado> empleados = q.list();
        System.out.printf("%-15s %-30s %-30s %-20s %-15s%n", "NSS", "Nome Completo", "Departamento", "Tipo empleado", "num. de telefonos");
        for (Empregado empregado : empleados) {
            String tipoEmpleado = (empregado instanceof Empregadofixo) ? "Fixo" : "Temporal";
            System.out.printf("%-15s %-30s %-30s %-20s %-15d%n",
                    empregado.getNss(),
                    empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2(),
                    empregado.getDepartamento().getNomeDepartamento(),
                    tipoEmpleado,
                    empregado.getTelefonos().size());
        }
        sesion.close();
    }

    private static void imprimirEmpleadosSegunTipoEmpregadoJaimitada(String tipo) {
        Session sesion = openSession();
        Integer tipoEmpleadoNum = 0;
       switch (tipo) {
            case "Temporal":
                tipoEmpleadoNum = 2;
                break;
            case "Fixo":
                tipoEmpleadoNum = 1;
                break;
            default:
                System.out.println("Tipo de empleado no válido");
        }

        Query q = sesion.createQuery("from Empregado e where e.class = :tipo order by e.apelido1, e.apelido2, e.nome");
        q.setParameter("tipo",tipoEmpleadoNum);
        List<Empregado> empleados = q.list();
        System.out.printf("%-15s %-30s %-30s %-20s %-15s%n", "NSS", "Nome Completo", "Departamento", "Tipo empleado", "num. de telefonos");
        for (Empregado empregado : empleados) {
            String tipoEmpleado = (empregado instanceof Empregadofixo) ? "Fixo" : "Temporal";
            System.out.printf("%-15s %-30s %-30s %-20s %-15d%n",
                    empregado.getNss(),
                    empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2(),
                    empregado.getDepartamento().getNomeDepartamento(),
                    tipoEmpleado,
                    empregado.getTelefonos().size());
        }
        sesion.close();
    }

    private static void imprimirEmpleadosSegunTipoEmpregado(Type tipo) {
        Session sesion = openSession();


        Query q = sesion.createQuery("from Empregado e where type(e) = :tipo order by e.apelido1, e.apelido2, e.nome");
        q.setParameter("tipo", tipo);
        List<Empregado> empleados = q.list();
        System.out.printf("%-15s %-30s %-30s %-20s %-15s%n", "NSS", "Nome Completo", "Departamento", "Tipo empleado", "num. de telefonos");
        for (Empregado empregado : empleados) {
            String tipoEmpleado = (empregado instanceof Empregadofixo) ? "Fixo" : "Temporal";
            System.out.printf("%-15s %-30s %-30s %-20s %-15d%n",
                    empregado.getNss(),
                    empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2(),
                    empregado.getDepartamento().getNomeDepartamento(),
                    tipoEmpleado,
                    empregado.getTelefonos().size());
        }
        sesion.close();
    }

    public static void imprimirEmpedadosFijosQueGananMas(double salario){
        Session sesion = openSession();
        Query q = sesion.createQuery("from Empregadofixo e where e.salario > :salario order by e.salario desc");
        q.setParameter("salario", salario);
        List<Empregadofixo> empleados = q.list();
        System.out.printf("%-15s %-30s %-30s %-20s %-15s%n", "NSS", "Nome Completo", "Departamento", "Tipo empleado", "num. de telefonos");
        for (Empregadofixo empregado : empleados) {
            System.out.printf("%-15s %-30s %-30s %-20s %-15d%n",
                    empregado.getNss(),
                    empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2(),
                    empregado.getDepartamento().getNomeDepartamento(),
                    "Fixo",
                    empregado.getTelefonos().size());
        }
        sesion.close();

    }
   public static void imprimirEmpleadosFijosQueGananMasQueElSupervisorQueMasGana() {
    Session sesion = openSession();
    Query q = sesion.createQuery("from Empregadofixo e " +
            "where e.salario > " +
            "(select max(ef.salario) from Departamento d join d.director ef)");
    List<Empregadofixo> empleados = q.list();
    System.out.printf("%-15s %-30s %-30s %-20s %-15s%n", "NSS", "Nome Completo", "Departamento", "Tipo empleado", "num. de telefonos");
    for (Empregadofixo empregado : empleados) {
        System.out.printf("%-15s %-30s %-30s %-20s %-15d%n",
                empregado.getNss(),
                empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2(),
                empregado.getDepartamento().getNomeDepartamento(),
                "Fixo",
                empregado.getTelefonos().size());
    }
    sesion.close();
}
/*c)Relizar un metodo que se le pase un límite inferior y otro superior y liste los empleados varones que su
sueldo esté comprendido entre estos los dos límites y son supervisores.
*/

    public static void imprimirEmpleadosVaronesSupervisoresConSalarioEntre(double salarioInferior, double salarioSuperior) {
        Session sesion = openSession();
        Query q = sesion.createQuery("from Empregado e " +
                "where e.sexo = 'H' and e.nss in (select es.supervisor.nss from Empregado es) and e.salario between :salarioInferior and :salarioSuperior");
        q.setParameter("salarioInferior", salarioInferior);
        q.setParameter("salarioSuperior", salarioSuperior);
        List<Empregado> empleados = q.list();
        System.out.printf("%-15s %-30s %-30s %-20s %-15s%n", "NSS", "Nome Completo", "Departamento", "Tipo empleado", "num. de telefonos");
        for (Empregado empregado : empleados) {
            String tipoEmpleado = (empregado instanceof Empregadofixo) ? "Fixo" : "Temporal";
            System.out.printf("%-15s %-30s %-30s %-20s %-15d%n",
                    empregado.getNss(),
                    empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2(),
                    empregado.getDepartamento().getNomeDepartamento(),
                    tipoEmpleado,
                    empregado.getTelefonos().size());
        }
        sesion.close();
    }
    /*d)Realizar un metodo que dado un porcentaje, suba el sueldo en esa cantidad a los empleados que tengan
asignados el mayor número de proyectos. Con consulta HQL*/

   public static void subirSueldoEmpleadosConMasProyectos(double porcentaje) {
    Session sesion = openSession();
    Transaction tx = null;
    try {
        tx = sesion.beginTransaction();

        // First, find the maximum number of projects assigned to any employee
        Query maxProjectsQuery = sesion.createQuery("select count(ep.empregado.nss) from EmpregadoProxecto ep group by ep.empregado.nss order by count(ep.empregado.nss) desc");
        maxProjectsQuery.setMaxResults(1);
        Long maxProjects = (Long) maxProjectsQuery.uniqueResult();

        // Then, update the salaries of employees with that number of projects
        Query updateQuery = sesion.createQuery("update Empregado e set e.salario = e.salario + e.salario * :porcentaje " +
                "where e.nss in (select ep.empregado.nss from EmpregadoProxecto ep group by ep.empregado.nss having count(ep.empregado.nss) = :maxProjects)");
        updateQuery.setParameter("porcentaje", porcentaje / 100);
        updateQuery.setParameter("maxProjects", maxProjects);

        updateQuery.executeUpdate();
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        sesion.close();
    }
}

/*a)Crear un metodo para visualizar para cada profesor, el número de cursos que impartante. En la
consulta HQL solo hay que traerse la información necesaria.
*/

   public static void imprimirNumeroDeCursosImpartidosPorProfesor() {
    Session sesion = openSession();
    Query q = sesion.createQuery("select ef.nss, ef.nome, count(e) from Empregadofixo ef join ef.ediciones e group by ef.nss, ef.nome");
    List<Object[]> result = q.list();
    System.out.printf("%-15s %-15s %-15s%n", "NSS", "Nome", "Num. de cursos");
    for (Object[] row : result) {
        System.out.printf("%-15s %-15s %-15d%n", row[0], row[1], row[2]);
    }
    sesion.close();
}

/*b) Idem del anterior pero ahora los empleados fijos que no impartan ningún curso también deberán
aparecer, como se muestra a continuación:
*/

    public static void imprimirNumeroDeCursosImpartidosPorProfesorConCero() {
        Session sesion = openSession();
        Query q = sesion.createQuery("select ef.nss, ef.nome, count(e) from Empregadofixo ef left join ef.ediciones e group by ef.nss, ef.nome order by count(e) desc");
        List<Object[]> result = q.list();
        System.out.printf("%-15s %-15s %-15s%n", "NSS", "Nome", "Num. de cursos");
        int i = 1;
        for (Object[] row : result) {
            System.out.printf("%-15s %-15s %-15d%n", row[0], row[1], row[2]);
            System.out.println(i);
            i++;
        }
        sesion.close();
    }

    /*c) Crear un método para visualizar el número de cursos que impartante cada empleado fijo. Si el
empleado no ha impartido ningún curso se visualizará ‘ninguno’. También visualizará si el empleado
dirige o no algún departamento. En la consulta HQL se traerá solo la información que se visualiza a
continuación.
( Nota, a parte del NSSEmpleadoFixo, nombre, también hay que traer lo de director o no director y el
numero de cursos o ninguno). Te puede ayudar las siguentes funciones en HQL ( parecidas a SQL)
Ayuda: CAST ( campo AS tipoDatosHibernate) para convetir un tipo de datos en otro.
 CASE WHEN condición then ‘valor1’ ELSE ‘valor2’ END*/

    public static void imprimirNumeroDeCursosImpartidosPorEmpleadoFijo() {
        Session sesion = openSession();
        Query q = sesion.createQuery("select ef.nss, ef.nome," +
                 "case when count(e) = 0 then 'ninguno' else str(count(e)) end, " +
                "case when ef in (select d.director from Departamento d) then 'Sí' else 'No' end " +
                "from Empregadofixo ef left join ef.ediciones e group by ef.nss, ef.nome order by count(e) desc");
        List<Object[]> result = q.list();
        System.out.printf("%-15s %-15s %-15s %-15s%n", "NSS", "Nome", "Num. de cursos", "Director");
        for (Object[] row : result) {
            System.out.printf("%-15s %-15s %-15s %-15s%n", row[0], row[1], row[2], row[3]);
        }
        sesion.close();
    }

    public static void main(String[] args) {
        Operaciones.imprimirNumeroDeCursosImpartidosPorEmpleadoFijo();
    }


}
