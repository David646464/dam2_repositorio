package io.github.borrame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.borrame.Entidades.Barra;
import io.github.borrame.Entidades.Mundo;
import io.github.borrame.Entidades.Personaje;
import io.github.borrame.Entidades.Pez;
import io.github.borrame.Managers.SoundManager;
import io.github.borrame.Managers.TextureManager;

public class Main extends ApplicationAdapter {

    OrthographicCamera camara = new OrthographicCamera();

    private float stateTime;
    private float stateTime2;
    private TextureManager tm;
    public SpriteBatch sb;
    BitmapFont fuente;
    Personaje personaje;
    Array<Pez> peces;
    int score = 0;
    TextureRegion fishCaught;
    ShapeRenderer sr;

    @Override
    public void create() {


        SoundManager.playFondo();
        tm = new TextureManager();
        tm.addBarra(new Barra());
        stateTime = 0;
        sb = new SpriteBatch();
        sr = new ShapeRenderer();

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


        peces.add(new Pez(x, y, velocidad, movingRight, textureRegion, getTypeFish(textureRegion)));
    }

    private int getTypeFish(TextureRegion textureRegion) {
        if (textureRegion.getRegionWidth() == tm.pezAmarillo.getRegionWidth()) {
            return 1;
        } else if (textureRegion.getRegionWidth() == tm.pezLila.getRegionWidth()) {
            return 2;
        } else {
            System.out.println("Pez azul");
            return 3;
        }
    }


    @Override
    public void resize(int width, int height) {
        camara.setToOrtho(false, Mundo.Width, Mundo.Height);
        sb.setProjectionMatrix(camara.combined);
        sr.setProjectionMatrix(camara.combined);
    }


    @Override
    public void render() {


        ScreenUtils.clear(1, 1, 1, 1);
        float delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;
        stateTime2 += delta;
        Mundo.tiempo += delta;
        int i = 0;
        personaje.actualiza(delta);

        for (Pez pez : peces) {
            pez.actualiza(delta);
            // Check if the fish is caught by the hook
            if (Personaje.EstadoAnzuelo.SUBIENDO == personaje.estadoAnzuelo) {
                if ((i = pezCercaAnzuelo(pez)) == 0) {
                    // Handle fish caught logic
                    SoundManager.playCaptura();
                    score++;
                    fishCaught = pez.randFish;
                    personaje.pescoPez(fishCaught);
                    System.out.println("Score:" + score);
                    peces.removeValue(pez, true);

                } else if (i == 2) {
                    pez.y -= personaje.VELOCIDADANZUELO * delta;

                }

            }
            if ((pez.x + pez.ancho < 0 && !pez.seMueveDerecha) || (pez.x > Gdx.graphics.getWidth() && pez.seMueveDerecha)) {
                // Remove fish that have gone off screen
                peces.removeValue(pez, true);
                System.out.println("Pez fuera de pantalla");

            }
            pecesChocan(pez);
        }


        sr.begin(ShapeRenderer.ShapeType.Line);
        sb.begin();
        tm.renderScene(sb);
        for (Pez pez : peces) {
            pez.dibuja(sb);
        }
        fuente.setColor(0, 1, 0, 1);
        fuente.draw(sb, "Score: " + score, 0, Mundo.Height - 10);


        sb.end();
        sr.end();


        if (stateTime > 2) {
            agregarPez();
            stateTime = 0;
        }
        if (stateTime2 > 1f) {
            tm.barra.restarTamaño(delta);
            stateTime2 = 0;
        }
    }

    private void pecesChocan(Pez pez) {
        Rectangle rectangle1 = new Rectangle();
        if (pez.seMueveDerecha) {
            rectangle1 = new Rectangle(pez.x + pez.ancho - 20, pez.y, 1, 40);
        } else {
            rectangle1 = new Rectangle(pez.x, pez.y, 20, 40);//40
        }

        Rectangle rectangle2 = new Rectangle();
        for (int i = 0; i < peces.size; i++) {
            Pez pez1 = peces.get(i);
            if (pez1.seMueveDerecha) {
                rectangle2 = new Rectangle(pez1.x + pez1.ancho - 20, pez1.y, 1, 40);
            } else {
                rectangle2 = new Rectangle(pez1.x, pez1.y, 20, 40);//40
            }

            if (rectangle1.overlaps(rectangle2) && pez.seMueveDerecha != pez1.seMueveDerecha) {
                pez.seMueveDerecha = !pez.seMueveDerecha;
                pez1.seMueveDerecha = !pez1.seMueveDerecha;
            }
        }

    }

    private int pezCercaAnzuelo(Pez pez) {
        Rectangle rectAnzuelo = new Rectangle(personaje.xanzuelo, personaje.yanzuelo, personaje.getAnchoanzuelo(), personaje.getAltoanzuelo());
        Rectangle rectPez = new Rectangle(pez.x, pez.y + 30, 20, 40);//40
        Rectangle rectpezEmpuja = new Rectangle(pez.x, pez.y + pez.alto - 15, pez.ancho, 5);

        if (pez.seMueveDerecha) {

            rectPez = new Rectangle(pez.x + pez.ancho - 20, pez.y + 30, 20, 40);
        }
        pez.setRectangle(rectPez);
        int num = (rectAnzuelo.overlaps(rectPez) && personaje.estadoAnzuelo == Personaje.EstadoAnzuelo.SUBIENDO) == true ? 0 : 1;
        if (num == 1) {
            if ((rectAnzuelo.overlaps(rectpezEmpuja) && personaje.estadoAnzuelo == Personaje.EstadoAnzuelo.BAJANDO)) {
                num = 2;
            }
        }
        return num;
    }
}
