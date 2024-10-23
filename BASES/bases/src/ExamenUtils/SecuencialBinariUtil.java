package ExamenUtils;

import java.io.*;

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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
