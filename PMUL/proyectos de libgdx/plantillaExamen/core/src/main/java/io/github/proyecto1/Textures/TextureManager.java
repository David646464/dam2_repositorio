package io.github.proyecto1.Textures;

import static io.github.proyecto1.Util.GuardadorDePreferencias.getRecordPorNombre;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.proyecto1.Mundo;
import io.github.proyecto1.Util.GuardadorDePreferencias;

public class TextureManager {
    public static BitmapFont fuente = TextureGetter.fontBoton();
    public static void renderScene(SpriteBatch batch, float delta) {
        fuente.getData().setScale(3.0f);
        batch.begin();
        switch (Mundo.numScreen) {
            case 0:
                break;
            case 1:
                batch.draw(TextureGetter.amarillo(),0, Mundo.alturaCamara / 2,Mundo.anchoCamara,Mundo.alturaCamara);
                batch.draw(TextureGetter.verde(),0, 0,Mundo.anchoCamara,Mundo.alturaCamara / 2);
                fuente.draw(batch, "Jugar (numero de 1 al 9)", Mundo.anchoCamara / 2 -200, (Mundo.alturaCamara / 4) + (Mundo.alturaCamara / 2));
                imprimirRecord(batch);
                break;
            case 2:
                batch.draw(TextureGetter.negro(),0,0,Mundo.anchoCamara,Mundo.alturaCamara);
                imprimirInfo(batch);
                Mundo.personaje.dibujar(batch,delta);
                for (int i = 0; i < Mundo.enemigos.size(); i++) {
                    Mundo.enemigos.get(i).dibujar(batch,delta);
                }
                break;
            case 3:
                fuente.getData().setScale(5.0f);
                fuente.draw(batch,"PAUSA", Mundo.anchoCamara / 2, Mundo.alturaCamara / 2);
                fuente.getData().setScale(3.0f);
                break;

        }
        batch.end();
    }

    private static void imprimirInfo(SpriteBatch batch) {
        batch.draw(TextureGetter.getTextureFondoBoton(),-100,0,Mundo.anchoCamara + 200,100);
        String textoNuevoRecord = (int)GuardadorDePreferencias.getRecordPorNombre(Mundo.numColisiones) <= (int)Mundo.stateTime2 ? "Nuevo Record!" : "" ;
        String texto = "TIEMPO " + (int) Mundo.stateTime2 + "s COLISIONES " + Mundo.numVecesColisionado + " de " +Mundo.numColisiones + " RECORD " + (int)GuardadorDePreferencias.getRecordPorNombre(Mundo.numColisiones) + "s " + textoNuevoRecord;
        fuente.draw(batch, texto, 0, 50);
    }

    private static void imprimirRecord(SpriteBatch batch) {
        float y = Mundo.alturaCamara / 2 -100;
        for (int i = 1; i <= 9; i++) {
            float record = getRecordPorNombre(i);
            fuente.draw(batch, "el record para " + String.valueOf(i) + " colisiones es de " + String.valueOf((int)record) + "s", Mundo.anchoCamara / 2 -400, y);
            y-=50;
        }
    }
}
