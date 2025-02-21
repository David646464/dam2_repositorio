package io.github.proyecto1.Procesadores;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import io.github.proyecto1.Mundo;
import io.github.proyecto1.Util.Estados;

public class ProcesadorDePantallaPausa extends InputAdapter {


    @Override
    public boolean keyDown(int keycode) {


           Mundo.changeScreen(2);
       


        return false;
    }


}
