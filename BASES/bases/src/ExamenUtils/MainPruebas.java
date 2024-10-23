package ExamenUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainPruebas {
    public static void main(String[] args) throws Exception {
        BuferedUtil buferedUtil = new BuferedUtil("src/ExamenUtils/archivosDePruebas/archivoBuffered.txt");
        //buferedUtil.abrirEscritura();
        //buferedUtil.guardarLinea("Hola mundo");
        //buferedUtil.cerrarEscritura();
        //System.out.println(buferedUtil.leerLinea());
        System.out.println(buferedUtil.leerConPatronDeSeparacion(",").toString());

    }
}
