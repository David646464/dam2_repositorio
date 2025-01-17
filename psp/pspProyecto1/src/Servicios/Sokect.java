package Servicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sokect extends Thread{
    public Socket sokect;
    boolean salir = false;
    String FIN = "fin";
    public Sokect(Socket sokect) {
        this.sokect = sokect;
    }


    @Override
    public void run() {
       while (!salir) {
           DataInputStream in = null;
           try {
               in = new DataInputStream(sokect.getInputStream());
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           DataOutputStream out = null;
           try {
               out = new DataOutputStream(sokect.getOutputStream());
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           salir = false;
        while (!salir) {
            String str = null;
            try {
                str = in.readUTF();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                out.writeUTF(str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (str.equalsIgnoreCase(FIN))
                salir = true;
            else {
                System.out.println("Servidor retransmite: " + str);
                System.out.println("****************************");
            }
        }
       }
        System.out.println("Desconectado");
    }
}
