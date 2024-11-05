package psp.ej4;

import java.util.ArrayList;

public class Aparcamiento {
    private ArrayList<Plaza> plazas = new ArrayList<>();

    public Aparcamiento(int numPlazas) {
        for (int i = 0; i < numPlazas; i++) {
            plazas.add(new Plaza());
        }
    }

    public synchronized void aparcar(Conductor conductor) {
        while (!conductor.isAparcado()) {
            if (!isFull()) {
                plazas.get(getPlazaLibre()).ocupar(conductor);
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        mostrarPlazas();
    }

    public synchronized void liberar(Conductor conductor) {
        for (Plaza plaza : plazas) {
            if (plaza.getConductor() != null) {
                if (plaza.getConductor().equals(conductor)) {
                    plaza.liberar();
                    notify();
                    break;
                }
            }
        }
        mostrarPlazas();
    }
    public void mostrarPlazas() {
        String plazasOcupadas = "";
        for (Plaza plaza : plazas) {
            if (plaza.isOcupada()) {
                plazasOcupadas += plaza.getConductor().getNombre() + "-";
            } else {
                plazasOcupadas += "X" + "-";
            }
        }
        System.out.println(plazasOcupadas);


    }

    private int getPlazaLibre() {
        for (int i = 0; i < plazas.size(); i++) {
            if (!plazas.get(i).isOcupada()) {
                return i;
            }
        }
        return -1;
    }

    private boolean isFull() {
        for (Plaza plaza : plazas) {
            if (!plaza.isOcupada()) {
                return false;
            }
        }
        return true;
    }


}
