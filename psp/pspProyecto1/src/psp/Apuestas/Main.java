package psp.Apuestas;

public class Main {
    public static void main(String[] args) {
        int numEmpleados = 5;
        Porra porra = new Porra();
        for (int i = 0; i < numEmpleados; i++) {
            Empleado empleado = new Empleado("Empleado " + i, porra);
            porra.addEmpleado(empleado);
            empleado.start();
            porra.start();
        }
    }
}
