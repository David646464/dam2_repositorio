package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Gdx;

import io.github.proyecto1.Manejadores.ProcesadorDeEntradaInicio;
import io.github.proyecto1.Mesa;

public class PantallaInicio extends Pantalla {

    @Override
    public void show() {
        Mesa.nuevoInicio();
        super.show();
        Gdx.input.setInputProcessor(new ProcesadorDeEntradaInicio());
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
