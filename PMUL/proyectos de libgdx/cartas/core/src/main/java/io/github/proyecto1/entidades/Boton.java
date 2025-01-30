package io.github.proyecto1.entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.interfaces.AccionBoton;
import io.github.proyecto1.interfaces.Entidad;

public class Boton implements Entidad {
    private Texture textureFondoBoton = new Texture("UI_PixelArt_01/UI_SF_01.png");
    private Texture textureFondoBotonDark = new Texture("UI_PixelArt_01/UI_SF_01_dark.png");
    BitmapFont font = new BitmapFont(Gdx.files.internal("fuentes/fuente.fnt"), Gdx.files.internal("fuentes/fuente.png"), false);
    private String nombre;
    private float x;
    private float y;
    private float ancho;
    private float alto;
    private String texto;
    private AccionBoton accion;
    private boolean apretado = false;

    public Boton(String nombre, float x, float y, float ancho, float alto, String texto, AccionBoton accion) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.texto = texto;
        this.accion = accion;
        font.getData().setScale(3.0f);
    }

    public boolean isApretado() {
        return apretado;
    }

    public void setApretado(boolean apretado) {
        this.apretado = apretado;
    }

    public String getNombre() {
        return nombre;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getAncho() {
        return ancho;
    }

    public float getAlto() {
        return alto;
    }

    @Override
    public boolean colisiona(Rectangle r) {
       Rectangle rectangulo = new Rectangle(x, y, ancho, alto);
         return rectangulo.overlaps(r);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, ancho, alto);
    }


    @Override
    public void dibujar(SpriteBatch sb, float delta) {
        if (apretado) {
            sb.draw(textureFondoBotonDark, x, y, ancho, alto);
        } else {
            sb.draw(textureFondoBoton, x, y, ancho, alto);
        }
        font.draw(sb, texto, x + 10, y + 50);
    }

    @Override
    public void actualizar() {
    }

    @Override
    public boolean colisiona(Entidad e) {
        return false;
    }

    public void ejecutarAccion() {
        if (accion != null) {
            accion.ejecutar();
        }
    }
}
