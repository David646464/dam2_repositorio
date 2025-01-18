package io.github.borrame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

public class ProcesadorDeEntrada extends InputAdapter {
    Personaje personaje;
    ArrayList<Integer> teclasPulsadas = new ArrayList<>();

    public ProcesadorDeEntrada(Personaje personaje) {
        this.personaje = personaje;
    }


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            personaje.izquierda();
            teclasPulsadas.add(keycode);
        } else if (keycode == Input.Keys.RIGHT) {
            personaje.derecha();
            teclasPulsadas.add(keycode);
        } else if (keycode == Input.Keys.UP) {
            personaje.subirAnzuelo();
            teclasPulsadas.add(keycode);
        } else if (keycode == Input.Keys.DOWN) {
            personaje.bajarAnzuelo();
            teclasPulsadas.add(keycode);
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            teclasPulsadas.remove(Integer.valueOf(keycode));
            if (teclasPulsadas.contains(Input.Keys.RIGHT)) {
                personaje.derecha();
            } else {
                personaje.parado();
            }
        } else if (keycode == Input.Keys.RIGHT) {
            teclasPulsadas.remove(Integer.valueOf(keycode));
            if (teclasPulsadas.contains(Input.Keys.LEFT)) {
                personaje.izquierda();
            } else {
                personaje.parado();
            }
        } else if (keycode == Input.Keys.UP) {
            teclasPulsadas.remove(Integer.valueOf(keycode));
            if (teclasPulsadas.contains(Input.Keys.DOWN)) {
                personaje.bajarAnzuelo();
            } else {
                personaje.pararAnzuelo();
            }
        } else if (keycode == Input.Keys.DOWN) {
            teclasPulsadas.remove(Integer.valueOf(keycode));
            if (teclasPulsadas.contains(Input.Keys.UP)) {
                personaje.subirAnzuelo();
            } else {
                personaje.pararAnzuelo();
            }

        }

        return true;
    }
}
