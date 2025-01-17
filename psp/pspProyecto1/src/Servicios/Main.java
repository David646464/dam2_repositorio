package Servicios;

import java.io.IOException;

public class Main {
     public static void main(String[] args) {
        Thread servidorThread = new Thread(() -> {
            try {
                Servidor.main(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread clienteThread = new Thread(() -> {
            try {
                Cliente.main(new String[]{});
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        servidorThread.start();
        clienteThread.start();
    }
}
