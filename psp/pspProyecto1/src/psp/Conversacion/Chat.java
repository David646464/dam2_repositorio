package psp.Conversacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Chat {
    private BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/psp/Conversacion/chat.txt"));
    private Chateador chateador1;
    private Chateador chateador2;
    private int turno = 1;
    private boolean chateando = true;

    public int getNumMensaje() {
        return numMensaje;
    }

    private int numMensaje = 0;
    private int numActual = 0;

    public Chat() throws IOException {
        this.chateador2 = new Chateador("Chateador 2", this);
        this.chateador1 = new Chateador("Chateador 1", this);
        this.numMensaje = chateador1.getConversacion();
        chateador2.start();
        chateador1.start();
    }

    public synchronized void chatear(String mensaje, Chateador chateador) throws IOException {
        if (numActual < numMensaje) {
            while (turno == 1 && chateador == chateador2 || turno == 2 && chateador == chateador1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numActual++;

            bufferedWriter.write(chateador.getNombre() + ": " + mensaje + "\n");
            bufferedWriter.flush();
            System.out.println(chateador.getNombre() + ": " + mensaje);
            turno = turno == 1 ? 2 : 1;
            notifyAll();


        } else {
            chateando = false;
            bufferedWriter.close();
        }
    }

    public int getNumActual() {
        return numActual;
    }

    public boolean isChateando() {
        return chateando;
    }
}
