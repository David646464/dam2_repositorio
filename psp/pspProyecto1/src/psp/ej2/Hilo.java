package psp.ej2;

public class Hilo extends Thread {
    final int NUM_INCREMENTOS = 100;
    Contador contador;

    public Hilo(String nombre, Contador contador) {
        super(nombre);
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_INCREMENTOS; i++)
            contador.incrementa();
    }


    public static void main(String[] args) {
        Integer hilos = 10;
        Contador contador1 = new Contador();
        Hilo hilo = new Hilo("Hilo", contador1);
        for (int i = 0; i < hilos; i++) {
            hilo = new Hilo("Hilo" + i, contador1);
            hilo.run();

        }
        System.out.println(hilo.contador.getContador());
    }
}
