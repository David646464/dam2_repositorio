package io.github.proyecto1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreaTableros {

    public static int[][] crearTablero(int i) {
        int[][] tablero = new int[i][i];
        List<Integer> cartas = new ArrayList<>();
        for (int j = 0; j < i * i / 2; j++) {
            cartas.add(j);
            cartas.add(j);
        }

        // Mezclar las cartas
        Collections.shuffle(cartas);

        // Asignar las cartas al tablero
        int index = 0;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                tablero[j][k] = cartas.get(index++);
            }
        }

        return tablero;
    }

    public static void main(String[] args) {
        int[][] tablero = CreaTableros.crearTablero(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
