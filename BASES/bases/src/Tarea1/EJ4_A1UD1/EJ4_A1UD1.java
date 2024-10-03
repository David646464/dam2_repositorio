package Tarea1.EJ4_A1UD1;

import java.io.*;
import java.util.*;

public class EJ4_A1UD1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> lista= LeerFichero();
        Collections.sort(lista);
        System.out.println(lista.toString());
        guardarFichero(lista);
    }

    private static void guardarFichero(ArrayList<Integer> lista) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("src\\EJ4_A1UD1\\NumerosPositivos.txt"));
            for (int i = 0; i < lista.size(); i++) {
                printStream.print(lista.get(i));
                if (i < lista.size() - 1) {
                    printStream.print(";");
                }
            }

        printStream.close();
    }

    private static ArrayList<Integer> LeerFichero() throws FileNotFoundException {
        ArrayList<Integer> lista= new ArrayList<>();
        Scanner scanner = new Scanner(new File("src\\EJ4_A1UD1\\NumerosPositivos.txt"));
        while(scanner.hasNext()){
            scanner.useDelimiter(";");
            lista.add(Integer.decode(scanner.next()));
        }
        return lista;
    }
}
