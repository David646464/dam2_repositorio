package ExamenUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GuardarEnArchivoConScanner {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\ExamenUtils\\archivosDePruebas\\archivoScanner.txt");
        PrintStream printStream = new PrintStream(new FileOutputStream(new File("src\\ExamenUtils\\archivosDePruebas\\archivoScanner.txt"), true));

        //Guardar en el fichero
        printStream.println("Hola mundo");
        printStream.println("Hola mundo 2");
        printStream.println("Hola mundo 3");
        printStream.close();


        //Leer del fichero
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();



    }
}
