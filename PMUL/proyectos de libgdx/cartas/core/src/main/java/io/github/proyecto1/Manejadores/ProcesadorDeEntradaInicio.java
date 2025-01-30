package io.github.proyecto1.Manejadores;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import io.github.proyecto1.Main;
import io.github.proyecto1.Mesa;
import io.github.proyecto1.entidades.Boton;

public class ProcesadorDeEntradaInicio extends InputAdapter {

    public ProcesadorDeEntradaInicio() {
    }



    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
        Mesa.camera.unproject(worldCoordinates);
        Rectangle mouse = new Rectangle(worldCoordinates.x, worldCoordinates.y, 1, 1);
        for (Boton boton : Mesa.botonesInicio) {
            if (boton.colisiona(mouse)) {
                boton.setApretado(true);
                boton.ejecutarAccion();
            } else {
                boton.setApretado(false);
            }
        }
        return true;
    }


}
