package io.github.proyecto1.Textures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.proyecto1.Mundo;

public class TextureManager {
    public static BitmapFont fuente = TextureGetter.fontBoton();
    public static void renderScene(SpriteBatch batch, float delta) {
        fuente.getData().setScale(3.0f);
        batch.begin();
        switch (Mundo.numScreen) {
            case 0:
                break;
            case 1:
                batch.draw(TextureGetter.amarillo(),0, Mundo.alturaCamara / 2,Mundo.anchoCamara,Mundo.alturaCamara);
                batch.draw(TextureGetter.verde(),0, 0,Mundo.anchoCamara,Mundo.alturaCamara / 2);
                fuente.draw(batch, "Jugar(numero de 1 al 9)", Mundo.anchoCamara / 2 -200, (Mundo.alturaCamara / 4) + (Mundo.alturaCamara / 2));
                break;
            case 2:
                break;
            case 3:
                break;

        }
        batch.end();
    }
}
