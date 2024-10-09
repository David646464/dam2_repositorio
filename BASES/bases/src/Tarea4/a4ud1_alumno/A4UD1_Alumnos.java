/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea4.a4ud1_alumno;

import Tarea4.CLASESDATOS.Alumno;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
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

    private static void mostrarAlumnos() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src\\Tarea4\\ficheros\\alumnos.dat", "rw");
        for (int i = 0; i < randomAccessFile.length() / 100; i++) {
            Alumno alumno = Alumno.leerAlumno(i);
            if (alumno != null){
                System.out.println(alumno);
            }
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
