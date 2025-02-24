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

    private static Texture blanco;

    public static Texture blanco() {
        if (blanco == null) {
            blanco = new Texture("Blanco.png");
        }
        return blanco;
    }

    private static void liberarBlanco(){
        blanco.dispose();
        blanco = null;
    }

    private static Texture equis;

    public static Texture equis() {
        if (equis == null) {
            equis = new Texture("Equis.png");
        }
        return equis;
    }

    private static void liberarEquis(){
        equis.dispose();
        equis = null;
    }

    private static Texture circulo;

    public static Texture circulo() {
        if (circulo == null) {
            circulo = new Texture("Circulo.png");
        }
        return circulo;
    }

    private static void liberarCirculo(){
        circulo.dispose();
        circulo = null;
    }
    private static Texture negro;

    public static Texture negro() {
        if (negro == null) {
            negro = new Texture("negro.png");
        }
        return negro;
    }

    private static void liberarNegro(){
        negro.dispose();
        negro = null;
    }

    private static Texture circuloRojo;

    public static Texture circuloRojo() {
        if (circuloRojo == null) {
            circuloRojo = new Texture("CirculoRojo.png");
        }
        return circuloRojo;
    }

    private static void liberarCirculoRojo(){
        circuloRojo.dispose();
        circuloRojo = null;
    }

    private static Texture circuloVerde;

    public static Texture circuloVerde() {
        if (circuloVerde == null) {
            circuloVerde = new Texture("CirculoVerde.png");
        }
        return circuloVerde;
    }

    private static void liberarCirculoVerde(){
        circuloVerde.dispose();
        circuloVerde = null;
    }
}
