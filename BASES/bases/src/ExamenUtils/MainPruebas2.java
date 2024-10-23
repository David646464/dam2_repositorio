package ExamenUtils;

public class MainPruebas2 {
    public static void main(String[] args) {
        SecuencialBinariUtil secuencialBinariUtil = new SecuencialBinariUtil("src/ExamenUtils/archivosDePruebas/archivoBinario.dat");
        secuencialBinariUtil.abrirEscritura();
        ObjetoDePrueba objetoDePrueba = new ObjetoDePrueba("objeto1");
        secuencialBinariUtil.guardarObjeto(objetoDePrueba);
        secuencialBinariUtil.cerrarEscritura();
        secuencialBinariUtil.abrirLectura();
        ObjetoDePrueba objetoDePrueba1 = (ObjetoDePrueba)secuencialBinariUtil.leerObjeto();
        System.out.println(objetoDePrueba1.getNombre());
        secuencialBinariUtil.cerrarLectura();
    }
}
