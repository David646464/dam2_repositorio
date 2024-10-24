//david sanchez peso
package Clases;

import java.io.*;
import java.util.ArrayList;

public class BuferedUtil {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String root;

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public BuferedUtil(String root) throws IOException {
        File file = new File(root);
        setRoot(root);
        if (!file.exists()) {
            file.createNewFile();
        }
        bufferedReader = new java.io.BufferedReader(new FileReader(file));
    }

    public void setRoot(String root) throws IOException {
        BuferedUtil.root = root;
        File file = new File(root);
        if (!file.exists()) {
            file.createNewFile();
        }
        bufferedReader = new java.io.BufferedReader(new FileReader(file));
    }

    //Devuelve en un arrayList un string separado por un patron
    public ArrayList<String> leerConPatronDeSeparacion(String texto, String patron) throws Exception {
        try {
            ArrayList<String> lista = new ArrayList<>();
            String linea = texto;
            while (linea != null) {
                String[] partes = linea.split(patron);
                for (String parte : partes) {
                    lista.add(parte);
                }
                linea = bufferedReader.readLine();
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
