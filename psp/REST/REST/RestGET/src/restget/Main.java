package restget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSeleccinado = -1;
        int numMaxMenu = 4;
        while (numMaxMenu != numSeleccinado) {
            imprimirMenu();
            numSeleccinado = sc.nextInt();
            switch (numSeleccinado) {
                case 1->{
                   RestGET.imprimirClientes();
                }
                 case 2->{
                      System.out.println(numSeleccinado);
                }
                 case 3->{
                      System.out.println(numSeleccinado);
                }
                 case 4->{
                      System.out.println("fin");
                }

            }
        }
    }

    private static void imprimirMenu() {
        System.out.println("**************************************");
        System.out.println("*Opcion 1 : Imprimir clientes                      *" );
        System.out.println("*Opcion 2 :                                                *");
        System.out.println("*Opcion 3 :                                                *");
        System.out.println("*Opcion 4 : Salir                                        *");
         System.out.println("**************************************");
    }
}
