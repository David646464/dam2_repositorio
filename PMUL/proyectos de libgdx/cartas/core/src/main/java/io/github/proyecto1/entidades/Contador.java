package io.github.proyecto1.entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.interfaces.Entidad;

public class Contador implements Entidad {
    Texture texture = new Texture("UI_PixelArt_01/UI_SF_01.png");
    BitmapFont font = new BitmapFont(Gdx.files.internal("fuentes/fuente.fnt"), Gdx.files.internal("fuentes/fuente.png"), false);


    public Contador() {
        font.getData().setScale(3.0f); // Scale the font to be larger
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
        sb.draw(texture, 20, Mesa.alturaCamara - 100, 400, 80);

        // Dibujar los intentos
        font.draw(sb, "Intentos: " + Mesa.intentos, 30, Mesa.alturaCamara - 50);
    }

    @Override
    public void actualizar() {

    }

    @Override
    public boolean colisiona(Entidad e) {
        return  false;
    }


}
