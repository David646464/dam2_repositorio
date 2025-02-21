package io.github.proyecto1;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import io.github.proyecto1.Entidades.Boton;
import io.github.proyecto1.Entidades.Objeto1;
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
    public static Boton boton;
    public static Objeto1 objeto1;



    private static void setScreen(Screen screen) {
        if (screen instanceof PantallaMenu) {
            prepararPantallaMenu();
            pantallaActual = screen;
            screen.show();
        } else if (screen instanceof PantallaJuego) {
            prepararPantallaJuego();


        } else if (screen instanceof PantallaPausa) {

        }
    }




    public static void changeScreen(int numScreen) {
        switch (numScreen) {
            case 1:
                setScreen(new PantallaMenu());
                numScreen = 1;
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
        boton = nuevoBoton();
        objeto1 = new Objeto1(100, 100, 100, 100,200);


    }

    private static void prepararPantallaJuego() {
    }

    private static Boton nuevoBoton() {
        Boton boton = new Boton("BotonpaceHolder", 100,100,400,100, "BotonPlaceHolder",
            () -> System.out.println("Boton presionado"));
        return boton;
    }


}
