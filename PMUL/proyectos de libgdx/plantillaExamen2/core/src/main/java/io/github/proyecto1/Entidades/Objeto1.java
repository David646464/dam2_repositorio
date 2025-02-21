package io.github.proyecto1.Entidades;

import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Interfaces.Entidad;
import io.github.proyecto1.Textures.TextureGetter;
import io.github.proyecto1.Util.Estados;

public class Objeto1 implements Entidad {
    public Estados.EstadoMovimiento estado = Estados.EstadoMovimiento.PARADO;
    public float x;
    public float y;
    public float ancho;
    public float alto;
    public Texture textura = TextureGetter.rojo();
    public float velocidad ;

    public Objeto1(float x, float y, float ancho, float alto, float velocidad) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.velocidad = velocidad;
    }

    @Override
    public boolean colisiona(Rectangle r) {
        return false;
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    @Override
    public void dibujar(SpriteBatch sb, float delta) {
        sb.draw(textura, x, y, ancho, alto);
    }

    @Override
    public void actualizar(float delta) {
        switch (estado) {
            case SUBIENDO:
                y += velocidad * delta;
                break;
            case BAJANDO:
                y -= velocidad * delta;
                break;
            case IZQUIERDA:
                x -= velocidad * delta;
                break;
            case DERECHA:
                x += velocidad * delta;
                break;
            case PARADO:
                break;
        }

    }

    @Override
    public boolean colisiona(Entidad e) {
        return false;
    }
}
