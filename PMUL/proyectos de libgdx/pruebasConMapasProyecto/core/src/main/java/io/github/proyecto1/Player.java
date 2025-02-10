package io.github.proyecto1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Texture texture;
    private Vector2 position;

    public Player(String texturePath, float x, float y) {
        texture = new Texture(texturePath);
        System.out.println(x + " " + y);
        position = new Vector2(x  , y - texture.getHeight());
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }

    public void move(float x, float y) {
        position.add(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }
}
