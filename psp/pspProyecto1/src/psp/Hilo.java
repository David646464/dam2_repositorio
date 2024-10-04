package psp;

public class Hilo extends Thread{

    public Hilo(String nombre){
        super(nombre);
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            System.out.println("Soy " + getName() + ": " + i);
        }
        System.out.println("Fin " + getName());
    }

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo1");
        Hilo hilo2 = new Hilo("Hilo2");
        hilo1.start();
        hilo2.start();
        System.out.println("===");

    }
}
