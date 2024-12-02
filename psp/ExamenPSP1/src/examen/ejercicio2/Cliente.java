package examen.ejercicio2;

import java.util.HashMap;
import java.util.Random;

public class Cliente extends Thread{
    private final int IDcliente;
    private HashMap<Integer,Integer> articulosComprados = new HashMap<>();


    public Cliente(int i) {
        this.IDcliente = i;
    }

    @Override
    public void run() {
        while (!Almacen.getInnstance().isFinalizoSimulacion()){
            try {
                int numero = new Random().nextInt(100,500);
                sleep(numero);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Almacen.getInnstance().bucarProducto(this);
        }

    }



    public int getIDcliente() {
        return IDcliente;
    }

    public HashMap<Integer, Integer> getArticulosComprados() {
        return articulosComprados;
    }
}
