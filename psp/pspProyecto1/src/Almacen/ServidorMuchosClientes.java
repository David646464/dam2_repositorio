package Almacen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ServidorMuchosClientes extends Thread {
    public static List<HiloEcho> hilos = new ArrayList<>();
    public static int MaxClientes = 2;
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
            if (!salir && hilos.size() < MaxClientes) {
                HiloEcho hilo = new HiloEcho(this, socket);
                hilos.add(hilo);
                System.out.println("Hilos activos: " + hilos.size());
                hilo.start();
                DataOutputStream out = null;
                try {
                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("Conectado con el servidor");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else if (salir) {
                try {
                    socket.close();
                    for (HiloEcho hilo : hilos) {
                        hilo.socket.close();
                    }
                } catch (IOException ex) {
                    System.out.println("Error cerrando conexión");
                }
            } else {
                try {
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("Servidor lleno, intenta más tarde");
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Error cerrando conexión");
                }
            }
        } while (!salir);
    }

    public void shutdown() {
        salir = true;
        try {

            serverSocket.close();
            for (HiloEcho hilo : hilos) {
                hilo.socket.close();

            }
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
}

class HiloEcho extends Thread {
    String finHilo = "fin", finServidor = "shutdown";
    ServidorMuchosClientes servidor;
    Socket socket;

    public HiloEcho(ServidorMuchosClientes servidor, Socket socket) {
        this.servidor = servidor;
        this.socket = socket;
    }

    @Override
    public void run() {
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
        String str;
        boolean salir = false;
        while (!salir) {
            try {
                str = in.readUTF();
                if (str.equalsIgnoreCase(finServidor)) servidor.shutdown();
            } catch (IOException ex) {
                System.out.println("Error en la transmisión");
                break;
            }
            if (str.equalsIgnoreCase(finHilo)) {
                salir = true;
            } else {
                System.out.println(str);
                if (str.equalsIgnoreCase("ListarProductos")) {
                    try {
                        out.writeUTF(Almacen.StringStock());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (str.equalsIgnoreCase("ObtenerProducto")) {
                    try {
                        out.writeUTF(Almacen.StringStock() + "\nIntroduce el nombre del producto");
                        String producto = in.readUTF();
                        out.writeUTF(Almacen.StringStock(producto) + "\nIntroduce la cantidad");
                        while (true) {
                            try {
                                int cantidad = Integer.parseInt(in.readUTF());
                                out.writeUTF(Almacen.ObtenerProducto(producto, cantidad));
                                break;
                            } catch (NumberFormatException e) {
                                out.writeUTF("Error numero no valido, introduce un numero entero");
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        out.writeUTF("Recibido: " + str);
                    } catch (IOException e) {
                        System.out.println("Server shutdown");
                    }
                }
            }
        }
        try {
            ServidorMuchosClientes.hilos.remove(this);
            System.out.println("Hilos activos: " + ServidorMuchosClientes.hilos.size());
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error cerrando conexión");
        }
    }
}