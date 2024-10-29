package psp.Conversacion;

import java.io.IOException;

public class Chateador extends Thread {
    private String nombre;
    private Chat chat;
    private String[] conversacion = {
            "Hola, ¿cómo estás?",
            "Muy bien, ¿y tú?",
            "También bien, gracias.",
            "¿Qué has hecho hoy?",
            "He estado trabajando en un proyecto interesante.",
            "¡Qué bien! Cuéntame más.",
            "Es un proyecto de programación en Java.",
            "Me encanta Java. ¿Qué estás desarrollando?",
            "Una aplicación de chat.",
            "¡Qué coincidencia! Yo también estoy trabajando en algo similar.",
            "¿En serio? ¡Qué interesante!",
            "Sí, podríamos colaborar.",
            "Me parece una excelente idea.",
            "¿Cuándo podríamos empezar?",
            "¿Qué tal mañana por la tarde?",
            "Perfecto, nos vemos entonces.",
            "Hasta mañana.",
            "Hasta mañana, cuídate.",
            "Tú también, adiós.",
            "Adiós."
    };

    public Chateador(String nombre, Chat chat) {
        this.nombre = nombre;
        this.chat = chat;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while (chat.isChateando() && chat.getNumActual() < chat.getNumMensaje()) {
                chat.chatear(conversacion[chat.getNumActual()], this);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getConversacion() {
        return conversacion.length;
    }
}
