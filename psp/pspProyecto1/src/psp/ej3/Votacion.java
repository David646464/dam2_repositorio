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

    public ArrayList<Partido> getArrayListPartidos() {
        return arrayListPartidos;
    }

    public void Ganador(){
        Collections.sort(arrayListPartidos);
        System.out.println("Ganador o ganadores");
        for (Partido partido :arrayListPartidos){
            if (arrayListPartidos.getFirst().getVotos() == partido.getVotos()){
                System.out.println(partido.toString());
            }else {
                break;
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
