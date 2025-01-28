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
    public int numVeces = 0;
    public String nombre;
    boolean salio = false;

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
            while (!salir) {
                if (contieneStr(nombre = in.readUTF()) && isActive(nombre)) {
                    salir = true;
                    System.out.println("b1");
                    out.writeUTF("-1");
                } else if (contieneStr(nombre)) {
                    salir = false;
                    HiloEcho hiloEcho = getEcho(nombre);
                    hiloEcho.numVeces++;
                    System.out.println("b2");
                    out.writeUTF(nombre);
                } else {
                    salir = false;
                    numVeces++;
                    hiloEchos.add(this);
                    System.out.println("usuario añadido");
                    System.out.println("b3");
                    out.writeUTF(nombre);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str;

        while (!salir) {

            hiloEchos = servidor.getHilos();
            try {

                str = in.readUTF();
                System.out.println(str);
                String numVeces = "null";
                String estado = "null";

                if (str.equalsIgnoreCase(finServidor)) {
                    servidor.shutdown();
                } else if (str.equalsIgnoreCase(finHilo)) {
                    salir = true;
                } else {
                    System.out.println("========================");
                    for (HiloEcho hiloEcho : hiloEchos) {
                        System.out.println(hiloEcho.nombre);
                        if (hiloEcho.nombre.equals(str)) {
                            numVeces = String.valueOf(hiloEcho.numVeces);
                            estado = true != hiloEcho.salio ? " activo " : " desconectado ";
                            contieneStr(hiloEcho.nombre);
                            break;
                        }
                    }
                    out.writeUTF(numVeces);
                    out.writeUTF(estado);
                }

            } catch (IOException ex) {
                System.out.println("Error en la transmisión");
                break;
            }
            if (str.equalsIgnoreCase(finHilo)) {
                HiloEcho hiloEcho = getEcho(nombre);
                hiloEcho.salio = true;
                salir = true;
            }
        }
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error cerrando conexión");
        }
    }

    private boolean isActive(String nombre) {
        for (HiloEcho hiloEcho : hiloEchos) {
            if (hiloEcho.nombre.equals(nombre)) {
                return !hiloEcho.salio;
            }
        }
        return false;
    }

    private HiloEcho getEcho(String nombre) {
        for (HiloEcho hiloEcho : hiloEchos) {
            if (hiloEcho.nombre.equals(nombre)) {
                return hiloEcho;
            }
        }
        return null;

    }

    private boolean contieneStr(String str) {

        for (HiloEcho hiloEcho : hiloEchos) {
            System.out.println(hiloEcho.nombre);
            if (hiloEcho.nombre.equals(str)) {


                return true;
            }

        }


        return false;
    }
}
