package psp.Apuestas;

import java.util.ArrayList;
import java.util.HashMap;

public class Empleado extends Thread {
    private String nombre;
    private ArrayList<Apuesta> apuestas;
    public static final int MAX_APUESTAS = 5;
    public static final int MAXGOLES = 4;
    public static final int AUMENTO_APUESTA = 1;
    private Porra porra;

    public Empleado(String nombre,Porra porra) {
        this.nombre = nombre;
        this.apuestas = new ArrayList<>();
        this.porra = porra;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Apuesta> getApuestas() {
        return this.apuestas;
    }

    private void generateApuestas() {
        for (int i = 0; i < MAX_APUESTAS; i++) {
            int golesEquipo1 = (int) (Math.random() * MAXGOLES);
            int golesEquipo2 = (int) (Math.random() * MAXGOLES);
            Apuesta apuesta = new Apuesta(golesEquipo1, golesEquipo2, i + AUMENTO_APUESTA);
            apuestas.add(apuesta);


        }
    }



    @Override
    public void run() {
        generateApuestas();

    }
}
