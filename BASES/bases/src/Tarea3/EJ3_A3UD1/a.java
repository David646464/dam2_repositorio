package Tarea3.EJ3_A3UD1;

import java.io.*;

public class a {
    public static void main(String[] args) throws IOException {

            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File("D:\\dsancpeso\\bases\\bases\\src\\Tarea3\\EJ3_A3UD1\\datos1.dat")));

            try {
                while (true) {  // Loop infinito controlado por EOFException
                    int numero = dataInputStream.readInt();  // Lee un entero
                    System.out.println(numero);  // Muestra el entero
                }
            } catch (EOFException e) {
                // Fin del archivo alcanzado
                System.out.println("Fin del archivo.");
            }catch (Exception e){
                System.out.println("ERROR inesperado");
            } finally {
                dataInputStream.close();  // Cierra el flujo de entrada
            }

    }
}
