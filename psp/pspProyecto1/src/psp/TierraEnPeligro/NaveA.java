package psp.TierraEnPeligro;

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
    public void run() {
        try {
            sleep(1000);
            espacio.taladrarMeteorito(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
