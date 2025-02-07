package io.github.proyecto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private SpriteBatch batch;
    private Player player;
    private AssetManager manager;

    @Override
    public void create() {
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("maps/mapa1.tmx", TiledMap.class);
        manager.finishLoading();

        map = manager.get("maps/mapa1.tmx", TiledMap.class);
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        // Calcula las dimensiones del mapa
        int mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        int mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);

        // Configura la cámara para que se ajuste al mapa
        camera = new OrthographicCamera();
        System.out.println(mapWidth + " " + mapHeight);
        camera.setToOrtho(false, mapWidth, mapHeight); // Tamaño de la ventana
        camera.position.set(mapWidth / 2f, mapHeight / 2f, 0); // Centra la cámara en el mapa
        camera.update();

        batch = new SpriteBatch();

        // Cargar la posición del objeto player desde el TiledMap
        MapObjects objects = map.getLayers().get("Capa de Objetos 1").getObjects();
        for (MapObject object : objects) {
            if (object instanceof RectangleMapObject) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();
                if ("player".equals(object.getProperties().get("name"))) {
                    float playerX = rect.x;
                    float playerY = rect.y;
                    player = new Player("Pixel Art Top Down - Basic v1.1.2/Texture/TX Player.png", playerX, playerY);
                    break;
                }
            }
        }

        if (player == null) {
            Gdx.app.log("DEBUG", "Player not found in the map.");
        }
    }


    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render();

        handleInput(Gdx.graphics.getDeltaTime());

        batch.begin();
        player.render(batch);
        batch.end();
    }

    private void handleInput(float deltaTime) {
        float moveSpeed = 200 * deltaTime;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.move(0, moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.move(0, -moveSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.move(-moveSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.move(moveSpeed, 0);
        }
    }

    @Override
    public void dispose() {
        map.dispose();
        mapRenderer.dispose();
        batch.dispose();
        player.dispose();
        manager.dispose();
    }
}
