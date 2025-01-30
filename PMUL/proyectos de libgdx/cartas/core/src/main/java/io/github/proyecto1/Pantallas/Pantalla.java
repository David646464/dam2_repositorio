package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.proyecto1.Manejadores.TextureManager;
import io.github.proyecto1.Mesa;

public class Pantalla implements Screen {

    private OrthographicCamera camera = Mesa.camera;
    private ShapeRenderer sr = new ShapeRenderer();
    private SpriteBatch batch = new SpriteBatch() ;
    private TextureManager tm =   Mesa.tm;

    @Override
    public void show() {
        if (Mesa.tm == null) {
            Mesa.tm = new TextureManager();
        }
        tm = Mesa.tm;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(camera.combined);
        tm.renderScene(batch, delta);

    }
    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Mesa.anchoCamara, Mesa.alturaCamara);
        batch.setProjectionMatrix(camera.combined);
        sr.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
