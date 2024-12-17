package com.example.proyectoexamenpmul.Objects;

public class Textos {
    private static String[]textos= {"","",""};
    private static Textos instance;

    public static void setTextos(String para,String asunto,String cuerpo) {
        textos[0]=para;
        textos[1]=asunto;
        textos[2]=cuerpo;
    }

    public static String[] getTextos() {
        return textos;
    }

    public static synchronized Textos getInstance() {
        if (instance == null) {
            instance = new Textos();
        }
        return instance;
    }
}
