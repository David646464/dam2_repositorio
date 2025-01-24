package io.github.borrame.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import io.github.borrame.Entidades.Barra;
import io.github.borrame.Entidades.Mundo;
import io.github.borrame.Entidades.Personaje;

public class TextureManager {

    public static TextureManager instance;
    public static Texture background = new Texture("graficos/fondo.jpg");
    public Personaje personaje;
    public Barra barra;
    private TextureAtlas atlas;
    public TextureRegion pescador;
    public TextureRegion pezAmarillo;
    public TextureRegion pezLila;
    public TextureRegion pezAzul;
    public TextureRegion anzuelo;
    public TextureRegion punto;

    public TextureManager() {
        instance = this;
        loadAtlas();
    }

    public static Texture paintBackground(SpriteBatch sb) {
        sb.draw(background, 0, 0, Mundo.Width, Mundo.Height);
        return background;
    }

    public void addPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void renderScene(SpriteBatch sb) {
        paintBackground(sb);
        personaje.dibujaSedal(sb, punto);
        sb.setColor(1, 1, 1, 1); // Color blanco sólido
        sb.draw(pescador, personaje.x, personaje.y, 150, 200);
        sb.setColor(1, 1, 1, 1); // Restablecer el color a blanco

        barra.dibuja(sb);
        personaje.dibuja(sb, pescador);
        personaje.dibujaAnzuelo(sb, anzuelo);

    }

    private void loadAtlas() {
        atlas = new TextureAtlas(Gdx.files.internal("graficos/atlas.atlas"));
        pescador = atlas.findRegion("pescador");
        pezAmarillo = atlas.findRegion("pez_amarillo");
        pezLila = atlas.findRegion("pez_lila");
        pezAzul = atlas.findRegion("pezAzul");
        anzuelo = atlas.findRegion("anzuelo");
        punto = atlas.findRegion("punto");
    }

    public void dispose() {
        atlas.dispose();
    }

    public static TextureManager getInstance() {
        return instance;
    }

    public void GirarPescador(boolean flipX) {
        if (pescador.isFlipX() != flipX) {
            pescador.flip(true, false);

        }
    }

    public void GirarAnzuelo(boolean flipX) {
        if (anzuelo.isFlipX() != flipX) {
            anzuelo.flip(true, false);

        }
    }

    public TextureRegion getRandFish() {
        int rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                return pezAmarillo;
            case 1:
                return pezLila;
            case 2:
                return pezAzul;
            default:
                return pezAzul;
        }
    }

    public void addBarra(Barra barra) {
        this.barra = barra;
    }
}
