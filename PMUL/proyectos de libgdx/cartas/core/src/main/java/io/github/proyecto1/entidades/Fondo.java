package io.github.proyecto1.entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.interfaces.Entidad;

public class Fondo implements Entidad {
    private Texture texture = new Texture("fondo.png");

    public Fondo() {

    }

    @Override
    public void colisiona(Rectangle r) {

    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    @Override
    public void dibujar(SpriteBatch sb, float delta) {
        sb.draw(texture, 0, 0, Mesa.anchoCamara,Mesa.alturaCamara);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void colisiona(Entidad e) {

    }
}
