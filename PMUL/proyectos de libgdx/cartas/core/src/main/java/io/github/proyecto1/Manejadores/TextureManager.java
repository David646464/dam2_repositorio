package io.github.proyecto1.Manejadores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;
import java.util.ArrayList;

import io.github.proyecto1.Mesa;
import io.github.proyecto1.entidades.Carta;

public class TextureManager {
    public static String folderAssets = "assets/Tarot Cats";
    public static ArrayList<String> cartas = getCartas();

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

    public static Texture getCartaOculta(){
        return new Texture("oculta.png");
    }

    public void renderScene(SpriteBatch sb, float delta){
        sb.begin();
        Mesa.fondo.dibujar(sb,delta);
        Mesa.contador.dibujar(sb,delta);
        for (int i = 0; i < Mesa.cartas.size; i++) {
            Carta c = Mesa.cartas.get(i);
            if (c.isVisible()) {
               c.dibujar(sb,delta);
            }
        }
        sb.end();
    }




}

