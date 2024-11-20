package psp.TierraEnPeligro;

import java.util.ArrayList;

public class Espacio {
    private final int MAX_METEORITOS = 10;
    private final int MAX_NAVEA = 5;
    private final int MAX_NAVEB = 3;
    private ArrayList<Meteorito> meteoritos;
    private ArrayList<NaveA> navesA;
    private ArrayList<NaveB> navesB;

    public Espacio() {
        meteoritos = new ArrayList<>();
        navesA = new ArrayList<>();
        navesB = new ArrayList<>();

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

    public void taladrarMeteorito(NaveA naveA) throws InterruptedException {
        while (meteoritos.size() != 0) {
            Meteorito meteorito = buscarMeteoritoSinTaladrar();
            if (meteorito != null) {
                synchronized (this) {
                    meteorito.setTaladrado(true);
                    meteorito.setNaveA(naveA);
                    this.wait();
                }
                taladrarMeteorito(naveA);
                System.out.println("NaveA " + naveA.getId() + " ha taladrado el meteorito " + meteorito.getId());
            }
        }
    }

    private Meteorito buscarMeteoritoSinTaladrar() {
        if (meteoritos.size() == 0) {
            return null;
        }
        for (Meteorito meteorito : meteoritos) {
            if (!meteorito.isTaladrado()) {
                meteorito.setTaladrado(true);
                return meteorito;
            }
        }
        return null;
    }

    public void explotarMeteoritoYSacarNaveA(NaveB naveB) throws InterruptedException {
        while (meteoritos.size() != 0) {
            Meteorito meteorito = buscarMeteoritoTaladrado();
            if (meteorito != null) {
                synchronized (this) {
                    meteorito.getNaveA().notify();
                    meteoritos.remove(meteorito);
                }
                explotarMeteoritoYSacarNaveA(naveB);
                System.out.println("NaveB " + naveB.getId() + " ha explotado el meteorito " + meteorito.getId());
            } else {
                synchronized (this) {
                    this.wait();
                }
            }
        }
        synchronized (this) {
            this.notifyAll();
        }
        System.out.println("Tierra salvada");
    }

    private Meteorito buscarMeteoritoTaladrado() {
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
}