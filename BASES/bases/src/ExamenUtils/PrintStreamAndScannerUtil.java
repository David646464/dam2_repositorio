package ExamenUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamAndScannerUtil {
    private static PrintStream printStream ;
    private static java.util.Scanner scanner;

    private static String root;

    public PrintStreamAndScannerUtil(String root) throws FileNotFoundException {
        PrintStreamAndScannerUtil.root = root;
        printStream = new PrintStream(new FileOutputStream(root, true));
        scanner = new java.util.Scanner(new File(root));

    }

    public static void setRoot(String root) throws FileNotFoundException {
        PrintStreamAndScannerUtil.root = root;
        printStream = new PrintStream(new FileOutputStream(root, true));
        scanner = new java.util.Scanner(root);
    }

    public static void guardarTexto(String text){
        printStream.print(text);
    }

    public static void guardarLinea(String text){
        printStream.println(text);
    }

    public static void leerArchivo(){
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }

    public static String leerLinea(){
        return scanner.nextLine();
    }
    public static String leerFichero(){
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            sb.append(scanner.nextLine() + "\n");
        }
        return sb.toString();

    }

    public static int leerInt(){
        return scanner.nextInt();
    }

    public static double leerDouble(){
        return scanner.nextDouble();
    }

    public static float leerFloat(){
        return scanner.nextFloat();
    }

    public static long leerLong(){
        return scanner.nextLong();
    }

    public static boolean leerBoolean(){
        return scanner.nextBoolean();
    }

    public static byte leerByte(){
        return scanner.nextByte();
    }

    public static short leerShort(){
        return scanner.nextShort();
    }

    public static String leerString(){
        return scanner.next();
    }

    public static void cerrar(){
        printStream.close();
        scanner.close();
    }

}
