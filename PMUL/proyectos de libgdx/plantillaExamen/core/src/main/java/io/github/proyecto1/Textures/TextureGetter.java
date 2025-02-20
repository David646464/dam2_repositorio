package io.github.proyecto1.Textures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class TextureGetter {
    private static Texture textureFondoBoton;

    public static Texture getTextureFondoBoton() {
        if (textureFondoBoton == null) {
            textureFondoBoton = new Texture("UI_PixelArt_01/UI_SF_01.png");
        }
        return textureFondoBoton;
    }

    private static Texture textureFondoBotonDark;

    public static Texture textureFondoBotonDark() {
        if (textureFondoBotonDark == null) {
            textureFondoBotonDark = new Texture("UI_PixelArt_01/UI_SF_01_dark.png");
        }
        return textureFondoBotonDark;
    }

    private static BitmapFont fontBoton;

    public static BitmapFont fontBoton() {
        if (fontBoton == null) {
            fontBoton =new BitmapFont(Gdx.files.internal("fuentes/fuente.fnt"), Gdx.files.internal("fuentes/fuente.png"), false);
        }
        return fontBoton;
    }
}
