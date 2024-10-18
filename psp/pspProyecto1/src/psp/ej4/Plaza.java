package psp.ej4;

public class Plaza {
    private boolean ocupada;
    private Conductor conductor = null;

    public Plaza() {
        this.ocupada = false;
    }

    public synchronized void ocupar(Conductor conductor) {
        this.conductor = conductor;
        conductor.setAparcado(true);
        this.ocupada = true;
    }

    public void liberar() {
        this.conductor = null;
        this.ocupada = false;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void intercambiarConductor(Conductor conductor) {
        Conductor conductorAnterior = this.conductor;
        this.conductor = conductor;
        conductor = conductorAnterior;
    }

    public boolean isOcupada() {
        return ocupada;
    }
}
