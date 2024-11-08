package com.example.elecciones.Utils;

public class Hash {

    public static String hash(String password) {
        //Propio hash simple
        StringBuilder hash = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            hash.append((char) (password.charAt(i) + 1));
        }
        return hash.toString();
    }
}
