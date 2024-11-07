package UD2.EL1A6UD2;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private String cif;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.empleados = new ArrayList<>();
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removeEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }


}
