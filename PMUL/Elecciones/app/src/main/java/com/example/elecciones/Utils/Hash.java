package com.example.elecciones.Utils;

public class Hash {

    public static String hash(String password) {
        //Prpio hash simple
        String hash = "";
        for (int i = 0; i < password.length(); i++) {
            hash += (char) (password.charAt(i) + 1);
        }
        return hash;
    }
}
