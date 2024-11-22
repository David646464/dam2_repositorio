package psp.TierraEnPeligro;

public class NaveB extends Thread {
    private int id;
    private Espacio espacio;

    public NaveB(int id, Espacio espacio) {
        this.id = id;
        this.espacio = espacio;
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
                espacio.explotarMeteoritoYSacarNaveA(this);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
