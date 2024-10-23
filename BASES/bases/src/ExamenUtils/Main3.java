package ExamenUtils;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class Main3 {
    public static void main(String[] args) throws FileNotFoundException {
        RandonAccesFileUtil randonAccesFileUtil = new RandonAccesFileUtil("src/ExamenUtils/archivosDePruebas/archivoRandom.dat",100);
        randonAccesFileUtil.numeroDeObjetos();
        ObjetoDePrueba2 objetoDePrueba = new ObjetoDePrueba2("objeto1",22);
        ObjetoDePrueba2 objetoDePrueba2 = new ObjetoDePrueba2("objeto2",22);
        ObjetoDePrueba2 objetoDePrueba3 = new ObjetoDePrueba2("objeto3",22);
        System.out.println("=======================================");
        System.out.println(randonAccesFileUtil.numeroDeObjetos());
        System.out.println("=======================================");
        randonAccesFileUtil.escribirObjetoX(objetoDePrueba , randonAccesFileUtil.numeroDeObjetos());
        randonAccesFileUtil.escribirObjetoX(objetoDePrueba2 , randonAccesFileUtil.numeroDeObjetos());
        //randonAccesFileUtil.escribirObjetoX(objetoDePrueba3 , randonAccesFileUtil.numeroDeObjetos());
        //ObjetoDePrueba2 objetoDePrueba1 =randonAccesFileUtil.leerObjetoX(randonAccesFileUtil.numeroDeObjetos());
        objetoDePrueba = randonAccesFileUtil.leerObjetoX(0);
        objetoDePrueba2 = randonAccesFileUtil.leerObjetoX(1);
        //objetoDePrueba3 = randonAccesFileUtil.leerObjetoX(2);

        System.out.println(objetoDePrueba.getNombre());
        System.out.println(objetoDePrueba2.getNombre());
        //System.out.println(objetoDePrueba3.getNombre());



    }
}
