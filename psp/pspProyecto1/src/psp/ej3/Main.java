package psp.ej3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] partidos = {"PSOE", "Podemos", "Ciudadanos", "Vox"};
        ArrayList<String> nombresPartidos = new ArrayList<>(Arrays.stream(partidos).toList());
        Votacion votacion = new Votacion(Votacion.getVotacion(nombresPartidos));

        Votante votante = null;
        ArrayList<Votante> votantes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            votante = new Votante(votacion);
            votante.start();
            votantes.add(votante);
        }
        for (Votante votante1 : votantes) {
            votante1.join();
        }

        votacion.Ganador();
        System.out.println("==============");
        votacion.mostrarVotos();
    }


}
