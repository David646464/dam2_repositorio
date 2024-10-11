package a4ud1_alumno;

import java.io.*;
import java.util.ArrayList;



public class LeerNotasAlumnos {
    public static  void main(String[] args) throws IOException {

        runCode();

    }

    private static void runCode() {
/*try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/Tarea4_mod/ficheros/NotasAlumnos1.dat"))){
            NotaAlumno notaAlumno = new NotaAlumno(1, new ArrayList<NotaModulo>());
            objectOutputStream.writeObject(notaAlumno);
        } catch (IOException e) {
            throw new RuntimeException(e);

}*/
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/ficheros/NotasAlumnos.dat"))){

                System.out.println(objectInputStream.readObject());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

