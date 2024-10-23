package ExamenUtils;

import java.io.*;
import java.util.ArrayList;

public class BuferedUtil {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String root;

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

    public void abrirEscritura() throws IOException {
        if (root != null) {
            bufferedWriter = new BufferedWriter(new FileWriter(root, true)); // Append mode
        } else {
            throw new IOException("Root path is not set.");
        }
    }

    public void cerrarEscritura() throws IOException {
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }

    public String leerLinea() throws Exception {
        try {
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }

    public String leerFichero() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            sb.append(bufferedReader.readLine() + "\n");
        }

        bufferedReader = new BufferedReader(new FileReader(root));
        return sb.toString();
    }

    public int leerInt() throws Exception {
        try {
        return Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double leerDouble() throws Exception {
        try {
            return Double.parseDouble(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public float leerFloat() throws Exception {
        try {
            return Float.parseFloat(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long leerLong() throws Exception {
        try {
            return Long.parseLong(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String> leerConPatronDeSeparacion(String patron) throws Exception {
        try {
            ArrayList<String> lista = new ArrayList<>();
            String linea = bufferedReader.readLine();
            while (linea != null) {
                String[] partes = linea.split(patron);
                for (String parte : partes) {
                    lista.add(parte);
                }
                linea = bufferedReader.readLine();
            }
            return lista;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String leerLineaConIndice(int i) {
        String linea = null;
        try {
            for (int j = 0; j < i; j++) {
                linea = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linea;
    }

    public String buscarPrimeraLineaPorTexto(String texto) {
        String linea = null;
        try {
            while (bufferedReader.ready()) {
                linea = bufferedReader.readLine();
                if (linea.contains(texto)) {
                    return linea;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linea;
    }

    public void guardarDatosConPatron(ArrayList<String> lista, String patron) {
        try {
            for (String linea : lista) {
                bufferedWriter.write(linea + patron);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarTexto(String text) throws Exception {
        bufferedWriter.write(text);
    }

    public void guardarLinea(String text) throws Exception {
        bufferedWriter.write(text + "\n");
    }

    public void guardarInt(int num) throws Exception {
        bufferedWriter.write(num + "\n");
    }

    public void guardarDouble(double num) throws Exception {
        bufferedWriter.write(num + "\n");
    }

    public void guardarFloat(float num) throws Exception {
        bufferedWriter.write(num + "\n");
    }

    public void guardarLong(long num) throws Exception {
        bufferedWriter.write(num + "\n");
    }

    public void guardarSaltoDeLinea() throws Exception {
        bufferedWriter.write("\n");
    }

    public void cerrarLectura() throws Exception {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        cerrarEscritura();
    }

    public void abrirLectura() {
        try {
            bufferedReader = new BufferedReader(new FileReader(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
