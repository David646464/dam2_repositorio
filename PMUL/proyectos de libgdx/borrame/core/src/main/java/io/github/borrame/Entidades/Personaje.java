package io.github.borrame.Entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import io.github.borrame.Managers.TextureManager;

public class Personaje {

    public final int xini = 100, yini = 305;
    public float x, y;
    public float xanzuelo, yanzuelo;
    private final float VELOCIDAD = 80;
    private final float VELOCIDADANZUELO = 120;
    private final int anchopersonaje = 150;
    private final int altopersonaje = 200;
    private final int anchoanzuelo = 20;
    private final int altoanzuelo = 30;
    private final float TOPEANZUELOYARRIBA = yini + altopersonaje - 66;
    private static final float TOPEANZUELOYABAJO = 0;
    TextureRegion fishCaught = new TextureRegion();

    enum EstadoAnzuelo {
        SUBIENDO, BAJANDO, PARADO
    }

    enum Estado {
        IZQUIERDA, DERECHA, PARADO
    }

    Estado estado;
    EstadoAnzuelo estadoAnzuelo;
    boolean mirandoIzquierda;
    boolean pescoPez = false;
    TextureManager tm;

    public Personaje(TextureManager tm) {
        this.tm = tm;
        x = xini;
        y = yini;
        estado = Estado.PARADO;
        estadoAnzuelo = EstadoAnzuelo.PARADO;
        xanzuelo = x + anchopersonaje - 20;
        yanzuelo = y;
        mirandoIzquierda = false; // Inicialmente mirando a la derecha

    }

    public void actualiza() {
        actualizaAnzuelo();
        switch (estado) {
            case IZQUIERDA: {
                if (x >= 0) {
                    x -= VELOCIDAD * Gdx.graphics.getDeltaTime();
                    xanzuelo -= VELOCIDAD * Gdx.graphics.getDeltaTime();
                }
                mirandoIzquierda = true;
                break;
            }
            case DERECHA: {
                if (x <= Gdx.graphics.getWidth() - 150) {
                    x += VELOCIDAD * Gdx.graphics.getDeltaTime();
                    xanzuelo += VELOCIDAD * Gdx.graphics.getDeltaTime();
                }
                mirandoIzquierda = false;
                break;
            }
        }
    }

    private void actualizaAnzuelo() {
        if (pescoPez) {
            if (yanzuelo >= TOPEANZUELOYARRIBA) {
                pescoPez = false;
            } else {
                yanzuelo += VELOCIDADANZUELO * Gdx.graphics.getDeltaTime();
            }

        } else {
            switch (estadoAnzuelo) {
                case SUBIENDO: {
                    if (yanzuelo <= TOPEANZUELOYARRIBA) {
                        yanzuelo += VELOCIDADANZUELO * Gdx.graphics.getDeltaTime();
                    }
                    break;
                }
                case BAJANDO: {
                    if (yanzuelo >= TOPEANZUELOYABAJO) {
                        yanzuelo -= VELOCIDADANZUELO * Gdx.graphics.getDeltaTime();
                    }
                    break;
                }
            }
        }
    }

    public void dibuja(SpriteBatch sb, TextureRegion textura) {
        tm.GirarPescador(mirandoIzquierda);
        tm.GirarAnzuelo(mirandoIzquierda);
        sb.draw(textura, x, y, anchopersonaje, altopersonaje);
    }

    public void dibujaAnzuelo(SpriteBatch sb, TextureRegion textura) {
        if (mirandoIzquierda) {
            xanzuelo = x;
        } else {
            xanzuelo = x + anchopersonaje - 20;
        }
        if (pescoPez) {
            sb.draw(fishCaught, xanzuelo-(fishCaught.getRegionWidth() / 2), yanzuelo - (fishCaught.getRegionHeight() / 2), fishCaught.getRegionWidth() / 2, fishCaught.getRegionHeight() / 2, fishCaught.getRegionWidth(), fishCaught.getRegionHeight(), 1, 1, 270);        } else {
            sb.draw(textura, xanzuelo, yanzuelo, anchoanzuelo, altoanzuelo);
        }
    }

    public void dibujaSedal(SpriteBatch sb, TextureRegion textura) {
        float x1, y1, x2 = 0;
        if (mirandoIzquierda) {
            x1 = x + 12;
            y1 = y + altopersonaje - 30;
            x2 = xanzuelo + anchoanzuelo - 11;
        } else {
            x1 = x + anchopersonaje - 14;
            y1 = y + altopersonaje - 30;
            x2 = xanzuelo + anchoanzuelo - 14;
        }

        float y2 = yanzuelo + altoanzuelo;

        float dx = x2 - x1;
        float dy = y2 - y1;
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        float angle = (float) Math.atan2(dy, dx) * 180 / (float) Math.PI;

        float grosor = 2;

        sb.draw(textura, x1, y1, 0, 0, length, grosor, 1, 1, angle);
    }

    public void izquierda() {
        estado = Estado.IZQUIERDA;
    }

    public void derecha() {
        estado = Estado.DERECHA;
    }

    public void parado() {
        estado = Estado.PARADO;
    }

    public void subirAnzuelo() {
        estadoAnzuelo = EstadoAnzuelo.SUBIENDO;
    }

    public void bajarAnzuelo() {
        estadoAnzuelo = EstadoAnzuelo.BAJANDO;
    }

    public void pararAnzuelo() {
        estadoAnzuelo = EstadoAnzuelo.PARADO;
    }

    public int getAnchoanzuelo() {
        return anchoanzuelo;
    }

    public int getAltoanzuelo() {
        return altoanzuelo;
    }

    public void pescoPez(TextureRegion fishCaught) {
        this.fishCaught = fishCaught;
        System.out.println("Pescado un pez");
        pescoPez = true;


    }
}


