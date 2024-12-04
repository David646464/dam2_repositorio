package UD1.EJ1_A3_4UD1;

import java.io.*;
import java.util.Scanner;



public class EJ1_A3_4UD1_mal {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runCode(args);
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
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
        try {
            while (true) {
                Corredor corredor = (Corredor) objectInputStream.readObject();
                System.out.println((corredor.toString()));
            }
        } catch (Exception e) {
        }
        System.out.println("Fin del programa");
    }

    private static void borrar(String ruta) {
        /*if(new File(ruta).exists()){
            Scanner sc = new Scanner(System.in);

            System.out.println("Escirbe el numero del dorsal:");
            int numeroDorsal = sc.nextInt();

            try(RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "rw")){
                randomAccessFile.
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta));
                 ObjectInputStream objectInputStreamAux = new ObjectInputStream(new FileInputStream("src\\UD1.Tarea3Parte3\\EJ1_A3_2UD1\\aux.dat"));){
                while (true){
                    Corredor corredor = (Corredor) objectInputStreamAux.readObject();
                    objectOutputStream.writeObject(corredor);
                }
            }catch (Exception e){

            }

            try {
                Files.delete(Path.of("src\\UD1.Tarea3Parte3\\EJ1_A3_2UD1\\aux.dat"));
            }catch (Exception e){
                throw  new RuntimeException();
            }
        }*/

    }

    private static void modificarRegistro(String ruta) throws IOException {
            Scanner sc = new Scanner(System.in);
            RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "rw");
            System.out.println("Escirbe el numero del dorsal:");
            int numeroDorsal = sc.nextInt();
            guardarCorredor(randomAccessFile, crearCorredor(numeroDorsal));
    }

    private static void consultarTodosLosRegistros(String ruta) throws IOException {
        if (new File(ruta).exists()) {
            Scanner sc = new Scanner(System.in);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
            try {
                while (true) {
                    Corredor corredor = (Corredor) objectInputStream.readObject();
                    System.out.println((corredor.toString()));

                }
            } catch (Exception e) {

            }
        } else {
            System.out.println("No existe el archivo");
        }
    }

    private static void consultarRegistro(String ruta) throws IOException {
        if (new File(ruta).exists()) {
            Scanner sc = new Scanner(System.in);
            RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "r");
            System.out.println("Introduce el numero del dorsal:");
            int numeroDorsal = sc.nextInt();
            System.out.println(leerCorredor(randomAccessFile, numeroDorsal));

        }
    }

    private static void adjuntarRegistro(String ruta) throws IOException, ClassNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(ruta, "rw");
        Corredor corredor = new Corredor();
        while (corredor != null) {
            corredor = crearCorredor();
            if (corredor != null) {
                randomAccessFile.seek(corredor.getDorsal() * 80);
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

    private static boolean comprobarExistencia(Corredor corredor, String ruta) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));

        try {
            while (true) {
                if (corredor.equals((Corredor) objectInputStream.readObject())) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }

    }

    private static Corredor crearCorredor() {
        Scanner sc = new Scanner(System.in);
        Corredor corredor = null;
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        if (!nombre.startsWith("*")) {
            System.out.println("Introduce el apellido1:");
            String apellido1 = sc.nextLine();
            System.out.println("Introduce el apellido2:");
            String apellido2 = sc.nextLine();
            System.out.println("Introduce el dorsal:");
            int dorsal = sc.nextInt();
            System.out.println("Introduce el tiempo en segundos:");
            double tiempoEnSegundos = sc.nextDouble();
            corredor = new Corredor(nombre, apellido1, apellido2, dorsal, tiempoEnSegundos,false);
        }
        return corredor;
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
            corredor = new Corredor(nombre, apellido1, apellido2, dorsal, tiempoEnSegundos,false);
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


    private static String leerCorredor(RandomAccessFile randomAccessFile, int numeroDorsal) throws IOException {
        randomAccessFile.seek(numeroDorsal * 80);

        return "nombre: " + randomAccessFile.readUTF() + ", apellido1: " + randomAccessFile.readUTF() +", apellido1: "+ randomAccessFile.readUTF() + ", dorsal:"+numeroDorsal + " y tiempo en segundos" + randomAccessFile.readDouble();
    }

    class MiObjectObjectOutputStream extends ObjectOutputStream {

        public MiObjectObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        protected MiObjectObjectOutputStream() throws IOException, SecurityException {
        }
    }
}
