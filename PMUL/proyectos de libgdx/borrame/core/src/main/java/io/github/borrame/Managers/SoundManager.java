package io.github.borrame.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
    public static SoundManager instance;
    public static Music fondo = Gdx.audio.newMusic(Gdx.files.internal("sonidos/fondo.mp3"));
    public static Sound finDelJuego = Gdx.audio.newSound(Gdx.files.internal("sonidos/finDelJuego.mp3"));
    public static Sound captura = Gdx.audio.newSound(Gdx.files.internal("sonidos/captura.mp3"));

    public SoundManager() {
        instance = this;
    }

    public static void playFondo() {
        fondo.setLooping(true);
        fondo.play();
    }

    public static void stopFondo() {
        fondo.stop();
    }

    public static void playFinDelJuego() {
        finDelJuego.play();
    }

    public static void playCaptura() {
        captura.play();
    }

}
