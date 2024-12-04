/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4ud1_alumno;




import CLASESDATOS.Alumno;
import CLASESDATOS.NotaAlumno;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class A4UD1_Alumnos {

    static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws IOException {
        runCode();
    }

    private static void runCode() throws IOException {
        int opcion = 0;
        while (opcion != 6){
            menu();
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

            switch (opcion){
                case 1 ->{
                    mostrarAlumnos();
                        }
                case 2 ->{
                    getNotasAlumnos();
                }
                case 3 ->{

                }
                case 4 ->{

                }
                case 5 ->{

                }
            }

        }
    }

    private static void getNotasAlumnos() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("src\\Tarea4_mod\\ficheros\\alumnos.dat", "rw");){
            ArrayList<NotaAlumno> notas = Alumno.getNotas();
            for (int i = 0; i < randomAccessFile.length() / 100; i++) {
                Alumno alumno = Alumno.leerAlumno(i);
                for (NotaAlumno notaAlumno :notas){
                    if (notaAlumno.getNumero() == alumno.getNumero()){
                        System.out.println("====================================");
                        System.out.println(alumno);
                        System.out.println(notaAlumno);
                        System.out.println("====================================");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void mostrarAlumnos() throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("src\\Tarea4_mod\\ficheros\\alumnos.dat", "rw");){
            for (int i = 0; i < randomAccessFile.length() / 100; i++) {
                Alumno alumno = Alumno.leerAlumno(i);
                if (alumno != null){
                    System.out.println(alumno);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void menu() {
        System.out.println("1-> Listar Todos los alumnos");
        System.out.println("2-> listar Todos los alumnos");
        System.out.println("3-> listar Todos los alumnos");
        System.out.println("4-> listar Todos los alumnos");
        System.out.println("5-> listar Todos los alumnos");
        System.out.println("6-> Salir");
    }

}
