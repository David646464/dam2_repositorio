package psp.ej4;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        final int INT = 60;
        final int NUM_PLAZAS = 10;
        Aparcamiento aparcamiento = new Aparcamiento(NUM_PLAZAS);
        ArrayList<Conductor> conductores = new ArrayList<>();
        for (int i = 0; i < INT; i++) {
            Conductor conductor = new Conductor(String.valueOf(i), aparcamiento);
            conductores.add(conductor);
            conductor.start();
        }

        for (Conductor conductor : conductores) {
            try {
                conductor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
