package examen.ejercicio1;

public class Organizacion extends Thread {
    private int idOrganizacion;
    private final Integer APORTACION = 50;
    private final Integer TIEMPO_ENTRE_APORTACION = 1000;

    public Organizacion(int i) {
        this.idOrganizacion = i;
    }


    @Override
    public void run() {
        try {
            while (!Banco.getInstance().isFinalizoSimulacion()){
                sleep(TIEMPO_ENTRE_APORTACION);
                Banco.getInstance().aportar(APORTACION,this);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Integer getAPORTACION() {
        return APORTACION;
    }

    public Integer getTIEMPO_ENTRE_APORTACION() {
        return TIEMPO_ENTRE_APORTACION;
    }
}
