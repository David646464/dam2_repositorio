package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Gdx;

import io.github.proyecto1.Mundo;
import io.github.proyecto1.Procesadores.ProcesadorDePantallaMenu;

public class PantallaJuego extends Pantalla{
    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(new ProcesadorDePantallaMenu());
    }

    @Override
    public void render(float delta) {
        Mundo.objeto1.actualizar(delta);
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
