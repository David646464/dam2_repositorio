package io.github.proyecto1.Procesadores;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import io.github.proyecto1.Mundo;

public class ProcesadorDePantallaMenu extends InputAdapter {
    public ArrayList<Integer> TeclasPresionadas = new ArrayList<>();

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Click");
        Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
        Mundo.camera.unproject(worldCoordinates);
        Rectangle mouse = new Rectangle(worldCoordinates.x, worldCoordinates.y, 1, 1);
        if (Mundo.boton.colisiona(mouse)) {
            Mundo.boton.ejecutarAccion();
            if (Mundo.boton.isApretado()) {
                Mundo.boton.setApretado(false);
            } else {
                Mundo.boton.setApretado(true);
            }
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                TeclasPresionadas.add(keycode);
                Mundo.objeto1.estado = Mundo.objeto1.estado.SUBIENDO;
                break;
            case Input.Keys.S:
                TeclasPresionadas.add(keycode);
                Mundo.objeto1.estado = Mundo.objeto1.estado.BAJANDO;
                break;
            case Input.Keys.A:
                TeclasPresionadas.add(keycode);
                Mundo.objeto1.estado = Mundo.objeto1.estado.IZQUIERDA;
                break;
            case Input.Keys.D:
                TeclasPresionadas.add(keycode);
                Mundo.objeto1.estado = Mundo.objeto1.estado.DERECHA;
                break;
        }
        System.out.println("Key down" + keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                TeclasPresionadas.remove(Integer.valueOf(keycode));
                if (TeclasPresionadas.isEmpty()) {
                    Mundo.objeto1.estado = Mundo.objeto1.estado.PARADO;
                } else {
                    CambiarEstado(TeclasPresionadas.get(0));
                }
                break;
            case Input.Keys.S:
                TeclasPresionadas.remove(Integer.valueOf(keycode));
                if (TeclasPresionadas.isEmpty()) {
                    Mundo.objeto1.estado = Mundo.objeto1.estado.PARADO;
                } else {
                    CambiarEstado(TeclasPresionadas.get(0));
                }
                break;
            case Input.Keys.A:
                TeclasPresionadas.remove(Integer.valueOf(keycode));
                if (TeclasPresionadas.isEmpty()) {
                    Mundo.objeto1.estado = Mundo.objeto1.estado.PARADO;
                } else {
                    CambiarEstado(TeclasPresionadas.get(0));
                }
                break;
            case Input.Keys.D:
                TeclasPresionadas.remove(Integer.valueOf(keycode));
                if (TeclasPresionadas.isEmpty()) {
                    Mundo.objeto1.estado = Mundo.objeto1.estado.PARADO;
                } else {
                    CambiarEstado(TeclasPresionadas.get(0));
                }
                break;
        }
        return super.keyUp(keycode);

    }

    private void CambiarEstado(Integer integer) {
        switch (TeclasPresionadas.get(TeclasPresionadas.size() - 1)) {
            case Input.Keys.S:
                Mundo.objeto1.estado = Mundo.objeto1.estado.BAJANDO;
                break;
            case Input.Keys.A:
                Mundo.objeto1.estado = Mundo.objeto1.estado.IZQUIERDA;
                break;
            case Input.Keys.D:
                Mundo.objeto1.estado = Mundo.objeto1.estado.DERECHA;
                break;
            case Input.Keys.W:
                Mundo.objeto1.estado = Mundo.objeto1.estado.SUBIENDO;
                break;
        }
    }
}
