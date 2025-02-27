package Almacen;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente1 {
    public static void main(String[] args) {
        String servidor = "localhost", FIN = "fin", mensaje = "";
        int puerto = 7; // puerto ECHO
        Scanner sc = new Scanner(System.in);
 /* comentado para trabajar con localhost
 System.out.println("Servidor? ");
 servidor=sc.nextLine(); */

        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        try {
            socket = new Socket(servidor, puerto);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            mensaje = in.readUTF();
            System.out.println(mensaje);
            if (mensaje.equalsIgnoreCase("Servidor lleno, intenta más tarde")) {
                socket.close();
                return;
            }
        } catch (IOException ex) {
            System.out.println("Problemas conectando con servidor " + servidor + ":" + puerto);
            return;
        }
        while (!mensaje.equalsIgnoreCase(FIN)) {
            mensaje = sc.nextLine();

            if (!mensaje.equalsIgnoreCase(FIN)) {
                String strRecibido;
                try {
                    //Enviamos
                    out.writeUTF(mensaje);

                    //Recibimos
                    mensaje = in.readUTF();
                    System.out.println(mensaje);
                } catch (IOException ex) {
                    System.out.println("Problemas en la transmisión");
                    break;
                }
            } else {
                System.out.println("Fin de la conexión");
            }
        }
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error cerrando conexión");
        }
    }
}