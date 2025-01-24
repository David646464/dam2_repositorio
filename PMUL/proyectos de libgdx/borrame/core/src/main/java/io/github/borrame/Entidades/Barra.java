package io.github.borrame.Entidades;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.borrame.Managers.TextureManager;

public class Barra {
    public float width = 350; // Asegúrate de que el ancho no sea cero
    public float height = 20; // Asegúrate de que el alto no sea cero
    public float x = 70; // Posición en x
    public float y = Mundo.Height -20; // Posición en y
    public float currentWidth = 350;
    public float currentHeight;

    private Texture barra;

    public Barra() {
        // Carga la textura en el constructor
        barra = new Texture("Barra.png");
    }

    public void dibuja(SpriteBatch sb) {
        Color color;
        float porcentaje = currentWidth / width;
        if (porcentaje <= 0.3f) {
            color = Color.RED;
        } else if (porcentaje <= 0.6f) {
            color = Color.YELLOW;
        } else {
            color = Color.GREEN;
        }

        sb.setColor(Color.BLACK);; // Asegúrate de que el SpriteBatch esté iniciado
        sb.draw(barra, x, y, width, height);
        sb.setColor(color);
        sb.draw(barra, x, y, currentWidth, height);
        sb.setColor(Color.WHITE);
    }

    public void dispose() {
        // Libera la textura cuando ya no se necesite
        barra.dispose();
    }
    public void restarTamaño(float delta) {
       if (currentWidth > 0) {
           this.currentWidth -= width * delta;
           System.out.println(Mundo.tiempo);
       }else{
           currentWidth = 0;
       }
    }
}
