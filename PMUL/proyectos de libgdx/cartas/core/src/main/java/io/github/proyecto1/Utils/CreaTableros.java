package io.github.proyecto1.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreaTableros {

    public static int[][] crearTablero(int filas, int columnas) {
        int totalCartas = filas * columnas;
        if (totalCartas % 2 != 0) {
            throw new IllegalArgumentException("El número total de cartas debe ser par.");
        }

        int[][] tablero = new int[filas][columnas];
        List<Integer> cartas = new ArrayList<>();
        for (int j = 0; j < totalCartas / 2; j++) {
            cartas.add(j);
            cartas.add(j);
        }


        Collections.shuffle(cartas);


        int index = 0;
        for (int j = 0; j < filas; j++) {
            for (int k = 0; k < columnas; k++) {
                tablero[j][k] = cartas.get(index++);
            }
        }
        imprimirTablero(tablero);
        return tablero;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int j = tablero[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < tablero.length; i++) {

                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        crearTablero(4, 5);
    }
}
