package Tarea3Parte3.EJ1_A3_2UD1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;



public class EJ1_A3_3UD1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runCode(args);
    }

    private static void runCode(String[] args) throws IOException, ClassNotFoundException {
        String ruta = args[0];
        int opcion = 1;
        while (opcion != 7){
            menu();
            opcion = new Scanner(System.in).nextInt();
            switch (opcion){
                case 1 ->{crearArcivo(ruta);}
                case 2 ->{adjuntarRegistro(ruta);}
                case 3 ->{consultarRegistro(ruta);}
                case 4 ->{consultarTodosLosRegistros(ruta);}
                case 5 ->{modificarRegistro(ruta);}
                case 6 ->{borrar(ruta);}
            }
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
        try {
            while (true){
                Corredor corredor = (Corredor) objectInputStream.readObject();
                System.out.println((corredor.toString()));
            }
        }catch (Exception e){
        }
        System.out.println("Fin del programa");
    }

    private static void borrar(String ruta) {
        if(new File(ruta).exists()){
            Scanner sc = new Scanner(System.in);

            System.out.println("Escirbe el numero del dorsal:");
            int numeroDorsal = sc.nextInt();

            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
                ObjectOutputStream objectOutputStreamAux = new ObjectOutputStream(new FileOutputStream("src\\Tarea3Parte4\\EJ1_A3_4UD1\\aux.dat"));) {
                while (true){
                    Corredor corredor = (Corredor) objectInputStream.readObject();
                    if(!(corredor.getDorsal() == numeroDorsal)){
                        objectOutputStreamAux.writeObject(corredor);
                    }
                }
            }catch (Exception e){
            }
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta));
                 ObjectInputStream objectInputStreamAux = new ObjectInputStream(new FileInputStream("src\\Tarea3Parte4\\EJ1_A3_4UD1\\aux.dat"));){
                while (true){
                    Corredor corredor = (Corredor) objectInputStreamAux.readObject();
                    objectOutputStream.writeObject(corredor);
                }
            }catch (Exception e){

            }

            try {
                Files.delete(Path.of("src\\Tarea3Parte4\\EJ1_A3_4UD1\\aux.dat"));
            }catch (Exception e){
                throw  new RuntimeException();
            }
        }
    }

    private static void modificarRegistro(String ruta) throws IOException {
        if(new File(ruta).exists()){
            Scanner sc = new Scanner(System.in);

            System.out.println("Escirbe el numero del dorsal:");
            int numeroDorsal = sc.nextInt();

            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
                ObjectOutputStream objectOutputStreamAux = new ObjectOutputStream(new FileOutputStream("src\\Tarea3Parte4\\EJ1_A3_4UD1\\aux.dat"));) {
                while (true){
                    Corredor corredor = (Corredor) objectInputStream.readObject();
                    if(corredor.getDorsal() == numeroDorsal){
                        corredor = null;
                        while (corredor == null){
                            corredor = crearCorredor(numeroDorsal);
                        }
                    }
                    objectOutputStreamAux.writeObject(corredor);
                }
            }catch (Exception e){
            }
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta));
                    ObjectInputStream objectInputStreamAux = new ObjectInputStream(new FileInputStream("src\\Tarea3Parte4\\EJ1_A3_4UD1\\aux.dat"));){
                while (true){
                    Corredor corredor = (Corredor) objectInputStreamAux.readObject();
                    objectOutputStream.writeObject(corredor);
                }
            }catch (Exception e){

            }

            try {
                Files.delete(Path.of("src\\Tarea3Parte4\\EJ1_A3_4UD1\\aux.dat"));
            }catch (Exception e){
                throw  new RuntimeException();
            }
        }
        }

    private static void consultarTodosLosRegistros(String ruta) throws IOException {
        if(new File(ruta).exists()){
            Scanner sc = new Scanner(System.in);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
            try {
                while (true){
                    Corredor corredor = (Corredor) objectInputStream.readObject();
                        System.out.println((corredor.toString()));

                }
            }catch (Exception e){

            }
        }else {
            System.out.println("No existe el archivo");
        }
    }

    private static void consultarRegistro(String ruta) throws IOException {
        if(new File(ruta).exists()){
            Scanner sc = new Scanner(System.in);
            boolean encontrado = false;
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));
            System.out.println("Introduce el numero del dorsal:");
            int numeroDorsal = sc.nextInt();
            try {
                while (true){
                    Corredor corredor = (Corredor) objectInputStream.readObject();
                    if(corredor.getDorsal() == numeroDorsal){
                        encontrado = true;
                        System.out.println((corredor.toString()));
                    }
                }
            }catch (Exception e){
                if (!encontrado){
                    System.out.println("No se ha encontrado al corredor");
                }
            }
        }else {
            System.out.println("No existe el archivo");
        }

    }

    private static void adjuntarRegistro(String ruta) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta ,true));
        Corredor corredor  = new Corredor();
        while (corredor != null) {
            corredor = crearCorredor();
            if (corredor != null) {
                if (!comprobarExistencia(corredor, ruta)) {
                    objectOutputStream.writeObject(corredor);
                }
            }
        }

    }

    private static void crearArcivo(String ruta) throws IOException, ClassNotFoundException {

        Corredor corredor  = new Corredor();
        String opcion = "";
        if (new File(ruta).exists()) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta));
            System.out.println("Quieres sobrescribir el archivo? S/N");
            opcion = new Scanner(System.in).nextLine();
            if (opcion.equals("S")) {
                while (corredor != null) {
                    corredor = crearCorredor();
                    if (corredor != null) {
                        if (!comprobarExistencia(corredor, ruta)) {
                            objectOutputStream.writeObject(corredor);
                        }
                    }
                }
            }
            objectOutputStream.close();
        }else{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta));
            while (corredor != null) {
                corredor = crearCorredor();
                if (corredor != null) {
                    if (!comprobarExistencia(corredor, ruta)) {
                        objectOutputStream.writeObject(corredor);
                    }
                }
            }
            objectOutputStream.close();
        }

    }

    private static boolean comprobarExistencia(Corredor corredor, String ruta) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ruta));

        try {
            while (true){
                if (corredor.equals((Corredor) objectInputStream.readObject())){
                    return true;
                }
            }
        }catch (Exception e){
            return false;
        }

    }

    private static Corredor crearCorredor() {
        Scanner sc = new Scanner(System.in);
        Corredor corredor = null;
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        if (!nombre.startsWith("*")){
            System.out.println("Introduce el apellido1:");
            String apellido1 = sc.nextLine();
            System.out.println("Introduce el apellido2:");
            String apellido2 = sc.nextLine();
            System.out.println("Introduce el dorsal:");
            int dorsal = sc.nextInt();
            System.out.println("Introduce el tiempo en segundos:");
            double tiempoEnSegundos = sc.nextDouble();
            corredor = new Corredor(nombre,apellido1,apellido2,dorsal,tiempoEnSegundos);
        }
        return corredor;
    }
    private static Corredor crearCorredor(int Dorsal) {
        Scanner sc = new Scanner(System.in);
        Corredor corredor = null;
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        if (!nombre.startsWith("*")){
            System.out.println("Introduce el apellido1:");
            String apellido1 = sc.nextLine();
            System.out.println("Introduce el apellido2:");
            String apellido2 = sc.nextLine();
            int dorsal =Dorsal;
            System.out.println("Introduce el tiempo en segundos:");
            double tiempoEnSegundos = sc.nextDouble();
            corredor = new Corredor(nombre,apellido1,apellido2,dorsal,tiempoEnSegundos);
        }
        return corredor;
    }

    private static void menu() {
        System.out.println("======================= \n"+
                "Menú de opciones \n"+
                "----------------\n"+
                "1.-Crear archivo\n"+
                "2.-Añadir registros\n"+
                "3.-Consultar un registro\n"+
                "4.-Consultar todos los registros\n"+
                "5.-Modificar un registro\n"+
                "6.-Borrar\n"+
                "7.-Salir\n"+
                "Elige una opción <1-7>\n" +
                "======================= \n"
);
    }
}

class MiObjectObjectOutputStream extends ObjectOutputStream{

    public MiObjectObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjectObjectOutputStream() throws IOException, SecurityException {
    }
}
