package io.github.proyecto1.Textures;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.proyecto1.Mundo;

public class TextureManager {

    public static void renderScene(SpriteBatch batch, float delta) {
        batch.begin();
        switch (Mundo.numScreen) {
            case 0:
                break;
            case 1:
                Mundo.boton.dibujar(batch, delta);
                break;
            case 2:
                break;
            case 3:
                break;

        }
        batch.end();
    }
}
