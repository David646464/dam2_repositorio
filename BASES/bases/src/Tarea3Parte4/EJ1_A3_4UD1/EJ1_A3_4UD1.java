package Tarea3Parte4.EJ1_A3_4UD1;

import UD1.EJ1_A3_2UD1.Corredor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EJ1_A3_4UD1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] string = new String[1];
        string[0] = "src/Tarea3Parte4/EJ1_A3_4UD1/corredores.dat";

        runCode(string);
    }

    private static void runCode(String[] args) throws IOException, ClassNotFoundException {
        String ruta = args[0];
        int opcion = 1;
        while (opcion != 6) {
            menu();
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    adjuntarRegistro(ruta);
                }
                case 2 -> {
                    consultarRegistro(ruta);
                }
                case 3 -> {
                    consultarTodosLosRegistros(ruta);
                }
                case 4 -> {
                    modificarRegistro(ruta);
                }
                case 5 -> {
                    borrar(ruta);
                }
            }
        }
}

    private static void borrar(String ruta) {


    }

    private static void modificarRegistro(String ruta) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "rw");
        Corredor corredor = new Corredor();
        System.out.println("Introduce el dorsal a modificar");
        int dorsal = new Scanner(System.in).nextInt();
        while (corredor != null) {
            corredor = crearCorredor(dorsal);
            if (corredor != null) {
                randomAccessFile.seek(corredor.getDorsal() * 80);
                if (randomAccessFile.read() != 0) {
                    System.out.println("El corredor no existe quieres guardarlo? Y/N");
                    guardarCorredor(randomAccessFile, corredor);
                } else {
                    System.out.println("El corredor " + corredor.getDorsal() + " ya esta introducido quieres sobrescribirlo? Y/N");
                    String opcion = new Scanner(System.in).nextLine();
                    if (opcion.equals("Y")) {
                        guardarCorredor(randomAccessFile, corredor);
                    }
                }
            }
        }
        randomAccessFile.close();
    }

    private static void consultarTodosLosRegistros(String ruta) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "r");
        for (int i = 1; i < (int) randomAccessFile.length() / 80 + 1; i++) {
            System.out.println(leerCorredor(randomAccessFile,i));
        }
    }

    private static void consultarRegistro(String ruta) throws IOException {
            Scanner sc = new Scanner(System.in);
            RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "r");
            System.out.println("Introduce el numero del dorsal:");
            int numeroDorsal = sc.nextInt();
            System.out.println(leerCorredor(randomAccessFile, numeroDorsal));
    }

    private static void adjuntarRegistro(String ruta) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "rw");
        Corredor corredor = new Corredor();
        while (corredor != null) {
            corredor = crearCorredor((int) randomAccessFile.length() / 80 + 1);
            if (corredor != null) {
                randomAccessFile.seek(corredor.getDorsal() * 80L);
                if (randomAccessFile.read() != 0) {
                    guardarCorredor(randomAccessFile, corredor);
                } else {
                    System.out.println("El corredor " + corredor.getDorsal() + " ya esta introducido quieres sobrescribirlo? Y/N");
                    String opcion = new Scanner(System.in).nextLine();
                    if (opcion.equals("Y")) {
                        guardarCorredor(randomAccessFile, corredor);
                    }
                }
            }
        }
        randomAccessFile.close();
    }

    private static void guardarCorredor(RandomAccessFile randomAccessFile, Corredor corredor) throws IOException {
        randomAccessFile.seek(corredor.getDorsal() * 80);
        randomAccessFile.writeUTF(corredor.getNombre());
        randomAccessFile.writeUTF(corredor.getApellido1());
        randomAccessFile.writeUTF(corredor.getApellido2());
        randomAccessFile.writeDouble(corredor.getTiempoSegundos());
    }

    private static String leerCorredor(RandomAccessFile randomAccessFile, int numeroDorsal) throws IOException {
        if ((int) randomAccessFile.length() / 80 + 1 >= numeroDorsal){
            randomAccessFile.seek(numeroDorsal * 80);
        }else{
            return "No hay ese numero de corredor";
        }
        return "nombre: " + randomAccessFile.readUTF() + ", apellido1: " + randomAccessFile.readUTF() +", apellido2: "+ randomAccessFile.readUTF() + ", dorsal:"+numeroDorsal + " y tiempo en segundos: " + randomAccessFile.readDouble();
    }




    private static Corredor crearCorredor(int Dorsal) {
        Scanner sc = new Scanner(System.in);
        Corredor corredor = null;
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        if (!nombre.startsWith("*")) {
            System.out.println("Introduce el apellido1:");
            String apellido1 = sc.nextLine();
            System.out.println("Introduce el apellido2:");
            String apellido2 = sc.nextLine();
            int dorsal = Dorsal;
            System.out.println("Introduce el tiempo en segundos:");
            double tiempoEnSegundos = sc.nextDouble();
            corredor = new Corredor();
        }
        return corredor;
    }
    private static void menu() {
        System.out.println("======================= \n" +
                "Menú de opciones \n" +
                "----------------\n" +
                "1.-Añadir registros\n" +
                "2.-Consultar un registro\n" +
                "3.-Consultar todos los registros\n" +
                "4.-Modificar un registro\n" +
                "5.-Borrar\n" +
                "6.-Salir\n" +
                "Elige una opción <1-6>\n" +
                "======================= \n"
        );
    }
}
