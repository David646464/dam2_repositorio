package psp.ej3;

import java.util.Random;

public class Votante extends Thread{
    private Votacion votacion ;

    public Votante(Votacion votacion) {
        this.votacion = votacion;
    }

    public Votacion getVotacion() {
        return votacion;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        votacion.getArrayListPartidos().get(new Random().nextInt(5)).incrementarVotos();
    }
}
