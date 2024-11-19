package psp.TierraEnPeligro;

public class NaveB extends Thread{
    private int id;
    private Espacio espacio;

    public NaveB(int id, Espacio espacio) {
        this.id = id;
        this.espacio = espacio;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            espacio.explotarMeteoritoYSacarNaveA(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
