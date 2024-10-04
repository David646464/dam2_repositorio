package psp;

import java.util.ArrayList;

public class Ej1 extends Thread{
    private static Integer numero = 0;
    private Integer aumento;

    public Ej1(Integer NUM_INCREMENTOS) {
    aumento = NUM_INCREMENTOS;
    }

    public  int getNumero() {
        return numero;
    }
    @Override
    public void run(){
        synchronized (Ej1.numero) {

            for (int i = 0; i < aumento; i++) {
                Integer tmp = numero;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                numero = tmp + 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ej1 ej1 = null;
        ArrayList<Ej1> hilos = new ArrayList<>();
        Integer NUM_HILOS = 1000;
        Integer NUM_INCREMENTOS = 10;
        for (int i = 0; i < NUM_HILOS ; i++) {
            ej1 = new Ej1(NUM_INCREMENTOS);
            ej1.start();
            hilos.add(ej1);
        }
        for(Ej1 ej1Aux : hilos ){
                ej1Aux.join();
        }

        System.out.println(ej1.getNumero());
    }
}
