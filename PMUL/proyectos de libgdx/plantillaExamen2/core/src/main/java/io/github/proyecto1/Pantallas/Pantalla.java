package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.proyecto1.Mundo;
import io.github.proyecto1.Textures.TextureManager;

public class Pantalla implements com.badlogic.gdx.Screen {
    private OrthographicCamera camera = Mundo.camera;
    private ShapeRenderer sr = new ShapeRenderer();
    private SpriteBatch batch = new SpriteBatch() ;
    private TextureManager textureManager = Mundo.textureManager;

    @Override
    public void show() {
        if (Mundo.textureManager == null) {
            Mundo.textureManager = new TextureManager();
        }
        textureManager = Mundo.textureManager;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(camera.combined);
        textureManager.renderScene(batch, delta);

    }
    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Mundo.anchoCamara, Mundo.alturaCamara);
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
