package psp.Conversacion;

public class Chateador extends Thread {
    private String nombre;
    private String mensaje;
    private Chat chat;

    public Chateador(String nombre, Chat chat) {
        this.nombre = nombre;
        this.chat = chat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mensajear() {
        System.out.println(nombre + " dice: " + mensaje);
    }

    @Override
    public void run() {
        while (chat.isChateando()) {
            synchronized (chat) {
                chat.enviarMensaje(this);
                try {
                    if (chat.isChateando()) {
                        chat.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}