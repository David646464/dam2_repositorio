package io.github.proyecto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private BitmapFont font;
    private int color = 0;
    private int number = 0;
    private float timeElapsed = 0;
    private float timeElapsedBefore = 0;
    private boolean yaSeApreto = false;
    private boolean perdiste = false;
    private float INTERVALO = 0.5f;
    private int record = 0;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
    }

    @Override
    public void render() {
        if (perdiste) {
            record = Math.max(record, number);
            // Mostrar mensaje de pérdida
            ScreenUtils.clear(1, 0, 0, 1); // Fondo rojo para indicar pérdida
            batch.begin();
            String lostText = "Has perdido. Aprieta r para volver a empezar";
            float lostTextWidth = font.getRegion().getRegionWidth();
            float lostTextHeight = font.getRegion().getRegionHeight();
            font.draw(batch, lostText, (Gdx.graphics.getWidth() - lostTextWidth) / 2 - lostTextWidth / 2, (Gdx.graphics.getHeight() + lostTextHeight) / 2);

            //Dibujar el record debajo
            String recordText = "Record: " + record;
            float recordTextWidth = font.getRegion().getRegionWidth();
            float recordTextHeight = font.getRegion().getRegionHeight();
            font.draw(batch, recordText, (Gdx.graphics.getWidth() - recordTextWidth) / 2 - recordTextWidth / 2, (Gdx.graphics.getHeight() + recordTextHeight) / 2 - 100);
            batch.end();
            if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                reiniciarJuego();
            }
            return; // Salir del método para no ejecutar el resto del código
        }

        float delta = Gdx.graphics.getDeltaTime();
        timeElapsed += delta;

        if (timeElapsed  >= timeElapsedBefore) {
            changeColor();
            timeElapsedBefore = timeElapsed + INTERVALO;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            esEspacioPresionado();
        }

        ScreenUtils.clear(color == 0 ? 0 : color == 1 ? 0 : 1, color == 0 ? 0 : color == 1 ? 1 : 0, color == 0 ? 1 : color == 1 ? 0 : 0, 1);
        batch.begin();
        String numberText = String.valueOf(number);
        float textWidth = font.getRegion().getRegionWidth();
        float textHeight = font.getRegion().getRegionHeight();
        font.draw(batch, numberText, (Gdx.graphics.getWidth() - textWidth) / 2, (Gdx.graphics.getHeight() + textHeight) / 2);
        batch.end();
    }

    private void changeColor() {
        if (color == 2 && !yaSeApreto) {
            perdiste = true;
            return;
        }
        int colorTemp = MathUtils.random(0, 2);
        while (colorTemp == color) {
            colorTemp = MathUtils.random(0, 2);
        }
        color = colorTemp;
        yaSeApreto = false;
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void incrementNumber() {
        number++;
    }

    private void esEspacioPresionado() {
        if (color == 2 && !yaSeApreto) {
            incrementNumber();
            yaSeApreto = true;
        } else {
            perdiste = true;
        }
    }


    private void reiniciarJuego() {
        color = 0;
        number = 0;
        timeElapsed = 0;
        timeElapsedBefore = 0;
        yaSeApreto = false;
        perdiste = false;
    }
}
