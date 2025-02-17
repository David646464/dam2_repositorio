package io.github.proyecto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {





    @Override
    public void create() {
        Mesa.getScreen().show();
    }

    @Override
    public void render() {
        Mesa.getScreen().render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        Mesa.getScreen().dispose();
    }

    @Override
    public void resize(int width, int height) {
        Mesa.getScreen().resize(width, height);

    }






}
