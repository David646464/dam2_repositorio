package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Gdx;

import io.github.proyecto1.Procesadores.ProcesadorDePantallaMenu;

public class PantallaMenu extends Pantalla{
    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(new ProcesadorDePantallaMenu());
    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
