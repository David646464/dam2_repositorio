package tonteriasMias;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Cliente {
    public static boolean alive = true;
    public static final int PUERTO = 5032;

    public static void main(String[] args) {
        String mensaje;
        Scanner sc = new Scanner(System.in);
        String servidor = "192.168.206.15";
        AtomicReference<DataOutputStream> out = new AtomicReference<>();
        System.out.println("Conectado con el servidor");
        Thread.startVirtualThread(() -> {
            try (
                    Socket socket = new Socket(servidor, PUERTO);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
            ) {
                out.set(new DataOutputStream(socket.getOutputStream()));
                while (alive) {
                    String strRecibido = in.readUTF();
                    System.out.println(strRecibido);
                }
            } catch (IOException e) {
                System.out.println("fallo en la conexion del servidor1");
            }
            alive = false;
        });
        while (alive) {
            try {
                mensaje = sc.nextLine();
                if (out.get() != null) {
                    out.get().writeUTF(mensaje);
                }
            } catch (IOException e) {
                System.out.println("fallo en la conexion del servidor2");
            }
        }
    }
}