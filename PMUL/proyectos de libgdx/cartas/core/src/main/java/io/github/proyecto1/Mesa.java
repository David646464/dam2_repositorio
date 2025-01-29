package io.github.proyecto1;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;

import io.github.proyecto1.Manejadores.TextureManager;
import io.github.proyecto1.Utils.CreaTableros;
import io.github.proyecto1.entidades.Carta;
import io.github.proyecto1.entidades.Contador;
import io.github.proyecto1.entidades.Fondo;

public class Mesa {

    public static OrthographicCamera camera = new OrthographicCamera();


    public enum Dificultad {FACIL, MEDIO, DIFICIL}

    public static Fondo fondo = new Fondo();
    public static float margen = 30;
    public static Dificultad dificultad = Dificultad.DIFICIL;
    public static float alturaCamara = 1400;
    public static float anchoCamara = 1600;
    public static int cantidadCartas = getCartasPorDificultad();
    public static int cartasPorFila = cantidadCartas - 1;
    public static int cartasPorColumna = cantidadCartas;
    public static int[][] tablero = CreaTableros.crearTablero(cartasPorFila, cartasPorColumna);
    public static int[] ajustesMargenCartas = {550, 250, 550, 60, 550, 20};
    public static int intentos = 0;
    public static Contador contador = new Contador();

    public static Array<Carta> cartas = getCartas();

    private static int getCartasPorDificultad() {
        switch (dificultad) {
            case FACIL:
                return 5;
            case MEDIO:
                return 6;
            case DIFICIL:
                return 7;
            default:
                return 5;
        }
    }

    private static Array<Carta> getCartas() {
        Array<Carta> cartas = new Array<Carta>();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                cartas.add(new Carta(TextureManager.getCarta(tablero[i][j]), TextureManager.getCartaOculta(), tablero[i][j], i, j));
            }
        }
        return cartas;
    }
}
