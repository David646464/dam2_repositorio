package io.github.proyecto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.proyecto1.Procesadores.ProcesadorDePantalla1;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Game extends com.badlogic.gdx.Game {
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        Mundo.changeScreen(1);
    }

    @Override
    public void render() {
        Mundo.pantallaActual.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
      Mundo.pantallaActual.dispose();
    }

    @Override
    public void resize(int width, int height) {
        Mundo.pantallaActual.resize(width, height);
    }

}
