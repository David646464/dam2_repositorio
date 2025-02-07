package io.github.proyecto1.entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.interfaces.Entidad;

public class Carta implements Entidad {
    private Texture texture;
    private Texture textureEscondida;
    private float x;
    private float y;
    public static float ancho = 100;
    public static float alto = 170;
    private boolean visible;
    private boolean seleccionada;
    private boolean encontrada;
    private int numero;
    public boolean contarDelta = false;
    private float delta = 0;
    private final float tiempoMostrarCartas = 1;


    public Carta(Texture texture, Texture textureEscondida, int numero, int xTablero, int yTablero) {
        this.texture = texture;
        this.textureEscondida = textureEscondida;
        this.numero = numero;
        this.x = xTablero * (ancho + Mesa.margen);
        this.y = yTablero * (alto + Mesa.margen);
        this.visible = true;
        this.seleccionada = false;
        this.encontrada = false;

    }


    @Override
    public boolean colisiona(Rectangle r) {
        return getRectangle().overlaps(r);
    }

    @Override
    public Rectangle getRectangle() {
        // System.out.println("x: " + x + " y: " + y + " ancho: " + ancho + " alto: " + alto);
        return new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void dibujar(SpriteBatch sb, float delta) {
        if (contarDelta){
            this.delta += delta;
        }
        if (this.delta > tiempoMostrarCartas){
           contarDelta = false;
           this.delta = 0;
        }
        Texture texture = textureEscondida;
        if (visible && texture != null) {
            if (seleccionada || (this.delta < 1 && contarDelta)){
                texture = this.texture;
            }
            dibujarSegunDificultad(texture, sb);
        }

    }

    private void dibujarSegunDificultad(Texture texture, SpriteBatch sb) {
        switch (Mesa.dificultad) {
            case FACIL:

                sb.draw(texture, x + Mesa.ajustesMargenCartas[0], y + Mesa.ajustesMargenCartas[1], ancho, alto);

                break;
            case MEDIO:

                sb.draw(texture, x + Mesa.ajustesMargenCartas[2], y + Mesa.ajustesMargenCartas[3], ancho, alto);

                break;
            case DIFICIL:

                sb.draw(texture, x + Mesa.ajustesMargenCartas[4], y + Mesa.ajustesMargenCartas[5], ancho, alto);

                break;
        }
    }

    @Override
    public void actualizar() {

    }

    @Override
    public boolean colisiona(Entidad e) {
        return false;
    }

    public boolean isVisible() {
        return visible;
    }


    public Object getNumero() {
        return numero;
    }

    public void setEncontrada(boolean b) {
        encontrada = b;
    }

    public boolean getEncontrada() {
        return encontrada;
    }

    public boolean getSelectionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean b) {
        seleccionada = b;
    }

    public void setContarDelta(boolean b) {
        contarDelta = b;
    }

    public boolean getContarDelta() {
        return contarDelta;
    }
}
