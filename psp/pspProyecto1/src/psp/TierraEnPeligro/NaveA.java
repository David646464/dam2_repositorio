package psp.TierraEnPeligro;

import java.util.Random;

public class NaveA extends Thread{
    private int id;
    private Espacio espacio;

    public NaveA(int id, Espacio espacio) {
        this.id = id;
        this.espacio = espacio;
    }

    public NaveA getNaveA() {
        return this;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void run() {
        try {

            while (espacio.getMeteoritos().size() != 0) {
                Thread.sleep((long)(Math.random()*1000));
                espacio.taladrarMeteorito(this);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
