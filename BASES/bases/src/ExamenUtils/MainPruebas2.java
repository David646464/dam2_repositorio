package ExamenUtils;

public class MainPruebas2 {
    public static void main(String[] args) {
        SecuencialBinariUtil secuencialBinariUtil = new SecuencialBinariUtil("src/ExamenUtils/archivosDePruebas/archivoBinario.dat");
        /*secuencialBinariUtil.abrirEscritura();
        ObjetoDePrueba objetoDePrueba = new ObjetoDePrueba("objeto1");
        secuencialBinariUtil.guardarObjeto(objetoDePrueba);
        secuencialBinariUtil.cerrarEscritura();
        secuencialBinariUtil.abrirLectura();
        ObjetoDePrueba objetoDePrueba1 = (ObjetoDePrueba)secuencialBinariUtil.leerObjeto();
        String texto = "objeto1";
        System.out.println(objetoDePrueba1.getNombre());
        secuencialBinariUtil.cerrarLectura();
        secuencialBinariUtil.abrirEscritura();
        Object [] objetos = {new ObjetoDePrueba("objeto2"), new ObjetoDePrueba("objeto3"),texto};
        secuencialBinariUtil.guardarSerieObjetos(objetos);
        secuencialBinariUtil.cerrarEscritura();
        secuencialBinariUtil.abrirLectura();
        objetos = secuencialBinariUtil.leerSerieObjetos(3);
        for (Object object : objetos) {
            //El instanceof es una palabra clave en Java que se utiliza para verificar si un objeto es una instancia de una clase,
            if (object instanceof ObjetoDePrueba){
                System.out.println(((ObjetoDePrueba)object).getNombre());
            }else{
                System.out.println(object);
            }
        }
        secuencialBinariUtil.cerrarLectura();*/
        ObjetoDePrueba objetoDePrueba = new ObjetoDePrueba("objeto2");
        ObjetoDePrueba objetoDePrueba1 = new ObjetoDePrueba("objeto3");
        secuencialBinariUtil.abrirEscritura();
        secuencialBinariUtil.guardarObjeto(objetoDePrueba);
        secuencialBinariUtil.guardarObjeto(objetoDePrueba1);
        secuencialBinariUtil.cerrarEscritura();

        System.out.println(secuencialBinariUtil.objetoEnArchivo(objetoDePrueba));

        secuencialBinariUtil.borrarObjetoEnArchivo(objetoDePrueba);
        System.out.println(secuencialBinariUtil.objetoEnArchivo(objetoDePrueba));

    }
}
