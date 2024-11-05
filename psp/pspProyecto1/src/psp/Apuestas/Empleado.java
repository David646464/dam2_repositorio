package psp.Apuestas;

import java.util.ArrayList;
import java.util.HashMap;

public class Empleado extends Thread {
    private String nombre;
    private ArrayList<Apuesta> apuestas;
    private final int MAX_APUESTAS = 5;
    private final int AUMENTO_APUESTA = 1;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.apuestas = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Apuesta> getApuestas() {
        return this.apuestas;
    }

    private void generateApuestas() {
        for (int i = 0; i < MAX_APUESTAS; i++) {
            int golesEquipo1 = (int) (Math.random() * 5);
            int golesEquipo2 = (int) (Math.random() * 5);
            Apuesta apuesta = new Apuesta(golesEquipo1, golesEquipo2, i + AUMENTO_APUESTA);
            apuestas.add(apuesta);

        }
    }

    @Override
    public void run() {
        generateApuestas();
    }
}
