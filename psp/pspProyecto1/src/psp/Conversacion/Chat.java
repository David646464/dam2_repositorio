package psp.Conversacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chat {
    private Chateador chateador1;
    private Chateador chateador2;
    private Chateador chateador3;
    private int linea = 0;
    private final String[] mensajes;
    private boolean chateando = true;
    private final String srcConversacion = "src/psp/Conversacion/chat.txt";

    public Chat() throws IOException {
        mensajes = cargarMensajes();
        chateador1 = new Chateador("Chateador1", this);
        chateador2 = new Chateador("Chateador2", this);
        chateador1.start();
        chateador2.start();
    }

    private String[] cargarMensajes() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcConversacion));
        return bufferedReader.lines().toArray(String[]::new);
    }

    public synchronized void enviarMensaje(Chateador chateador) {
        if (linea < mensajes.length) {
            String mensaje = mensajes[linea];
            chateador.setMensaje(mensaje);
            chateador.mensajear();
            linea++;
            notifyAll();
        } else {
            chateando = false;
            notifyAll();
        }
    }

    public boolean isChateando() {
        return chateando;
    }
}