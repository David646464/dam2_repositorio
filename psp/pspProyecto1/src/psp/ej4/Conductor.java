package psp.ej4;

public class Conductor extends Thread {
    private String nombre;
    private boolean aparcado = false;
    private Aparcamiento aparcamiento;

    public Conductor(String nombre, Aparcamiento aparcamiento) {
        this.nombre = nombre;
        this.aparcamiento = aparcamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAparcado() {
        return aparcado;
    }

    public void setAparcado(boolean aparcado) {
        this.aparcado = aparcado;
    }

    @Override
    public void run() {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!aparcado) {
                aparcamiento.aparcar(this);
            }
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (aparcado) {
            aparcamiento.liberar(this);

        }

    }
}
