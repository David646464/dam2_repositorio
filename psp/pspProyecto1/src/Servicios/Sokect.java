package Servicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sokect extends Thread {
    public Socket sokect;
    boolean salir = false;
    String FIN = "fin";

    public Sokect(Socket sokect) {
        this.sokect = sokect;
    }


    @Override
    public void run() {
        while (!salir) {

            try {
                DataInputStream in = null;
                in = new DataInputStream(sokect.getInputStream());
                DataOutputStream out = null;
                out = new DataOutputStream(sokect.getOutputStream());
                salir = false;
                while (!salir) {
                    String str = null;

                    str = in.readUTF();

                    out.writeUTF(str);

                    if (str.equalsIgnoreCase(FIN))
                        salir = true;
                    else {
                        System.out.println("Servidor retransmite: " + str);
                        System.out.println("****************************");
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Desconectado");
    }
}
