package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.Member;

import io.github.proyecto1.Manejadores.ProcesadorDeEntradaJuego;
import io.github.proyecto1.Manejadores.ProcesadorDeRecords;
import io.github.proyecto1.Mesa;

public class PantallaRecords extends Pantalla{
    @Override
    public void show() {
        Mesa.nuevoRecords();

        super.show();
        Gdx.input.setInputProcessor(new ProcesadorDeRecords());
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
