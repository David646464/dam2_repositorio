package ExamenUtils;

import java.io.FileNotFoundException;

public class MainPruebas {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStreamAndScannerUtil printStreamAndScannerUtil = new PrintStreamAndScannerUtil("src\\ExamenUtils\\archivosDePruebas\\archivoScanner.txt");
        printStreamAndScannerUtil.guardarLinea("Hola mundo");
        printStreamAndScannerUtil.guardarLinea("Hola mundo 2");
        printStreamAndScannerUtil.guardarLinea("Hola mundo 3");

        String texto = printStreamAndScannerUtil.leerFichero();
        System.out.println(texto);
    }
}
