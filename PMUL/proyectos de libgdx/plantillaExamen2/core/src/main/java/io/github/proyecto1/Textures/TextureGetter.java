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

    private static void liberarTextureFondoBoton(){
        textureFondoBoton.dispose();
        textureFondoBoton = null;
    }

    private static Texture textureFondoBotonDark;

    public static Texture textureFondoBotonDark() {
        if (textureFondoBotonDark == null) {
            textureFondoBotonDark = new Texture("UI_PixelArt_01/UI_SF_01_dark.png");
        }
        return textureFondoBotonDark;
    }

    private static void liberarTextureFondoBotonDark(){
        textureFondoBotonDark.dispose();
        textureFondoBotonDark = null;
    }

    private static BitmapFont fontBoton;

    public static BitmapFont fontBoton() {
        if (fontBoton == null) {
            fontBoton =new BitmapFont(Gdx.files.internal("fuentes/fuente.fnt"), Gdx.files.internal("fuentes/fuente.png"), false);
        }
        return fontBoton;
    }

    private static void liberarFontBoton(){
        fontBoton.dispose();
        fontBoton = null;
    }

    private static Texture rojo;

    public static Texture rojo() {
        if (rojo == null) {
            rojo = new Texture("rojo.png");
        }
        return rojo;
    }

    private static void liberarRojo(){
        rojo.dispose();
        rojo = null;
    }


    private static Texture amarillo;

    public static Texture amarillo() {
        if (amarillo == null) {
            amarillo = new Texture("amarillo.png");
        }
        return amarillo;
    }

    private static void liberarAmarillo(){
        amarillo.dispose();
        amarillo = null;
    }
    private static Texture verde;

    public static Texture verde() {
        if (verde == null) {
            verde = new Texture("verde.png");
        }
        return verde;
    }

    private static void liberarVerde(){
        verde.dispose();
        verde = null;
    }
}
