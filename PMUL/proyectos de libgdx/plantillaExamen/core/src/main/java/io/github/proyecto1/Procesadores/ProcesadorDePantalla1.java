package io.github.proyecto1.Procesadores;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import io.github.proyecto1.Entidades.Boton;
import io.github.proyecto1.Mundo;

public class ProcesadorDePantalla1 extends InputAdapter {

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Click");
        Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
        Mundo.camera.unproject(worldCoordinates);
        Rectangle mouse = new Rectangle(worldCoordinates.x, worldCoordinates.y, 1, 1);
       if (Mundo.boton.colisiona(mouse)) {
            Mundo.boton.ejecutarAccion();
            if (Mundo.boton.isApretado()){
                Mundo.boton.setApretado(false);
            }else{
                Mundo.boton.setApretado(true);
            }
        }
        return true;
    }

}
