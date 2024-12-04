package UD1.Tarea2.EJ4_A2UD1;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class EJ4_A2UD2 {
    public static void main(String[] args) {
        runCode();
    }

    private static void runCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio a listar:");
        String ruta = sc.nextLine();
        System.out.println("Introduce la extensión de los ficheros a listar:");
        String extension = sc.nextLine();

        File directory = new File(ruta);

        System.out.println("LISTANDO EL DIRECTORIO  " + directory.getAbsolutePath());
        if (directory.exists() && directory.isDirectory()) {

            File[] filesList = directory.listFiles(new Filtro(extension));

            if (filesList != null) {
                for (File file : filesList) {
                        Date date = new Date(file.lastModified());
                        System.out.println("-|" + file.getName() + "<Fichero> + " + file.length() + " bytes" + " " + fecha(date));
                }
            } else {
                System.out.println("la ruta no es un directorio");
            }
        } else {
            System.out.println("la ruta especificada no existe");
        }
    }

    private static String fecha(Date date) {
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900) + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    }
}
