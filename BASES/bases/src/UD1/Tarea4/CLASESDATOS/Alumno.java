package UD1.Tarea4.CLASESDATOS;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Alumno implements Serializable {
    private static int numero;
    private Nombre nombre;
    Date fechaNac;
    ArrayList <String> telefono;
    boolean borrado;

    public Alumno() {
    }
    

    public Alumno(int numero, Nombre nombre, Date fechaNac, ArrayList<String> telefono, boolean borrado) {
        this.numero = numero;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.borrado = borrado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public ArrayList<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList<String> telefono) {
        this.telefono = telefono;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public long LongitudRegistro() {
        //Date en Internet dice que ocupa 12 bytes? . Vamos a suponer esto
        
        return (4+nombre.nombre.length() +nombre.apellido1.length()+nombre.apellido2.length()+12 + (telefono.toString()).length()+ 1);

    }
    public void guardarAlumno() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src\\UD1\\Tarea4\\ficheros\\alumnos.dat", "rw");
        randomAccessFile.seek(numero * 100);
        randomAccessFile.writeInt(numero);
        randomAccessFile.writeUTF(nombre.getNombre());
        randomAccessFile.writeUTF(nombre.getApellido1());
        randomAccessFile.writeUTF(nombre.getApellido2());
        randomAccessFile.writeLong(fechaNac.getTime());
        randomAccessFile.writeInt(telefono.size());
        for (int i = 0; i < telefono.size(); i++) {
            randomAccessFile.writeUTF(telefono.get(i));
        }
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre=" + nombre.toString() +
                ", fechaNac=" + fechaNac +
                ", telefono=" + telefono +
                ", borrado=" + borrado +
                '}';
    }

    public static Alumno leerAlumno(int numeroAlumno) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src\\UD1\\Tarea4\\ficheros\\alumnos.dat", "rw");
        randomAccessFile.seek(numero * 100);
        try {
            int numero = randomAccessFile.readInt();
            Nombre nombre = new Nombre(randomAccessFile.readUTF(), randomAccessFile.readUTF(), randomAccessFile.readUTF());
            Date date = new Date(randomAccessFile.readLong());
            ArrayList<String> listaTelefonos = new ArrayList<>();
            int iteraciones = randomAccessFile.readInt();
            for (int i = 0; i < iteraciones; i++) {
                listaTelefonos.add(randomAccessFile.readUTF());
            }
            Boolean borrado = false;
            try {
                borrado = randomAccessFile.readBoolean();
            }catch (Exception e){

            }
            return new Alumno(numero,nombre,date,listaTelefonos,borrado);
        }catch (Exception e){
            return null;
        }
    }


    public static NotaAlumno getNotas(){
        return null;
    }
}
