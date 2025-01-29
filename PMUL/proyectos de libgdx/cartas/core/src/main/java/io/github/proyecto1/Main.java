package io.github.proyecto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.proyecto1.Manejadores.ProcesadorDeEntrada;
import io.github.proyecto1.Manejadores.TextureManager;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private OrthographicCamera camera;
    private TextureManager tm;
    ShapeRenderer sr;
    private float delta ;





    @Override
    public void create() {
        camera = new OrthographicCamera();
        sr = new ShapeRenderer();
        batch = new SpriteBatch();
        camera = Mesa.camera;
        tm = new TextureManager();
        Gdx.input.setInputProcessor(new ProcesadorDeEntrada());
    }

    @Override
    public void render() {
        delta = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(camera.combined);
        tm.renderScene(batch,delta);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, Mesa.anchoCamara, Mesa.alturaCamara);
        batch.setProjectionMatrix(camera.combined);
        sr.setProjectionMatrix(camera.combined);

    }
}
