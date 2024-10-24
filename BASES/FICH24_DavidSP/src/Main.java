//david sanchez peso
import Clases.AccederCocineros;
import Clases.RandonAccesFileUtil;
import objetos.Cocinero;
import objetos.InfoCocinero;
import objetos.Restaurante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //A) Guardar dos cocineros
        AccederCocineros accederCocineros = new AccederCocineros("src/archivos/Cocineros.dat");
        ArrayList<String> recetas = new ArrayList<>();
        recetas.add("pollo");
        recetas.add("Espaguetis");
        Cocinero cocinero = new Cocinero("juan", "rtfwfrgh", LocalDate.now(),recetas);
        Cocinero cocinero2 = new Cocinero("pedro", "rtfwfrgh", LocalDate.now(),recetas);
        //Abre la escritura (BuferedWriter)
        accederCocineros.abrirescritura();
        //Guiarda 2 cocineros
        accederCocineros.guardarCocineroIndividual(cocinero2);
        accederCocineros.guardarCocineroIndividual(cocinero);
        //Cierra la escritura (BuferedWriter)
        accederCocineros.cerrarescritura();

        //B) guardarTodosLosCocineros
        //Abre la escritura (BuferedWriter)
        accederCocineros.abrirescritura();
        //guarda todos los cocineros
        accederCocineros.guardarCocineros("src/archivos/DatosCocineros.txt");
        //Cierra la escritura (BuferedWriter)
        accederCocineros.cerrarescritura();

        System.out.println("====================================");
        //2
        //Declaracion de objetos
        RandonAccesFileUtil randonAccesFileUtil = new RandonAccesFileUtil("src/archivos/ Restaurantes.dat",200);
        InfoCocinero infoCocinero = new InfoCocinero(1, "Chef");
        InfoCocinero infoCocinero2 = new InfoCocinero(1, "Ayudante");
        InfoCocinero infoCocinero3 = new InfoCocinero(1, "Sous Chef");
        InfoCocinero infoCocinero4 = new InfoCocinero(1, "Sous Chef");
        List<InfoCocinero> infoCocineros = new ArrayList<>();
        infoCocineros.add(infoCocinero2);
        infoCocineros.add(infoCocinero);
        infoCocineros.add(infoCocinero3);
        List<InfoCocinero> infoCocineros2 = new ArrayList<>();
        infoCocineros.add(infoCocinero2);
        infoCocineros.add(infoCocinero);
        infoCocineros.add(infoCocinero4);
        Restaurante restaurante = new Restaurante("La peña", "pontevedra", infoCocineros.size(),infoCocineros,false);
        Restaurante restaurante2 = new Restaurante("La peña2", "pontevedra", infoCocineros2.size(),infoCocineros2,false);
        //Añadimos el restaurante
        randonAccesFileUtil.nuevoRestaurante(restaurante);
        //Añadimos el restaurante que falla
        randonAccesFileUtil.nuevoRestaurante(restaurante2);
        //Listamos tdos los restaurantes
        randonAccesFileUtil.leerListaObjetosX();


        //4)
        //Muestro la informacion de un restaurante por su codigo
        System.out.println("=====================================");
        randonAccesFileUtil.getInfoRestaurante(1);
    }

}
