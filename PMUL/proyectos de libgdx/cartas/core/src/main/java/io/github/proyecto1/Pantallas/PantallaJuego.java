package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Gdx;
import io.github.proyecto1.Manejadores.ProcesadorDeEntradaJuego;
import io.github.proyecto1.Mesa;

public class PantallaJuego extends Pantalla {

    @Override
    public void show() {
        super.show();
        Mesa.nuevaMesa();
        Gdx.input.setInputProcessor(new ProcesadorDeEntradaJuego());
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
