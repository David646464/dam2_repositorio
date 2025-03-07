package io.github.proyecto1.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import io.github.proyecto1.Mundo;

public class GuardadorDePreferencias {
    private static Preferences prefs = Gdx.app.getPreferences("MyPreferences");


    public static void guardarRecord(float puntuacion,int numColisiones) {
       float recordAnterior = getRecordPorNombre(numColisiones);
       if (recordAnterior < puntuacion){
           guardarRecordNombre(puntuacion, numColisiones);
       }
    }

    public static float getRecordPorNombre(int numColisiones) {
        return prefs.getFloat("record_" + String.valueOf(numColisiones), 0);
    }

    private static void guardarRecordNombre(float puntuacion, int numColisiones) {
        prefs.putFloat("record_" + String.valueOf(numColisiones), puntuacion);
    }

    public static  void resetRecords(){
        for (int i = 1; i <= 9; i++) {
            prefs.remove("record_" + String.valueOf(i));
        }
    }


}
