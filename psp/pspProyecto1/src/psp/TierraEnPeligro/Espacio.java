package psp.TierraEnPeligro;

import java.util.ArrayList;

public class Espacio {
    private final int MAX_METEORITOS = 10;
    private final int MAX_NAVEA = 5;
    private final int MAX_NAVEB = 3;
    private ArrayList<Meteorito> meteoritos = new ArrayList<>();

    private ArrayList<NaveA> navesA = new ArrayList<>();

    private ArrayList<NaveB> navesB = new ArrayList<>();



    public Espacio() {
        for (int i = 0; i < MAX_METEORITOS; i++) {
            meteoritos.add(new Meteorito(i));
        }

        for (int i = 0; i < MAX_NAVEA; i++) {
            navesA.add(new NaveA(i, this));
        }

        for (int i = 0; i < MAX_NAVEB; i++) {
            navesB.add(new NaveB(i, this));
        }

        for (NaveA naveA : navesA) {
            naveA.start();
        }

        for (NaveB naveB : navesB) {
            naveB.start();
        }


    }

    synchronized public void taladrarMeteorito(NaveA naveA) throws InterruptedException {

        Meteorito meteorito = buscarMeteoritoSinTaladrar();
        if (meteorito != null) {
            meteorito.setTaladrado(true);
            meteorito.setNaveA(naveA);
            System.out.println("NaveA " + naveA.getId() + " ha taladrado el meteorito " + meteorito.getId());
            notifyAll();
            wait();
        }


    }

    private Meteorito buscarMeteoritoSinTaladrar() {
        if (meteoritos.isEmpty()) {
            return null;
        }
        for (Meteorito meteorito : meteoritos) {
            if (!meteorito.isTaladrado()) {
                return meteorito;
            }
        }
        return null;
    }

    synchronized public void explotarMeteoritoYSacarNaveA(NaveB naveB) throws InterruptedException {
        Meteorito meteorito = buscarMeteoritoTaladrado();
        if (meteorito != null) {
            notificarNaveA(meteorito.getNaveA());
            meteoritos.remove(meteorito);
            System.out.println("NaveB " + naveB.getId() + " ha explotado el meteorito " + meteorito.getId());
        }else{
            if (meteoritos.size() == 0) {
                notifyAll();
            }else{
                wait();
            }

        }

    }


    private void notificarNaveA(NaveA naveA) {
        System.out.println("NaveA " + naveA.getId() + " ha sido liberada");
        synchronized (this) {
            notify();
        }
    }

    synchronized private Meteorito buscarMeteoritoTaladrado() {
        if (meteoritos.size() == 0) {
            return null;
        }
        for (Meteorito meteorito : meteoritos) {
            if (meteorito.isTaladrado()) {
                meteoritos.remove(meteorito);
                return meteorito;
            }
        }
        return null;
    }

    public ArrayList<Meteorito> getMeteoritos() {
        return meteoritos;
    }
}