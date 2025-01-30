package io.github.proyecto1.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;

public interface Entidad {
    public void colisiona(Rectangle r);
    public Rectangle getRectangle();
    public  void dibujar(SpriteBatch sb, float delta);
    public void actualizar();
    public void colisiona(Entidad e);

}
