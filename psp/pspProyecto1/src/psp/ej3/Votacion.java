package psp.ej3;

import java.util.ArrayList;
import java.util.Collections;

public class Votacion {
    private ArrayList<Partido> arrayListPartidos ;

    public Votacion(ArrayList<Partido> arrayListPartidos) {
        this.arrayListPartidos = arrayListPartidos;
    }

    public static ArrayList<Partido> getVotacion(int i) {
        ArrayList<Partido> partidos = new ArrayList<>();

        for (int j = 0; j < i; j++) {
            Partido partido = new Partido("Partido " + j);
            partidos.add(partido);
        }
        return partidos;
    }

    public static ArrayList<Partido> getVotacion( ArrayList<String> partidosNombres) {
        ArrayList<Partido> partidos = new ArrayList<>();

        for (String nombrePartido : partidosNombres) {
            Partido partido = new Partido(nombrePartido);
            partidos.add(partido);
        }
        return partidos;
    }

    public ArrayList<Partido> getArrayListPartidos() {
        return arrayListPartidos;
    }

    public void Ganador(){
        //Collections.sort(arrayListPartidos);
        System.out.println("Ganador o ganadores");
        int votos = 0;
        for (int i = 0; i < arrayListPartidos.size(); i++) {
            if (arrayListPartidos.get(i).getVotos() > votos){
                votos = arrayListPartidos.get(i).getVotos();
            }
        }
        for (Partido partido : arrayListPartidos){
            if (partido.getVotos() == votos){
                System.out.println(partido.toString());
            }
        }

    }

    public void mostrarVotos() {
        Collections.sort(arrayListPartidos);
        for (Partido partido :arrayListPartidos){
            System.out.println(partido.toString());
        }
    }
}
