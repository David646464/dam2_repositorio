package io.github.proyecto1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import io.github.proyecto1.Manejadores.ProcesadorDeEntradaJuego;
import io.github.proyecto1.Manejadores.TextureManager;
import io.github.proyecto1.Pantallas.PantallaInicio;
import io.github.proyecto1.Pantallas.PantallaJuego;
import io.github.proyecto1.Pantallas.PantallaRecords;
import io.github.proyecto1.Utils.CreaTableros;
import io.github.proyecto1.entidades.Boton;
import io.github.proyecto1.entidades.Carta;
import io.github.proyecto1.entidades.Contador;
import io.github.proyecto1.entidades.Fondo;

public class Mesa {

    public static int cartasEncontradas = 0;
    public static boolean gano = false;
    private static Preferences prefs = Gdx.app.getPreferences("MyPreferences");
    private static Json json = new Json();




    public enum Dificultad {FACIL, MEDIO, DIFICIL}
    public static float alturaCamara = 1400;
    public static float anchoCamara = 1600;
    public static OrthographicCamera camera = new OrthographicCamera(anchoCamara,alturaCamara);
    public static Fondo fondo = new Fondo();
    public static float margen = 30;
    public static Dificultad dificultad = Dificultad.FACIL;
    public static int cantidadCartas = 0;
    public static int cartasPorFila = 0;
    public static int cartasPorColumna = 0;
    public static int[][] tablero;
    public static int[] ajustesMargenCartas = {550, 250, 550, 60, 550, 20};
    public static int intentos = 0;
    public static Contador contador;
    private static int ScreenActual = 0;
    private static Screen screen = new PantallaInicio();
    public static TextureManager tm = new TextureManager();
    public static  float[] anchoAltoBotones = {400, 100};

    public static Array<Boton> botonesInicio = new Array<>();

    public static Array<Carta> cartas = null;

    public static Map<Dificultad,Map<String,Integer>> records = new HashMap<>();

    public static Screen getNewScreen() {
        switch (ScreenActual) {
            case 0:
                return new PantallaInicio();
            case 1:
                return new PantallaJuego();
            case 2:
                return new PantallaRecords();
            default:
                return new PantallaInicio();
        }
    }

    public static int getScreenActual() {
        return ScreenActual;
    }

    public static void setScreen(int i) {
        screen.dispose();
        ScreenActual = i;
        screen = getNewScreen();
        screen.show();
    }

    public static int getCartasPorDificultad() {
        switch (dificultad) {
            case FACIL:
                return 5;
            case MEDIO:
                return 6;
            case DIFICIL:
                return 7;
            default:
                return 5;
        }
    }


    public static Screen getScreen() {
        return screen;
    }

    ;

    public static Array<Carta> getCartas() {
        Array<Carta> cartas = new Array<>();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                cartas.add(new Carta(TextureManager.getCarta(tablero[i][j]), TextureManager.getCartaOculta(), tablero[i][j], i, j));
            }
        }
        return cartas;
    }

    public static void nuevoInicio(){
        botonesInicio = new Array<>();
        Boton miBoton = new Boton("Botonjugar", (anchoCamara / 2) - (anchoAltoBotones[0] / 2),
            alturaCamara / 2 + 400, anchoAltoBotones[0], anchoAltoBotones[1], "Jugar",
            () -> Mesa.setScreen(1));
        botonesInicio.add(miBoton);
        miBoton = new Boton("BotonFacil", (anchoCamara / 2) - (anchoAltoBotones[0] / 2),
            alturaCamara / 2 + 200,  anchoAltoBotones[0], anchoAltoBotones[1], "Facil",
            () -> Mesa.dificultad = Dificultad.FACIL);

        botonesInicio.add(miBoton);
        miBoton = new Boton("BotonMedio", (anchoCamara / 2) - (anchoAltoBotones[0] / 2),
            alturaCamara / 2 ,  anchoAltoBotones[0], anchoAltoBotones[1], "Medio",
            () -> Mesa.dificultad = Dificultad.MEDIO);
        botonesInicio.add(miBoton);
        miBoton = new Boton("BotonDifficil", (anchoCamara / 2) - (anchoAltoBotones[0] / 2),
            alturaCamara / 2 - 200, anchoAltoBotones[0], anchoAltoBotones[1], "Dificil",
            () -> Mesa.dificultad = Dificultad.DIFICIL);
        botonesInicio.add(miBoton);

        switch (dificultad) {
            case FACIL:
                setearApretado("BotonFacil");
                break;
            case MEDIO:
                setearApretado("BotonMedio");
                break;
            case DIFICIL:
                setearApretado("BotonDifficil");
                break;
            default:
                setearApretado("BotonFacil");
                break;
        }
        ProcesadorDeEntradaJuego.nombreJugador = "";
    }

    private static void setearApretado(String botonFacil) {
        for (Boton boton : botonesInicio) {
            if (boton.getNombre().equals(botonFacil)) {
                boton.setApretado(true);
            } else {
                boton.setApretado(false);
            }
        }
    }

    public static void nuevaMesa() {
        gano = false;
        cartasEncontradas = 0;
        cantidadCartas = Mesa.getCartasPorDificultad();
        cartasPorFila = cantidadCartas - 1;
        cartasPorColumna = cantidadCartas;
        tablero = CreaTableros.crearTablero(cartasPorFila, cartasPorColumna);
        contador = new Contador();
        cartas = Mesa.getCartas();
        intentos = 0;
    }


    public static void guardarRecord(String nombre, int intentos, Dificultad dificultad) {
       if(!comprobarQuePersonaNoTieneRecordMayor(nombre, intentos, dificultad)){
           Map<String, Integer> records = getRecords(dificultad);
           records.put(nombre, intentos);
           prefs.putString("records_" + dificultad.name(), json.toJson(records));
           prefs.flush();
       }
       //anton:{class:java.lang.Integer,value:12}
    }

    private static boolean comprobarQuePersonaNoTieneRecordMayor(String nombre, int intentos, Dificultad dificultad) {
        Map<String, Integer> records = getRecords(dificultad);
        if (records.containsKey(nombre)) {
            if (records.get(nombre) < intentos) {
              return true;
            }
        }
        return false;
    }

    public static Map<String, Integer> getRecords(Dificultad dificultad) {
        String recordsJson = prefs.getString("records_" + dificultad.name(), "{}");
        return json.fromJson(HashMap.class, recordsJson);
    }

    public static Map<String, Integer> getSortedRecords(Dificultad dificultad) {
        Map<String, Integer> records = getRecords(dificultad);
        return records.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }

    public static void nuevoRecords() {
        guardarRecord(ProcesadorDeEntradaJuego.nombreJugador, intentos, dificultad);
        recupearRecords();
        //modoDebujarRecords();
        //resetRecords();
    }

    private static void recupearRecords() {
        records.put(Dificultad.FACIL, getSortedRecords(Dificultad.FACIL));
        records.put(Dificultad.MEDIO, getSortedRecords(Dificultad.MEDIO));
        records.put(Dificultad.DIFICIL, getSortedRecords(Dificultad.DIFICIL));
    }

    public static void resetRecords() {
        for (Dificultad dificultad : Dificultad.values()) {
            prefs.remove("records_" + dificultad.name());
        }
        prefs.flush();
    }

}
