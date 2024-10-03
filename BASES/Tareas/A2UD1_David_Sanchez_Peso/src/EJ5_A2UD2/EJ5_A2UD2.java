package EJ5_A2UD2;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class EJ5_A2UD2 {
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

            File[] filesList = directory.listFiles();
            filesList = ordenarPorNombreYExtension(filesList);
            if (filesList != null) {
                for (File file : filesList) {

                    if (file.isFile() && file.getName().endsWith("." + extension)) {
                        Date date = new Date(file.lastModified());
                        System.out.println("-|" + file.getName() + "<Fichero> + " + file.length() + " bytes" + " " + fecha(date));
                    }
                }
            } else {
                System.out.println("la ruta no es un directorio");
            }
        } else {
            System.out.println("la ruta especificada no existe");
        }
    }

    private static File[] ordenarPorNombreYExtension(File[] filesList) {
        Arrays.sort(filesList, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {

                String name1 = getFileNameWithoutExtension(f1.getName());
                String name2 = getFileNameWithoutExtension(f2.getName());

                String ext1 = getFileExtension(f1.getName());
                String ext2 = getFileExtension(f2.getName());


                int nameComparison = name2.compareTo(name1);
                if (nameComparison != 0) {
                    return nameComparison;
                }


                return ext1.compareTo(ext2);
            }
        });
        return filesList;
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);

    }

    private static String getFileNameWithoutExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);

    }

    private static String fecha(Date date) {
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900) + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    }
}
