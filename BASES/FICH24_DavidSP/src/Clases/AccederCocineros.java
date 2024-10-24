//david sanchez peso
package Clases;

import objetos.Cocinero;
import objetos.InfoCocinero;
import objetos.Restaurante;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AccederCocineros {
    private String root;
    private ObjectOutputStream objectOutputStream;
    public AccederCocineros(String root) {
        this.root = root;

    }

    public static void imprimirEmpleadosDeRestaurante(Restaurante restaurante) {
        System.out.println("Cocineros");
        for (InfoCocinero infoCocinero : restaurante.getCocineros()){
            Cocinero cocinero = buscarCocinero(infoCocinero.getCodigo());
            if (cocinero != null){
                System.out.println(cocinero);
            }
        }

    }

    //Renueva el objeto ObjectOutputStream para poder escribir
    public void abrirescritura() throws IOException {
        if (new File(root).exists()){
            new File(root).createNewFile();
        }
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(root));
    }
    //Cierra el objeto ObjectOutputStream
    public void cerrarescritura() throws IOException {
        objectOutputStream.close();
    }


    //Metodo para guardar un solo cocinero y printear todos los cocineros
    public void guardarCocineroIndividual(Cocinero cocinero) throws IOException {
            if (!Existe(cocinero)) {
                cocinero.setCodigo(obtenerCodigo()+1);
                objectOutputStream.writeObject(cocinero);
            }
            listarCocineros();

    }
    //Metodo usado en guardarCocineros para ir guardando los cocineros
    public void guardarCocinero(Cocinero cocinero) throws IOException {
        if (!Existe(cocinero)) {
            cocinero.setCodigo(obtenerCodigo()+1);
            objectOutputStream.writeObject(cocinero);
        }
    }

    //Obtiene el proximo codigo para el nuevo cocinero
    private int obtenerCodigo() throws IOException {

        int numero = 0;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/archivos/Cocineros.dat"));
            while (true){
                if ((numero = leerCocinero(objectInputStream).getCodigo()) > numero){

                };
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        return numero;
    }

    //Comprueba si ya existe
    private boolean Existe(Cocinero cocinero) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/archivos/Cocineros.dat"));

        try {
            while (true){
                if (cocinero.equals((Cocinero) objectInputStream.readObject())){
                    objectInputStream.close();
                    return true;
                }
            }
        }catch (Exception e){
            objectInputStream.close();
            return false;
        }


    }

    //Le un cocinero continuando el flujo que se le pasa por parametro
    private Cocinero leerCocinero(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        return (Cocinero) objectInputStream.readObject();
    }

    //Metodo general para guardar todos los cocineros de un txt
    public void guardarCocineros(String root) throws Exception {
        BuferedUtil buferedUtil = new BuferedUtil(root);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(root));
        int lineas = (int) buferedUtil.getBufferedReader().lines().count();
        for (int i = 0; i < lineas; i++) {
            String linea = bufferedReader.readLine();
            ArrayList<String> listado = buferedUtil.leerConPatronDeSeparacion(linea,",");
            ArrayList<String> recetas = new ArrayList<>();
            ArrayList<String> fecha = buferedUtil.leerConPatronDeSeparacion(listado.get(2),"/");
            LocalDate localDate = LocalDate.of(Integer.valueOf(fecha.get(2)),Integer.valueOf(fecha.get(1)),Integer.valueOf(fecha.get(0)));
            for (int j = 3; j < listado.size(); j++) {
                recetas.add(listado.get(j));
            }
            Cocinero cocinero = new Cocinero(listado.get(0),listado.get(1), localDate,recetas);
            guardarCocinero(cocinero);
        }
        bufferedReader.close();
        listarCocineros();
    }

    //Lista todos los cocineros
    public void listarCocineros()  {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/archivos/Cocineros.dat"));){
            while (true){

                System.out.println((Cocinero)objectInputStream.readObject());
            }
        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }

    }

    //Busca si un cocinero esta dado de alta o no por el objeto InfoCocinero
    public boolean buscarCodigo(InfoCocinero infoCocinero) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/archivos/Cocineros.dat"));){
            while (true){
            Cocinero cocinero = (Cocinero)objectInputStream.readObject();
              if (cocinero.getCodigo() == infoCocinero.getCodigo()){
                  return true;
              }
            }
        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }
        return false;
    }

    public static Cocinero buscarCocinero(int codigo) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/archivos/Cocineros.dat"));){
            while (true){
                Cocinero cocinero = (Cocinero)objectInputStream.readObject();
                if (cocinero.getCodigo() == codigo){
                    return cocinero;
                }
            }
        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }
        return null;
    }
}
