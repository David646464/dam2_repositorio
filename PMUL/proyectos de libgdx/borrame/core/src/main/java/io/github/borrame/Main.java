package io.github.borrame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private float stateTime;

    SpriteBatch sb;
    BitmapFont fuente;
    Texture textureBender;
    Personaje personaje;

    @Override
    public void create() {
        stateTime=0;
        sb=new SpriteBatch();
        fuente=new BitmapFont();
        fuente.getData().setScale(5);
        textureBender=new Texture("bender.png");
        personaje=new Personaje();
        Gdx.input.setInputProcessor(new ProcesadorDeEntrada(personaje));
    }

    @Override
    public void render() {
        ScreenUtils.clear(1,1,1,1);
        float delta=Gdx.graphics.getDeltaTime();
        stateTime+=delta;

        personaje.actualiza();
        sb.begin();
        personaje.dibuja(sb,textureBender);
        sb.end();
    }


}
