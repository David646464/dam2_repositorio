package psp.concesionario;

public class Vendedor extends Thread {
    private Concesonario concesonario;
    private Integer ID;

    public Vendedor(Concesonario concesonario, Integer ID) {
        this.concesonario = concesonario;
        this.ID = ID;
    }

    @Override
    public void run() {
        while (true) {
            concesonario.vender(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
