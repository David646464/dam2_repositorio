package com.example.proyectoexamenpmul.Objects;

public class MiniAlert {
    private String token;
    private int valid;

    public MiniAlert(String token, int valid) {
        this.token = token;
        this.valid = valid;
    }

    public String getToken() {
        return token;
    }

    public int getValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Token:" + token;
    }
}
