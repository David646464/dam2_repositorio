package com.example.meterdatosenunabasededatos;

import java.io.Serializable;

public class MiniObjeto implements Serializable {
    private int id;
    private String texto;

    public MiniObjeto(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public MiniObjeto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
