package io.github.borrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Personaje {
    float x,y;
    final float VELOCIDAD = 40 ;



    enum Estado {
        IZQUIERDA,DERECHA,PARADO
    }
    Estado estado;

    public Personaje() {
        x=100;
        y=0;
        estado=Estado.PARADO;
    }

    public void actualiza() {
        switch (estado) {
            case IZQUIERDA:{
                if (x >= 0 )
                x-= VELOCIDAD * Gdx.graphics.getDeltaTime();

                break;}
            case DERECHA:{
                if ( x <= Gdx.graphics.getWidth()-150)
                x+= VELOCIDAD * Gdx.graphics.getDeltaTime();

                break;}

        }
    }

    public void dibuja(SpriteBatch sb, Texture textura) {
        sb.draw(textura,x,y,150,200);
    }

    public void izquierda() { estado=Estado.IZQUIERDA;}
    public void derecha() { estado=Estado.DERECHA; }
    public void parado() { estado=Estado.PARADO; }
}
