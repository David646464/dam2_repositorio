package Servicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
  public static void main(String[] args) throws IOException {
        String servidor = "localhost", FIN = "fin", mensaje = "-1", FINSERVIDOR = "shutdown";
        int puerto = 7; // puerto ECHO
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el servidor:");
        servidor = sc.nextLine();
        Socket socket = new Socket(servidor, puerto);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Conectado con el servidor");

        while (mensaje.equalsIgnoreCase("-1")) {
            System.out.println("escribe tu nombre");
            mensaje = sc.nextLine();
            out.writeUTF(mensaje);
            mensaje = in.readUTF();
            if (mensaje.equalsIgnoreCase("-1")) {
                System.out.println("Ya existe ese usuario en activo");

            }
        }

        while (!mensaje.equalsIgnoreCase(FIN)) {


            System.out.println("Escribe qeu usuario quires mirar");
            mensaje = sc.nextLine();
            out.writeUTF(mensaje);
            if (mensaje.equalsIgnoreCase(FIN) || mensaje.equalsIgnoreCase(FINSERVIDOR)) {
                continue;
            }
            String strRecibido = in.readUTF();
            String strRecibido2 = in.readUTF();
            System.out.println("Cliente : " + mensaje + " se ha conectado " + strRecibido + " veces y su estado actual es:" + strRecibido2);

        }
        socket.close();
    }
}

