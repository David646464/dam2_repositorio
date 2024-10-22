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
                for (Plaza plaza : plazas) {
                    if (!plaza.isOcupada()) {
                        plaza.ocupar(conductor);
                        break;
                    }
                }
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
                    notifyAll();
                    break;
                }
            }
        }
        mostrarPlazas();
    }

    public void intercambiarConductor(Conductor conductor1, Conductor conductor2) {
        for (Plaza plaza : plazas) {
            if (plaza.getConductor().equals(conductor1)) {
                plaza.intercambiarConductor(conductor2);
                break;
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

    private boolean isFull() {
        for (Plaza plaza : plazas) {
            if (!plaza.isOcupada()) {
                return false;
            }
        }
        return true;
    }


}
