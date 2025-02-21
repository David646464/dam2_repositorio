package io.github.proyecto1;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.ArrayList;

import io.github.proyecto1.Entidades.Circulo;
import io.github.proyecto1.Entidades.Cuadrado;
import io.github.proyecto1.Entidades.Equis;
import io.github.proyecto1.Entidades.Personaje;
import io.github.proyecto1.Interfaces.Entidad;
import io.github.proyecto1.Pantallas.PantallaJuego;
import io.github.proyecto1.Pantallas.PantallaMenu;
import io.github.proyecto1.Pantallas.PantallaPausa;
import io.github.proyecto1.Textures.TextureManager;

public class Mundo {
    public static TextureManager textureManager = new TextureManager();
    public static float alturaCamara = 1400;
    public static float anchoCamara = 1600;
    public static OrthographicCamera camera = new OrthographicCamera(anchoCamara, alturaCamara);
    public static Screen pantallaActual;
    public static int numScreen = 1;
    public static int numScreenAnterior = 1;
    public static Personaje personaje;
    public static int numColisiones = 0;
    public static  int numVecesColisionado = 0;
    public static ArrayList<Entidad> enemigos = new ArrayList<>();
    public static ArrayList<Entidad> enemigosGuardados = new ArrayList<>();
    public static float stateTime2 = 0;
    public static float tiempoGeneracion = 1;


    private static void setScreen(Screen screen) {
        if (screen instanceof PantallaMenu) {
            prepararPantallaMenu();
            pantallaActual = screen;
            screen.show();
        } else if (screen instanceof PantallaJuego) {
            System.out.println("Tocado");
            if (numScreenAnterior != 3){
                prepararPantallaJuego();
            }

            pantallaActual = screen;
            screen.show();


        } else if (screen instanceof PantallaPausa) {
            pantallaActual = screen;
            screen.show();
        }
    }




    public static void changeScreen(int NewNumScreen) {
        numScreenAnterior = numScreen;
        numScreen = NewNumScreen;

        switch (numScreen) {
            case 1:
                setScreen(new PantallaMenu());
                break;
            case 2:

              setScreen(new PantallaJuego());
                break;
            case 3:
              setScreen(new PantallaPausa());
                break;
            case 4:
                //pantallaActual = new PantallaWin();
                break;
        }
    }

    private static void prepararPantallaMenu() {
        stateTime2 = 0;

    }

    private static void prepararPantallaJuego() {
        personaje = new Personaje(Mundo.anchoCamara / 2 , Mundo.anchoCamara / 2, 50, 50,200);
        Mundo.numVecesColisionado = 0;

    }

    public static void desactivarEnemigos() {
        for (int i = 0; i < Mundo.enemigos.size(); i++) {
            Entidad entidad = Mundo.enemigos.get(i);
            if (entidad instanceof Cuadrado) {
                Cuadrado cuadrado = ((Cuadrado) entidad);
                cuadrado.desactivado = true;
            } else if (entidad instanceof Circulo) {
                Circulo circulo = ((Circulo) entidad);
                circulo.desactivado = true;
            } else if (entidad instanceof Equis) {
                Equis equis = ((Equis) entidad);
                equis.desactivado = true;
            }
        }
    }



}
