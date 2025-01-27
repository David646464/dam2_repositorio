package io.github.proyecto1;

import java.io.File;

public class Borrar {
    public static void main(String[] args) {
        // Método que al ejecutar borra en una carpeta todos los png que contengan en el nombre 2, 3 y 4
        borrar("D:\\dsancpeso\\repositorio\\dam2_repositorio\\PMUL\\proyectos de libgdx\\cartas\\assets\\ttrpg_legacy_cards_1.0");
    }

    private static void borrar(String s) {
        File folder = new File(s);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName();
                // Verifica si el nombre del archivo contiene "2", "3" o "4" y si es un archivo PNG
                if ((!name.contains("bronze") && !name.contains("gold") && !name.contains("silver")) && name.endsWith(".png")) {
                    file.delete();
                }
            }
        }
    }


}
