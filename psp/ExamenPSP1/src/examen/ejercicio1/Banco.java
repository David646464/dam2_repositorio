package examen.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static Banco instancia;
    private static Integer fondo = 0;
    private Integer dia = 0;
    private boolean finalizoSimulacion = false;

    private static List<Organizacion> organizacions = new ArrayList<>();
    private static List<Politico> politicos = new ArrayList<>();

    public static Banco getInstance() {
        if (instancia == null) {
            instancia = new Banco();
        }
        return instancia;
    }

    public void aportar(int cantidad, Organizacion organizacion) {
        if (politicos.isEmpty()){
            finalizoSimulacion = true;
            System.out.println("Todos los politicos dejan el fondo tranquilo");
        }
        synchronized (fondo) {
            fondo += cantidad;
            System.out.println("La organizacion:" + organizacion.getIdOrganizacion() + " ha depositado " + organizacion.getAPORTACION() + "€ el dia " + getDia());
            dia++;
        }
        synchronized (this){
            this.notifyAll();
        }
    }

    public void sacar(int i, Politico politico) throws InterruptedException {
        boolean saco = false;
        int cantidad = 0;
        while (!saco) {
            synchronized (fondo) {cantidad = fondo;}
                if (cantidad < i) {
                    synchronized (this){
                        wait();
                    }
                } else {
                    synchronized (fondo) {fondo-= i;}
                    saco = true;
                    politico.setRetiradaAnterior(i);
                    System.out.println("El politico:" + politico.getIdPolitico() + " ha retirado " + String.valueOf(i) + "€ el dia " + getDia());
                }
            }


    }

    public boolean isFinalizoSimulacion() {
        return finalizoSimulacion;
    }

    public Integer getDia() {
        if (!organizacions.isEmpty()) {
            return dia / organizacions.size();
        } else {
            return 0;
        }

    }

    public static void IniciarSimulacion(Integer numOrganizaciones, Integer numPoliticos) {
        for (int i = 0; i < numOrganizaciones; i++) {
            Organizacion organizacion = new Organizacion(i);
            organizacions.add(organizacion);
            organizacion.start();

        }
        for (int i = 0; i < numPoliticos; i++) {
            Politico politico = new Politico(i);
            politicos.add(politico);
            politico.start();
        }

    }

    public static List<Politico> getPoliticos() {
        return politicos;
    }
}
