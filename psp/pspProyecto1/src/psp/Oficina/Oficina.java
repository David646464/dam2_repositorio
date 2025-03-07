package psp.Oficina;

import java.sql.SQLOutput;

public class Oficina {
    private boolean trabajando = false;
    private Empleado[] empleados;
    private Jefe jefe;

    public Oficina(int numEmpleados) {
        empleados = new Empleado[numEmpleados];
        for (int i = 0; i < numEmpleados; i++) {
            empleados[i] = new Empleado("Empleado " + i, this);
        }
        jefe = new Jefe("Jefe", this);
    }


    public void trabajar(Jefe jefe) {
        System.out.println(jefe.getNombre() + " EL JEFE HA LLEGADO!");
        jefe.setTrabajando(true);
        trabajando = true;
        synchronized (this) {
            notifyAll();
        }
    }


    public void abrir() {
        for (Empleado empleado : empleados) {
            empleado.start();
        }
        jefe.start();
    }

    public static void main(String[] args) {
        Oficina oficina = new Oficina(5);
        oficina.abrir();
    }

    public synchronized void trabajar(Empleado empleado) throws InterruptedException {
        if (trabajando) {
            System.out.println(empleado.getNombre() + " Hola jefe!, me pongo a trabajar");
            empleado.setTrabajando(true);
        } else {
            System.out.println(empleado.getNombre() + " ZZZz");
            empleado.setTrabajando(false);
            wait();
            System.out.println(empleado.getNombre() + " buenos días jefe, aquí estoy trabajando");
        }

    }
}
