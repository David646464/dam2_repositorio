package io.github.proyecto1.Entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Interfaces.Entidad;
import io.github.proyecto1.Mundo;
import io.github.proyecto1.Textures.TextureGetter;
import io.github.proyecto1.Util.Estados;

public class Personaje implements Entidad {
    public Estados.EstadoMovimiento estado = Estados.EstadoMovimiento.PARADO;
    public float x;
    public float y;
    public float ancho;
    public float alto;
    public Texture textura = TextureGetter.blanco();
    public float velocidad;
    public float TamañoMaximo = 200;
    public float TamañoMinimo = 50;
    public float CantidadASubir = 30;
    public boolean Aumentando = true;
    public float limiteArriba = Mundo.alturaCamara;
    public float limiteAbajo = 100;
    public int formaActual = 1;


    public Personaje(float x, float y, float ancho, float alto, float velocidad) {
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

        Rectangle rectangle = new Rectangle(x, y, ancho, alto);

        return rectangle;
    }

    @Override
    public void dibujar(SpriteBatch sb, float delta) {
        sb.draw(textura, x - (ancho / 2), y, ancho, alto);
    }

    @Override
    public void actualizar(float delta) {

        switch (estado) {
            case SUBIENDO:
                if (y < limiteArriba - alto)
                    y += velocidad * delta;
                break;
            case BAJANDO:
                if (y > limiteAbajo)
                    y -= velocidad * delta;
                break;
            case PARADO:
                break;
        }
        if (Aumentando) {
            ancho += CantidadASubir * delta;
            alto += CantidadASubir * delta;
            if (ancho > TamañoMaximo) {
                Aumentando = false;
            }
        } else {
            ancho -= CantidadASubir * delta;
            alto -= CantidadASubir * delta;
            if (ancho < TamañoMinimo) {
                Aumentando = true;
            }
        }

    }

    @Override
    public boolean colisiona(Entidad e) {
        if (getRectangle().overlaps(e.getRectangle())){
            if (tieneQueColisionar(e)) {
                return true;
            }
        }
        return false;
    }

    public void nuevaForma() {
        switch (formaActual) {
            case 1:
                textura = TextureGetter.circulo();
                formaActual = 2;
                break;
            case 2:
                textura = TextureGetter.equis();
                formaActual = 3;
                break;
            case 3:
                textura = TextureGetter.blanco();
                formaActual = 1;
                break;
        }

    }

    private boolean tieneQueColisionar(Entidad entidad) {

        if (entidad instanceof Cuadrado) {
             Cuadrado cuadrado = ((Cuadrado) entidad);
            if (!cuadrado.colisiono){
                cuadrado.colisiono = true;
                return true;
            }

        } else if (entidad instanceof Circulo) {
            Circulo circulo = ((Circulo) entidad);
            if (!circulo.colisiono){
                circulo.colisiono = true;
                return true;
            }

        } else if (entidad instanceof Equis) {
            Equis equis = ((Equis) entidad);
            if (!equis.colisiono){
                equis.colisiono = true;
                return true;
            }

        }
        return false;
    }
}
