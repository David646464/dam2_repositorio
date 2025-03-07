package io.github.proyecto1.Manejadores;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.entidades.Carta;

public class ProcesadorDeEntradaJuego extends InputAdapter {
    private Carta carta1;
    private Carta carta2;
    private boolean carta1Seleccionada = false;
    private boolean carta2Seleccionada = false;
    public static String nombreJugador = "";


    public ProcesadorDeEntradaJuego() {
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            Mesa.setScreen(2);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {

        if (Mesa.gano) {
            if (character == '\b') { // Handle backspace
                if (nombreJugador.length() > 0) {
                    nombreJugador = nombreJugador.substring(0, nombreJugador.length() - 1);
                }
            } else if (character == '\r' || character == '\n') {
            } else {
                if (nombreJugador.length() < 10) {
                    nombreJugador += character;
                }
            }
        } else if (character == 'r') {
            Mesa.setScreen(0);

        }
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
        Mesa.camera.unproject(worldCoordinates);

        if (hayCartasContandoDelta()) {
            if (!carta1Seleccionada) {
                System.out.println("==============");
                carta1 = getCarta(worldCoordinates.x, worldCoordinates.y);
                if (carta1 == null) {
                    System.out.println("==============");
                    return true;
                }
                if ((carta1.getEncontrada() || carta1.getSelectionada())) {
                    System.out.println("==============");
                    return true;
                }
                carta1.setSeleccionada(true);
                carta1Seleccionada = true;
                System.out.println("Carta 1 seleccionada");
                System.out.println(carta1Seleccionada);
                System.out.println("==============");
            } else if (!carta2Seleccionada) {
                System.out.println("==============");
                carta2 = getCarta(worldCoordinates.x, worldCoordinates.y);
                if (carta2 == null) {
                    System.out.println("==============");
                    return true;
                }
                if ((carta2.getEncontrada() || carta2.getSelectionada())) {
                    System.out.println("==============");
                    return true;
                }
                carta2.setSeleccionada(true);
                carta2Seleccionada = true;
                System.out.println("Carta 2 seleccionada");
                System.out.println(carta2Seleccionada);
                System.out.println("==============");
                procesar();
            }
        }
        return true;
    }

    private boolean hayCartasContandoDelta() {
        for (Carta c : Mesa.cartas) {
            if (c.getContarDelta()) {
                return false;
            }
        }
        return true;
    }

    private Carta getCarta(float worldX, float worldY) {
        Rectangle r = new Rectangle(worldX, worldY, 1, 1);

        switch (Mesa.dificultad) {
            case FACIL:
                r = new Rectangle(worldX - Mesa.ajustesMargenCartas[0], worldY - Mesa.ajustesMargenCartas[1], 1, 1);
                break;
            case MEDIO:
                r = new Rectangle(worldX - Mesa.ajustesMargenCartas[2], worldY - Mesa.ajustesMargenCartas[3], 1, 1);
                break;
            case DIFICIL:
                r = new Rectangle(worldX - Mesa.ajustesMargenCartas[4], worldY - Mesa.ajustesMargenCartas[5], 1, 1);
                break;
        }
        for (Carta c : Mesa.cartas) {
            if (c.colisiona(r)) {
                System.out.println("Carta encontrada " + c.getNumero());
                return c;
            }
        }
        return null;
    }

    public void procesar() {
        if (carta1Seleccionada && carta2Seleccionada) {
            System.out.println("**********************");
            System.out.println("Procesando cartas");
            System.out.println("Carta 1: " + carta1.getNumero());
            System.out.println("Carta 2: " + carta2.getNumero());
            if (carta1.getNumero() == carta2.getNumero()) {
                carta1.setEncontrada(true);
                carta2.setEncontrada(true);
                System.out.println("Cartas encontradas");
                Mesa.cartasEncontradas += 2;
                if (Mesa.cartasEncontradas == Mesa.cartas.size) {
                    Mesa.gano = true;
                    System.out.println("Juego terminado");
                }
            } else {
                System.out.println("Cartas no encontradas");
                carta1.setContarDelta(true);
                carta1.setSeleccionada(false);
                carta2.setContarDelta(true);
                carta2.setSeleccionada(false);
            }
            Mesa.intentos++;
            carta1Seleccionada = false;
            carta2Seleccionada = false;
            System.out.println("**********************");
        }
    }
}
