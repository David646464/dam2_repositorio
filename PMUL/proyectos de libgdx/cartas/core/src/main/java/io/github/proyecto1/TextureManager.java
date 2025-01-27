package io.github.proyecto1;

import java.io.File;
import java.util.Stack;

public class TextureManager {
    public static String folderAssets = "ttrpg_legacy_cards_1.0";
    public static Stack<String> cartas = getCartas();

    public static Stack<String> getCartas() {
        File folder = new File(folderAssets);
        File[] listOfFiles = folder.listFiles();
        Stack<String> cartas = new Stack<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName();
                if (name.endsWith(".png")) {
                    cartas.push(name);
                }
            }
        }
        return cartas;

    }

    public static String getCarta() {
        return cartas.pop();
    }

    public static void restaurarCartas() {
        cartas = getCartas();
    }

    public static boolean hayCartas() {
        return !cartas.isEmpty();
    }




}

