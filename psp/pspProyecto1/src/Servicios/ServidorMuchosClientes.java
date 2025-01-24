package Servicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class ServidorMuchosClientes extends Thread {
    public static ArrayList<HiloEcho> hiloEchos = new ArrayList<>();
    int puerto = 7; // puerto ECHO
    ServerSocket serverSocket;
    boolean salir = false;

    public ServidorMuchosClientes() throws IOException {
        serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor arriba");
    }

    @Override
    public void run() {
        do {
            Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (IOException ex) {
                System.out.println("Servidor abajo");
                return;
            }
            if (!salir) {
                HiloEcho hiloEcho = new HiloEcho(this, socket, hiloEchos);
                hiloEcho.start();
            }
        } while (!salir);
    }

    public void shutdown() {
        salir = true;
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Problemas duante el apagado del servidor");
        }
    }

    public static void main(String[] args) {
        try {
            new ServidorMuchosClientes().start();
        } catch (IOException ex) {
            System.out.println("Error iniciando el servidor");
        }
    }

    public ArrayList<HiloEcho> getHilos() {
        return hiloEchos;
    }
}

class HiloEcho extends Thread {
    String finHilo = "fin", finServidor = "shutdown";
    ServidorMuchosClientes servidor;
    Socket socket;
    ArrayList<HiloEcho> hiloEchos;
    public String nombre;

    public HiloEcho(ServidorMuchosClientes servidor, Socket socket, ArrayList<HiloEcho> hiloEchos) {
        this.servidor = servidor;
        this.socket = socket;
        this.hiloEchos = hiloEchos;
    }

    @Override
    public void run() {
        boolean salir = false;
        hiloEchos = servidor.getHilos();
        SocketAddress clientAddress = socket.getRemoteSocketAddress();
        System.out.println("Ha conectado " + clientAddress);
        DataInputStream in;
        DataOutputStream out;

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Problemas creando la conexión");
            return;
        }
        try {
            if (contieneStr(nombre = in.readUTF())) {
                out.writeUTF("Ya existe ese hilo");
                salir = true;
            } else {
                hiloEchos.add(this);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str;

        while (!salir) {
            hiloEchos = servidor.getHilos();
            try {

                str = in.readUTF();
                if (str.equalsIgnoreCase(finServidor)) {
                    hiloEchos.remove(this);
                    servidor.shutdown();
                } else  {
                    for (HiloEcho hiloEcho : hiloEchos) {
                        if (hiloEcho.nombre.equals(str)) {
                            out.writeUTF(in.readUTF());
                        }
                    }
                }

            } catch (IOException ex) {
                System.out.println("Error en la transmisión");
                break;
            }
            if (str.equalsIgnoreCase(finHilo)) salir = true;
            else {
                System.out.println("Servidor retransmite: " + str);
                System.out.println("***************************");
            }
        }
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error cerrando conexión");
        }
    }

    private boolean contieneStr(String str) {
        for (HiloEcho hiloEcho : hiloEchos) {
            if (hiloEcho.nombre.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
