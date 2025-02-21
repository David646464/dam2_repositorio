package io.github.proyecto1.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

import io.github.proyecto1.Entidades.Circulo;
import io.github.proyecto1.Entidades.Cuadrado;
import io.github.proyecto1.Entidades.Equis;
import io.github.proyecto1.Interfaces.Entidad;
import io.github.proyecto1.Mundo;
import io.github.proyecto1.Procesadores.ProcesadorDePantallaJuego;
import io.github.proyecto1.Util.GuardadorDePreferencias;

public class PantallaJuego extends Pantalla {
    private float stateTime;


    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(new ProcesadorDePantallaJuego());
    }

    @Override
    public void render(float delta) {
        stateTime += delta;
        Mundo.stateTime2 += delta;
        Mundo.personaje.actualizar(delta);
        for (int i = 0; i < Mundo.enemigos.size(); i++) {
            Mundo.enemigos.get(i).actualizar(delta);
        }
        for (int i = 0; i < Mundo.enemigos.size(); i++) {

            if (tieneQueColisionar(Mundo.enemigos.get(i))) {
                if (Mundo.personaje.colisiona(Mundo.enemigos.get(i))) {
                    Mundo.numVecesColisionado++;
                    if (Mundo.numVecesColisionado >= Mundo.numColisiones) {
                        Mundo.desactivarEnemigos();
                        GuardadorDePreferencias.guardarRecord(Mundo.stateTime2, Mundo.numColisiones);
                        Mundo.changeScreen(1);
                    }
                }
            }
        }


        if (stateTime > Mundo.tiempoGeneracion) {
            agregarEnemigo();
            stateTime = 0;
        }

        super.render(delta);

    }

    private boolean tieneQueColisionar(Entidad entidad) {
        if (entidad instanceof Cuadrado) {
            return !(Mundo.personaje.formaActual == 1);
        } else if (entidad instanceof Circulo) {
            return !(Mundo.personaje.formaActual == 2);
        } else if (entidad instanceof Equis) {
            return !(Mundo.personaje.formaActual == 3);
        }
        return false;
    }

    private void agregarEnemigo() {
        int EnemigoAleatoriio = (int) MathUtils.random(1, 3);
        if (activarEnemigoDesactivado()) {
            switch (EnemigoAleatoriio) {
                case 1:
                    Mundo.enemigos.add(new Cuadrado());
                    break;
                case 2:
                    Mundo.enemigos.add(new Equis());
                    break;
                case 3:
                    Mundo.enemigos.add(new Circulo());
                    break;

            }
        }

    }

    private boolean activarEnemigoDesactivado() {
        for (int i = 0; i < Mundo.enemigos.size(); i++) {
            Entidad entidad = Mundo.enemigos.get(i);
            if (entidad instanceof Cuadrado) {
                Cuadrado cuadrado = ((Cuadrado) entidad);
                if (cuadrado.desactivado) {
                    cuadrado.reset();

                    return false;
                }

            } else if (entidad instanceof Circulo) {
                Circulo circulo = ((Circulo) entidad);
                if (circulo.desactivado) {
                    circulo.reset();


                    return false;
                }

            } else if (entidad instanceof Equis) {
                Equis equis = ((Equis) entidad);
                if (equis.desactivado) {
                    equis.reset();


                    return false;
                }


            }

        }
        return true;
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
