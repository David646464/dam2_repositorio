package psp;

public class Ej1 extends Thread{
    private static int numero = 0;
    private static int aumento;

    public Ej1(int numIncrementos) {
        aumento = numIncrementos;
    }

    public static int getNumero() {
        return numero;
    }
    @Override
    public void run(){
        for (int i = 0; i < aumento; i++) {
            incrementa();
        }
    }

    private void incrementa() {
        numero ++;
    }

    public static void main(String[] args) throws InterruptedException {
        Ej1 ej1 = null;
        int NUM_HILOS = 10;
        int NUM_INCREMENTOS = 10;
        for (int i = 0; i < NUM_HILOS; i++) {
            ej1 = new Ej1(NUM_INCREMENTOS);
            ej1.start();
        }
        ej1.join();
        System.out.println(ej1.getNumero());
    }
}
