package io.github.borrame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private float stateTime;
    private TextureManager tm;
    SpriteBatch sb;
    BitmapFont fuente;
    Personaje personaje;
    Array<Pez> peces;
    int score = 0;
    TextureRegion fishCaught ;

    @Override
    public void create() {
        SoundManager.playFondo();
        tm = new TextureManager();
        stateTime = 0;
        sb = new SpriteBatch();
        fuente = new BitmapFont();
        fuente.getData().setScale(1);
        personaje = new Personaje(tm);
        Gdx.input.setInputProcessor(new ProcesadorDeEntrada(personaje));
        tm.addPersonaje(personaje);

        peces = new Array<>();



        agregarPez();
    }

    private void agregarPez() {
        TextureRegion textureRegion = tm.getRandFish();
        boolean movingRight = MathUtils.randomBoolean();
        float x = movingRight ? (-textureRegion.getRegionWidth()) + 1 : Gdx.graphics.getWidth();
        float y = MathUtils.random(0, 305 - textureRegion.getRegionHeight());
        float velocidad = MathUtils.random(50, 150);


        peces.add(new Pez(x, y, velocidad, movingRight, textureRegion,getTypeFish(textureRegion)));
    }

    private int getTypeFish(TextureRegion textureRegion) {
        if (textureRegion.getRegionWidth() == tm.pezAmarillo.getRegionWidth()) {
            return 1;
        } else if (textureRegion.getRegionWidth() == tm.pezLila.getRegionWidth()) {
            return 2;
        } else {
            System.out.println("Pez azul2");
            return 3;
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        float delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;

        personaje.actualiza();
        for (Pez pez : peces) {
            pez.actualiza();
            // Check if the fish is caught by the hook
            if (pezCercaAnzuelo(pez)) {
                // Handle fish caught logic
                SoundManager.playCaptura();
                score++;
                fishCaught = pez.randFish;
                personaje.pescoPez(fishCaught);
                System.out.println("Score:" + score);
                peces.removeValue(pez, true);

            } else if ((pez.x + pez.ancho < 0 && !pez.seMueveDerecha) || (pez.x > Gdx.graphics.getWidth() && pez.seMueveDerecha)) {
                // Remove fish that have gone off screen
                peces.removeValue(pez, true);
                System.out.println("Pez fuera de pantalla");

            }
        }

        sb.begin();
        tm.renderScene(sb);
        for (Pez pez : peces) {
            pez.dibuja(sb);
        }
        fuente.setColor(0, 1, 0, 1); // RGB for green
        fuente.draw(sb, "Score: " + score, 0, 450);


        sb.end();

        // Add new fish periodically
        if (stateTime > 2) {
            agregarPez();
            stateTime = 0;
        }
    }

    private boolean pezCercaAnzuelo(Pez pez) {
        Rectangle rectAnzuelo = new Rectangle(personaje.xanzuelo, personaje.yanzuelo, personaje.getAnchoanzuelo(), personaje.getAltoanzuelo());
        Rectangle rectPez = new Rectangle(pez.x, pez.y, pez.ancho, pez.alto);
        return rectAnzuelo.overlaps(rectPez);
    }
}
