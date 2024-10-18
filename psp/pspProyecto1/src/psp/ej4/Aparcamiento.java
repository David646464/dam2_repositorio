package psp.ej4;

import java.util.ArrayList;

public class Aparcamiento {
    private ArrayList<Plaza> plazas = new ArrayList<>();

    public Aparcamiento(int numPlazas) {
        for (int i = 0; i < numPlazas; i++) {
            plazas.add(new Plaza());
        }
    }

    public void aparcar(Conductor conductor) {
        for (Plaza plaza : plazas) {
            if (!plaza.isOcupada()) {
                plaza.ocupar(conductor);
                break;
            }
        }
        mostrarPlazas();
    }

    public void liberar(Conductor conductor) {
        for (Plaza plaza : plazas) {
           if (plaza.getConductor()!=null){
               if (plaza.getConductor().equals(conductor)) {
                   plaza.liberar();
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

    public synchronized void mostrarPlazas() {
        System.out.println();
        for (Plaza plaza : plazas) {
            if (plaza.isOcupada()) {
                System.out.print(plaza.getConductor().getNombre() + "-");
            } else {
                System.out.print("X" + "-");
            }
        }

    }


}
