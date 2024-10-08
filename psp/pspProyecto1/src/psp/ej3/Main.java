package psp.ej3;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Votacion votacion = new Votacion(Votacion.getVotacion(5));

        Votante votante = null;

        for (int i = 0; i < 1000; i++) {
            votante = new Votante(votacion);
            votante.run();
        }

        votacion.Ganador();
        System.out.println("==============");
        votacion.mostrarVotos();
    }


}
