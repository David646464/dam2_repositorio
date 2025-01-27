package io.github.proyecto1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Mesa {
    public static Array<Carta> cartas = new Array<Carta>();
    public enum Dificultad {FACIL, MEDIO, DIFICIL};
    public static float alturaCamara = 1200;
    public static float anchoCamara = 1200;
    public static Dificultad dificultad = Dificultad.FACIL;
    public static int cantidadCartas = getCartasPorDificultad();
    public static Array<Carta> cartasSeleccionadas = getCartas();

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

    private static Array<Carta> getCartas() {
        Array<Carta> cartas = new Array<Carta>();
        for (int i = 0; i < cantidadCartas / 2; i++) {
            String textura = TextureManager.getCarta();
            cartas.add(new Carta(new Texture("ttrpg_legacy_cards_1.0/" + textura)));
            cartas.add(new Carta(new Texture("ttrpg_legacy_cards_1.0/" + textura)));
        }
        return cartas;
    }


}
