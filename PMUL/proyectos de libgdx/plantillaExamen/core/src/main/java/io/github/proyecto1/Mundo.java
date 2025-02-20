package io.github.proyecto1;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import io.github.proyecto1.Entidades.Boton;
import io.github.proyecto1.Pantallas.Pantalla;
import io.github.proyecto1.Pantallas.Pantalla1;
import io.github.proyecto1.Textures.TextureManager;

public class Mundo {
    public static TextureManager textureManager = new TextureManager();
    public static float alturaCamara = 1400;
    public static float anchoCamara = 1600;
    public static OrthographicCamera camera = new OrthographicCamera(anchoCamara, alturaCamara);
    public static Screen pantallaActual;
    public static int numScreen = 1;
    public static Boton boton;



    private static void setScreen(Screen screen) {
        if (screen instanceof Pantalla1) {
            pantallaActual = screen;
            prepararPantalla1();
            screen.show();
        } else if (screen instanceof Pantalla) {



        }
    }


    public static void changeScreen(int numScreen) {
        switch (numScreen) {
            case 1:
                setScreen(new Pantalla1());
                numScreen = 1;
                break;
            case 2:
                //pantallaActual = new PantallaJuego();
                break;
            case 3:
                //pantallaActual = new PantallaGameOver();
                break;
            case 4:
                //pantallaActual = new PantallaWin();
                break;
        }
    }

    private static void prepararPantalla1() {
        boton = nuevoBoton();


    }

    private static Boton nuevoBoton() {
        Boton boton = new Boton("BotonpaceHolder", 100,100,400,100, "BotonPlaceHolder",
            () -> System.out.println("Boton presionado"));
        return boton;
    }


}
