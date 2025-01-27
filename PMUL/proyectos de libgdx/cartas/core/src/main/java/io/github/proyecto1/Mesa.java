package io.github.proyecto1;

import com.badlogic.gdx.utils.Array;

public class Mesa {
    public static Array<Carta> cartas = new Array<Carta>();
    public enum Dificultad {FACIL, MEDIO, DIFICIL};
    public static float alturaCamara = 1200;
    public static float anchoCamara = 1200;
    public static Dificultad dificultad = Dificultad.FACIL;
    public static int cantidadCartas = getCartasPorDificultad();

    private static int getCartasPorDificultad() {
        switch (dificultad) {
            case FACIL:
                return 6;
            case MEDIO:
                return 8;
            case DIFICIL:
                return 10;
            default:
                return 6;
        }
    }


}
