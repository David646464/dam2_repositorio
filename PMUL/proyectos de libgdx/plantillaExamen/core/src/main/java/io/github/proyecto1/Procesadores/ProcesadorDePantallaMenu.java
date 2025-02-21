package io.github.proyecto1.Procesadores;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import io.github.proyecto1.Mundo;
import io.github.proyecto1.Util.GuardadorDePreferencias;

public class ProcesadorDePantallaMenu extends InputAdapter {
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.NUM_1:
                Mundo.numColisiones = 1;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_2:
                Mundo.numColisiones = 2;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_3:
                Mundo.numColisiones = 3;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_4:
                Mundo.numColisiones = 4;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_5:
                Mundo.numColisiones = 5;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_6:
                Mundo.numColisiones = 6;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_7:
                Mundo.numColisiones = 7;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_8:
                Mundo.numColisiones = 8;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.NUM_9:
                Mundo.numColisiones = 9;
                Mundo.changeScreen(2);
                break;
            case Input.Keys.R:
                GuardadorDePreferencias.resetRecords();
                break;

        }
        return super.keyDown(keycode);
    }
}
