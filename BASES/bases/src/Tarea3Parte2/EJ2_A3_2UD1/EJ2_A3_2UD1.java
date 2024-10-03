package Tarea3Parte2.EJ2_A3_2UD1;

import java.io.*;

public class EJ2_A3_2UD1 {
    public static void main(String[] args) throws IOException {
        runCode(args);
    }

    private static void runCode(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[1]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[0],true));
        try {
            while (true){
                String linea = bufferedReader.readLine();
                String[] partes = linea.split("/");
                if (partes.length == 3){
                    borrar(new File("src\\Tarea3Parte2\\EJ2_A3_2UD1\\ALUMNOS\\" + partes[0]));
                    new File("src\\Tarea3Parte2\\EJ2_A3_2UD1\\ALUMNOS\\" + partes[0] + "\\" + partes[1] + "-" + partes[2]).mkdirs();
                    bufferedWriter.write("src\\Tarea3Parte2\\EJ2_A3_2UD1\\ALUMNOS\\" + partes[0] + "\\" + partes[1] + "-" + partes[2]+" -----> se creo correctamente");
                    bufferedWriter.newLine();
                }else{
                    System.out.println("No tiene el formato adecuado");
                    bufferedWriter.write(linea + " -----> No tiene el formato CURSO/NUMERO/ALUMNO");
                    bufferedWriter.newLine();
                }
            }
        }catch (Exception e){

        }
        bufferedWriter.close();
    }

    private static void borrar(File file) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\Tarea3Parte2\\EJ2_A3_2UD1\\ficherolog.txt",true));
        for (File file1 : file.listFiles()){
            borrar(file1);
        }
        bufferedWriter.write(file.toPath() + "-----> ha sido borrado");
        bufferedWriter.newLine();
        file.delete();
        bufferedWriter.close();
    }


}
