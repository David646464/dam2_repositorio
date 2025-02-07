package io.github.proyecto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;

    @Override
    public void create() {
        // Crear la cámara
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Cargar el mapa
        map = new TmxMapLoader().load("maps/Mapa1Test.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        // Supongamos que el jugador tiene coordenadas x, y
        float playerX = 200;  // Simulación de la posición del jugador
        float playerY = 150;

        camera.position.set(playerX, playerY, 0);
        camera.update();

        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    @Override
    public void dispose() {
        map.dispose();
        mapRenderer.dispose();
    }

}
