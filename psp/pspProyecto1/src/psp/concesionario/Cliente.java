package psp.concesionario;

public class Cliente extends Thread {
    private Concesonario concesonario;
    private Coche coche;
    private Integer ID;
    private boolean provabando = true;

    public Cliente(Concesonario concesonario, Integer ID) {
        this.concesonario = concesonario;
        this.ID = ID;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setProvabando(boolean provabando) {
        this.provabando = provabando;
    }

    public boolean isProvabando() {
        return provabando;
    }

    @Override
    public void run() {
            while (provabando){
                concesonario.verCoche(this);
            }
            System.out.println("Cliente "+ID+" compra coche " + coche.getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
