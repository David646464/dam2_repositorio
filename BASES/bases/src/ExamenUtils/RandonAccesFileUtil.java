package ExamenUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class RandonAccesFileUtil {
    private RandomAccessFile randomAccessFile;
    private String root;
    private long objetoSize;

    public RandonAccesFileUtil(String root, long objetoSize) throws FileNotFoundException {
        this.root = root;
        this.objetoSize = objetoSize;
        File file = new File(root);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        randomAccessFile = new RandomAccessFile(root, "rw");
    }

    public void setRoot(String root, long objetoSize) throws FileNotFoundException {
        this.root = root;
        this.objetoSize = objetoSize;
        File file = new File(root);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        randomAccessFile = new RandomAccessFile(root, "rw");
    }



    public void escribirObjetoX(ObjetoDePrueba2 object, int posicion) {
        try {
            if (posicion > numeroDeObjetos()) {
                randomAccessFile.seek(randomAccessFile.length());
            } else {
                randomAccessFile.seek(posicion * objetoSize);
            }
            randomAccessFile.seek(posicion * objetoSize);
            randomAccessFile.writeUTF(object.getNombre());
            randomAccessFile.writeInt(object.getEdad());
            randomAccessFile.writeBoolean(object.borrado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ObjetoDePrueba2 leerObjetoX(int posicion) {
        try {
            randomAccessFile.seek(posicion * objetoSize);
            String nombre = randomAccessFile.readUTF();
            int edad = randomAccessFile.readInt();
            ObjetoDePrueba2 objeto = new ObjetoDePrueba2(nombre, edad);
            objeto.setBorrado(randomAccessFile.readBoolean());
            if (objeto.borrado) {
                return null;
            }
            return objeto;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int numeroDeObjetos() {
        try {
            int size = (int) randomAccessFile.length() ;
            int numeroDeObjetos = size / (int) objetoSize;

            return numeroDeObjetos;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void borrarObjetoX(int posicion) {


        try {
            randomAccessFile.seek(posicion * objetoSize);
            String nombre = randomAccessFile.readUTF();
            int edad = randomAccessFile.readInt();
            ObjetoDePrueba2 objeto = new ObjetoDePrueba2(nombre, edad);

            randomAccessFile.seek(posicion * objetoSize);
            randomAccessFile.writeUTF(objeto.getNombre());
            randomAccessFile.writeInt(objeto.getEdad());
            randomAccessFile.writeBoolean(true);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<ObjetoDePrueba2> leerListaObjetosX() {
        ArrayList<ObjetoDePrueba2> objetos = new ArrayList<>();
        for (int i = 0; i < numeroDeObjetos(); i++) {
            objetos.add(leerObjetoX(i));
        }
        return objetos;
    }
}
