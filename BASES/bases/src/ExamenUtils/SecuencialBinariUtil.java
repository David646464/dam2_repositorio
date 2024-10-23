package ExamenUtils;

import java.io.*;
import java.util.ArrayList;

public class SecuencialBinariUtil {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private String root;

    public SecuencialBinariUtil(String root) {
        this.root = root;
        File file = new File(root);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRoot(String root) {
        this.root = root;
        File file = new File(root);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void abrirLectura() {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarLectura() {
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirEscritura() {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarEscritura() {
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarObjeto(Object object){
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object leerObjeto(){
        try {
            return objectInputStream.readObject();
        }catch (Exception e) {
            return null;
        }

    }

    public void guardarSerieObjetos(Object[] objects){
        for (Object object : objects) {
            guardarObjeto(object);
        }
    }

    public Object[] leerSerieObjetos(int cantidad){
        Object[] objects = new Object[cantidad];
        for (int i = 0; i < cantidad; i++) {
            objects[i] = leerObjeto();
        }
        return objects;
    }

    public void borrarArchivo() {
        File file = new File(root);
        file.delete();
    }

    public void borrarArchivo(String root) {
        File file = new File(root);
        file.delete();
    }


    public boolean objetoEnArchivo(Object object) {
        abrirLectura();
        Object obj;
        try {
            while ((obj = leerObjeto()) != null) {
                if (obj.equals(object)){
                    cerrarLectura();
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Fin del archivo");

        }
        cerrarLectura();
        return false;
    }

    public boolean objetoEnArchivo(Object object, String root) {
        setRoot(root);
        return objetoEnArchivo(object);
    }

    public void  borrarObjetoEnArchivo(Object object) {
        abrirLectura();
        Object obj;
        ArrayList<Object> objects = new ArrayList<>();

        int i = 0;
        try {
            while ((obj = leerObjeto()) != null) {
                if (!obj.equals(object)){
                    objects.add(obj);
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("Fin del archivo");

        }
        cerrarLectura();
        borrarArchivo();
        abrirEscritura();
        guardarSerieObjetos(objects.toArray());
        cerrarEscritura();
    }


}
