package Servicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String servidor = "localhost", FIN = "fin", mensaje = "";
        int puerto = 7; // puerto ECHO
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el servidor:");
        servidor = sc.nextLine();
        Socket socket = new Socket(servidor, puerto);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Conectado con el servidor");
        System.out.println("escribe tu nombre");
        mensaje = sc.nextLine();
         out.writeUTF(mensaje);
        while (!mensaje.equalsIgnoreCase(FIN)) {
// ENVIAMOS ...

            System.out.println("Escribe qeu usuario quires mirar");
            mensaje = sc.nextLine();
            out.writeUTF(mensaje);
            String strRecibido = in.readUTF();
            System.out.print("Cliente : " + mensaje + "se ha conectado" + strRecibido + "veces y su estado actual es:");
            out.writeUTF(strRecibido);
            strRecibido = in.readUTF();
            System.out.println(strRecibido);

        }
        socket.close();
    }
}

