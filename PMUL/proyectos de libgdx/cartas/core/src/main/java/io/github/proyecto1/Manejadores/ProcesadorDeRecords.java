package io.github.proyecto1.Manejadores;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.entidades.Boton;

public class ProcesadorDeRecords extends InputAdapter {

    public ProcesadorDeRecords() {
    }


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == com.badlogic.gdx.Input.Keys.R){
            Mesa.setScreen(0);
        }
        return true;
    }
}
