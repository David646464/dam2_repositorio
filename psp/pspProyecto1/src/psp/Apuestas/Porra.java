package psp.Apuestas;

import java.util.ArrayList;

public class Porra extends Thread {
    private int golesEquipo1;
    private int golesEquipo2;
    ArrayList<Empleado> empleados;
    private int dineroApostado;

    public Porra() {
        this.empleados = new ArrayList<>();
    }

    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        for (Apuesta apuesta : empleado.getApuestas()) {
            this.dineroApostado += apuesta.getDineroApostado();
        }
    }


    @Override
    public void run() {
        generarResultado();

    }

    private void generarResultado() {
        this.golesEquipo1 = (int) (Math.random() * Empleado.MAXGOLES);
        this.golesEquipo2 = (int) (Math.random() * Empleado.MAXGOLES);
    }

}
