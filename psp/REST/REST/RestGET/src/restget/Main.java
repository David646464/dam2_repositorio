package restget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSeleccinado = -1;
        int numMaxMenu = 7;
        while (numMaxMenu != numSeleccinado) {
            imprimirMenu();
            numSeleccinado = sc.nextInt();
            switch (numSeleccinado) {
                case 1 -> {
                    RestGET.imprimirClientes();
                }
                case 2 -> {
                    RestGET.seleccionarCliente(sc);
                }
                case 3 -> {
                    RestPOST.insertarCliente(sc);
                }
                case 4 -> {
                    RestDelete.borrarCliente(sc);
                }
                case 5 -> {
                    RestDelete.borrarCursosCliente(sc);
                }
                case 6 -> {
                    RestDelete.borrarCursoCliente(sc);
                }
                case 7 -> {
                    System.out.println("fin");
                }


            }
        }
    }

    private static void imprimirMenu() {
        System.out.println("**************************************");
        System.out.println("*Opcion 1 : Imprimir clientes                      *");
        System.out.println("*Opcion 2 : Seleccionar un cliente             *");
        System.out.println("*Opcion 3 : Insertar un cliente                   *");
        System.out.println("*Opcion 4 : Borrar un cliente                     *");
        System.out.println("*Opcion 5 : Borrar cursos de un cliente    *");
        System.out.println("*Opcion 6 : Borrar  un curso de un cliente*");
        System.out.println("*Opcion 7 : Salir                                        *");
        System.out.println("**************************************");
    }
}
