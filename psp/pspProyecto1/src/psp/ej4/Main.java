package psp.ej4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aparcamiento aparcamiento = new Aparcamiento(5);
        ArrayList<Conductor> conductores = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
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
