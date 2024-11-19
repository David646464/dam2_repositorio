package psp.Apuestas;

import java.util.ArrayList;

public class Porra {
    private int golesEquipo1;
    private int golesEquipo2;
    private ArrayList<Empleado> empleados;
    private double dineroApostado;
    private double dineroARepartir;


    public Porra() {
        this.empleados = new ArrayList<>();
    }

    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    private void generarResultado() {
        this.golesEquipo1 = (int) (Math.random() * Empleado.MAXGOLES);
        this.golesEquipo2 = (int) (Math.random() * Empleado.MAXGOLES);
    }

    public void ganadores() throws InterruptedException {
        for (Empleado empleado : empleados) {
            empleado.join();
        }
        generarResultado();
        for (Empleado empleado : empleados) {
            for (Apuesta apuesta : empleado.getApuestas()) {
                if (apuesta.getGolesEquipo1() != golesEquipo1 || apuesta.getGolesEquipo2() != golesEquipo2) {
                    dineroARepartir += apuesta.getDineroApostado();
                }else {
                    dineroApostado += apuesta.getDineroApostado();
                }
            }
        }

        for (Empleado empleado : empleados) {
            for (Apuesta apuesta : empleado.getApuestas()) {
                if (apuesta.getGolesEquipo1() == golesEquipo1 && apuesta.getGolesEquipo2() == golesEquipo2) {
                    //Dinero proporcinal que se lleva cada uno en proporcion a lo ue pago

                    double ganancia = dineroARepartir / dineroApostado * apuesta.getDineroApostado();
                    System.out.println(empleado.getNombre() + " ha ganado " + ganancia + " euros");
                }
            }
        }
    }
}