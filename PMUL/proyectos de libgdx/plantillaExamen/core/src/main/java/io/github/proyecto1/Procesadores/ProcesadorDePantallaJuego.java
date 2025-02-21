package io.github.proyecto1.Procesadores;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import io.github.proyecto1.Mundo;
import io.github.proyecto1.Util.Estados;

public class ProcesadorDePantallaJuego extends InputAdapter {
    public ArrayList<Integer> TeclasPresionadas = new ArrayList<>();


    @Override
    public boolean keyDown(int keycode) {

        switch (keycode){
            case Input.Keys.SPACE:
                cambiarForma();
                break;
            case Input.Keys.P:
                Mundo.changeScreen(3);
                break;

        }

        if ( Input.Keys.W == keycode || Input.Keys.UP == keycode) {
            TeclasPresionadas.add(keycode);
            Mundo.personaje.estado = Estados.EstadoMovimiento.SUBIENDO;
        }else if ( Input.Keys.S == keycode || Input.Keys.DOWN == keycode){
            TeclasPresionadas.add(keycode);
            Mundo.personaje.estado = Estados.EstadoMovimiento.BAJANDO;
        }




        return false;
    }

    private void cambiarForma() {
        Mundo.personaje.nuevaForma();
    }

    @Override
    public boolean keyUp(int keycode) {

            if ( Input.Keys.W == keycode || Input.Keys.UP == keycode) {
                TeclasPresionadas.remove(Integer.valueOf(keycode));
                if (TeclasPresionadas.isEmpty()) {
                    Mundo.personaje.estado = Mundo.personaje.estado.PARADO;
                } else {
                    CambiarEstado(TeclasPresionadas.get(0));
                }

            }else if ( Input.Keys.S == keycode || Input.Keys.DOWN == keycode){
                TeclasPresionadas.remove(Integer.valueOf(keycode));
                if (TeclasPresionadas.isEmpty()) {
                    Mundo.personaje.estado = Mundo.personaje.estado.PARADO;
                } else {
                    CambiarEstado(TeclasPresionadas.get(0));
                }

            }

        return super.keyUp(keycode);

    }

    private void CambiarEstado(Integer integer) {
        switch (TeclasPresionadas.get(TeclasPresionadas.size() - 1)) {
            case Input.Keys.S:
                Mundo.personaje.estado = Mundo.personaje.estado.BAJANDO;
                break;
            case Input.Keys.W:
                Mundo.personaje.estado = Mundo.personaje.estado.SUBIENDO;
                break;
        }
    }
}
