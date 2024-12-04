//david sanchez peso
package Clases;

import objetos.InfoCocinero;
import objetos.Restaurante;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

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


    //Comprueba si el restaurante cumple con los requisitos
    public void nuevoRestaurante(Restaurante restaurante) throws IOException {
        if(!existeNombre(restaurante) && cocinerosExisten(restaurante)) {
            randomAccessFile.setLength(objetoSize * (randomAccessFile.length() / objetoSize + 1));
            restaurante.setNumero((int) Math.ceil(randomAccessFile.length() / objetoSize));
            escribirObjetoX(restaurante);
        } else{
        System.out.println("Ya existe " + restaurante.getNombre());
        }

    }

    //Busca si existe el restaurante
    private boolean cocinerosExisten(Restaurante restaurante) {
        AccederCocineros accederCocineros = new AccederCocineros("src/archivos/Cocineros.dat");
        boolean indicador = true;
        for (InfoCocinero infoCocinero : restaurante.getCocineros()){
            if (!accederCocineros.buscarCodigo(infoCocinero)){
                indicador = false;
                System.out.println("No esta dado de alta el cocinero " + infoCocinero.getCodigo());
            }
        }
        return indicador;
    }

    //Escribe el objeto
    public void escribirObjetoX(Restaurante object) {
        try {

                if (object.getNumero() > numeroDeObjetos()) {
                    randomAccessFile.seek(randomAccessFile.length());
                } else {
                    randomAccessFile.seek(object.getNumero() * objetoSize);
                }
                randomAccessFile.seek(object.getNumero() * objetoSize);
                randomAccessFile.writeUTF(object.getNombre());
                randomAccessFile.writeUTF(object.getLocalidad());
                randomAccessFile.writeInt(object.getNumComercios());
                for (InfoCocinero infoCocinero : object.getCocineros()) {
                    randomAccessFile.writeInt(infoCocinero.getCodigo());
                    randomAccessFile.writeUTF(infoCocinero.getTipo());
                }
                randomAccessFile.writeBoolean(object.isBaja());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Revisa si el nombre ya existe
    private boolean existeNombre(Restaurante object) throws IOException {
        for (int i = 1; i < randomAccessFile.length()/objetoSize; i++) {
            randomAccessFile.seek(i * objetoSize);
            String nombre = randomAccessFile.readUTF();
            if (nombre.equals(object.getNombre())){
                return true;
            }
        }
        return  false;
    }


    //Le un objetop de tipo restaurante a traves de la posicion y lo devuelve
    public Restaurante leerObjetoX(int posicion) {
        try {
            randomAccessFile.seek(posicion * objetoSize);
            String nombre = randomAccessFile.readUTF();
            String localidad = randomAccessFile.readUTF();
            int numeroCocineros = randomAccessFile.readInt();
            List<InfoCocinero> infoCocineros = new ArrayList<>();
            for (int i = 0; i < numeroCocineros; i++) {
                int numero = randomAccessFile.readInt();
                String tipo = randomAccessFile.readUTF();
                infoCocineros.add(new InfoCocinero(numero, tipo));

            }
            boolean booleano = randomAccessFile.readBoolean();
            Restaurante restaurante = new Restaurante(nombre,localidad,numeroCocineros, infoCocineros,booleano);
            restaurante.setNumero(posicion);
            if (booleano == true){
                return null;
            }else{
                return restaurante;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Calcula en numero de objetos maximo que puede haber almacenados
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


    //printea todos los objetos restaurante salmacenados que no esten borrados
    public void leerListaObjetosX() {
        System.out.println("Lista de restaurantes");
        for (int i = 1; i < numeroDeObjetos(); i++) {
            Restaurante restaurante =leerObjetoX(i);
            if (restaurante != null){
                System.out.println(restaurante);
            }
        }
    }

    public void getInfoRestaurante(int i) {
        Restaurante restaurante = leerObjetoX(i);
        System.out.println("Restaurante " + restaurante.getNumero());
        System.out.println(restaurante);

        AccederCocineros.imprimirEmpleadosDeRestaurante(restaurante);


    }
}
