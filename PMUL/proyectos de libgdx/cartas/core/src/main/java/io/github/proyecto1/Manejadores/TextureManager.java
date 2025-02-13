package io.github.proyecto1.Manejadores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.entidades.Carta;

public class TextureManager {
    public static String folderAssets = "assets/Tarot Cats";
    public static ArrayList<String> cartas = getCartas();
    BitmapFont font = new BitmapFont(Gdx.files.internal("fuentes/fuente.fnt"), Gdx.files.internal("fuentes/fuente.png"), false);

    public static ArrayList<String> getCartas() {
        File folder = new File(folderAssets);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> cartas = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName();
                if (name.endsWith(".png")) {
                    cartas.add(name);
                }
            }
        }
        return cartas;

    }

    public static Texture getCarta(int i) {
        return new Texture(folderAssets + "/" + cartas.get(i));
    }

    public static Texture getCartaOculta() {
        return new Texture("oculta.png");
    }

    public void renderScene(SpriteBatch sb, float delta) {
        sb.begin();
        switch (Mesa.getScreenActual()) {
            case 0:
                Mesa.fondo.dibujar(sb, delta);
                for (int i = 0; i < Mesa.botonesInicio.size; i++) {
                    Mesa.botonesInicio.get(i).dibujar(sb, delta);
                }

                break;
            case 1:
                Mesa.fondo.dibujar(sb, delta);
                Mesa.contador.dibujar(sb, delta);
                if (!Mesa.gano) {
                    for (int i = 0; i < Mesa.cartas.size; i++) {
                        Carta c = Mesa.cartas.get(i);
                        if (c.isVisible()) {
                            c.dibujar(sb, delta);
                        }
                    }
                }else{
                    font.getData().setScale(3.0f);
                    font.draw(sb, "Ganaste", 100, Mesa.alturaCamara/2);
                    font.draw(sb, "Intentos: " + Mesa.intentos, 100, Mesa.alturaCamara/2-50);
                    font.draw(sb, "Escribe tu nombre.Presiona enter para aceptar", 100, Mesa.alturaCamara/2-100);
                    font.draw(sb,ProcesadorDeEntradaJuego.nombreJugador, 100, Mesa.alturaCamara/2-150);
                }
                break;
            case 2:
                Mesa.fondo.dibujar(sb, delta);
                dibujarRecords(sb);
                break;


        }
        sb.end();
    }

    private void dibujarRecords(SpriteBatch sb) {
        font.getData().setScale(3.0f);
        float y = Mesa.alturaCamara - 100;
        float x = Mesa.anchoCamara / 2 - 200;

        font.draw(sb, "Records", x, y);
        y -= 50;
        float yaux = y;
        x += 500;
        for (Mesa.Dificultad dificultad : Mesa.records.keySet()) {
            Map<String, Integer> records = Mesa.records.get(dificultad);
            y = yaux;
            font.draw(sb, dificultad.toString(), x, y);

            for (String nombre : records.keySet()) {
                y -= 50;
                font.draw(sb, nombre + " " + records.get(nombre), x, y);
            }
            x -= 500;
        }
    }


}

