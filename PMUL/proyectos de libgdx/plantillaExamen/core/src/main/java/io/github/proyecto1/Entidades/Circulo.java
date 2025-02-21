package io.github.proyecto1.Entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Interfaces.Entidad;
import io.github.proyecto1.Mundo;
import io.github.proyecto1.Textures.TextureGetter;
import io.github.proyecto1.Util.Estados;

public class Circulo implements Entidad {

    public Estados.EstadoMovimiento estado = Estados.EstadoMovimiento.IZQUIERDA;
    public float x;
    public float y;
    public float ancho = 25;
    public float alto = 25;
    public Texture textura = TextureGetter.circulo();
    public float velocidad = 300;
    public float limiteIzq = 0;
    public float limiteDer = Mundo.anchoCamara;
    public int numRebotes = MathUtils.random(1, 4);
    public boolean colisiono = false;
    public boolean desactivado = false;

    public Circulo() {
        int numAleatorio = (int) MathUtils.random(1, 2);
        if (numAleatorio == 2) {
            estado = Estados.EstadoMovimiento.DERECHA;
            x = 0 - ancho;
        } else {
            x = Mundo.anchoCamara;
        }
        float yAleatoria = MathUtils.random(100, Mundo.alturaCamara - alto);
        y = yAleatoria;
    }

    @Override
    public boolean colisiona(Rectangle r) {
        return false;
    }

    @Override
    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(x, y, ancho, alto);

        return rectangle;
    }

    @Override
    public void dibujar(SpriteBatch sb, float delta) {
        if (!desactivado)
            sb.draw(textura, x, y, ancho, alto);
    }

    @Override
    public void actualizar(float delta) {
        if (!desactivado) {
            if (estado == Estados.EstadoMovimiento.IZQUIERDA) {
                if (numRebotes > 0) {
                    if (x > limiteDer) {
                        x -= velocidad * delta;
                    } else {
                        estado = Estados.EstadoMovimiento.DERECHA;
                        numRebotes--;
                        if (numRebotes <= 1) {
                            textura = TextureGetter.circuloRojo();
                        }
                    }
                } else {
                    if (x > limiteIzq - ancho) {
                        x -= velocidad * delta;
                    } else {
                        desactivado = true;
                    }
                }
            } else {
                if (numRebotes > 0) {
                    if (x < Mundo.anchoCamara - ancho) {
                        x += velocidad * delta;
                    } else {
                        estado = Estados.EstadoMovimiento.IZQUIERDA;
                        numRebotes--;
                        if (numRebotes <= 1) {
                            textura = TextureGetter.circuloRojo();
                        }
                    }
                } else {
                    if (x < Mundo.anchoCamara) {
                        x += velocidad * delta;
                    } else {
                        desactivado = true;
                    }
                }
            }
        }
    }

    @Override
    public boolean colisiona(Entidad e) {
        return false;
    }

    public void reset() {
        System.out.println("Circulo reaprovechada");
        desactivado = false;
        int numAleatorio = (int) MathUtils.random(1, 2);
        if (numAleatorio == 2) {
            estado = Estados.EstadoMovimiento.DERECHA;
            x = 0 - ancho;
        } else {
            x = Mundo.anchoCamara;
        }
        float yAleatoria = MathUtils.random(100, Mundo.alturaCamara - alto);
        y = yAleatoria;
        colisiono = false;

    }
}
