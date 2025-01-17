package Servicios;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
         Socket socket = null;
        int puerto = 7; // puerto ECHO
        ServerSocket serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor arriba");
        while (true){
             socket = serverSocket.accept(); // Esperamos por un cliente
        SocketAddress clientAddress = socket.getRemoteSocketAddress();
        System.out.println("Ha conectado " + clientAddress);
         Sokect sokect = new Sokect(socket);
         sokect.start();
        }

    }
}
