package psp.TierraEnPeligro;

public class Meteorito {
    private int id;
    private boolean taladrado;
    private NaveA naveA;

    public Meteorito(int x) {
        this.id = x;
        taladrado = false;
    }

    public void setNaveA(NaveA naveA) {
        this.naveA = naveA;
    }

    public int getId() {
        return id;
    }

    public boolean isTaladrado() {
        return taladrado;
    }

    public void setTaladrado(boolean taladrado) {
        this.taladrado = taladrado;
    }

    @Override
    public String toString() {
        return "Meteorito{" + "id=" + id + ", taladrado=" + taladrado + '}';
    }

    public NaveA getNaveA() {
        return naveA;
    }
}
