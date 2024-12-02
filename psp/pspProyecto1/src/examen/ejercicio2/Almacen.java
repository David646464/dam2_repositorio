package examen.ejercicio2;

import examen.ejercicio1.Banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Almacen {
    private static final int PORCENTAJE_COMPRA = 30;
    private static final int NUM_PRODUCTOS = 10;
    private static final int CANT_POR_PRODUCTO = 10;
    private static final int NUM_CLIENTES = 100;

    private static HashMap<Integer, Integer> productos = new HashMap<>();
    private static ArrayList<Integer> productosRestantes = new ArrayList<>();
    private static HashMap<Integer,ArrayList<String>> clientesPorProducto = new HashMap<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private boolean finalizoSimulacion = false;
    private static Almacen instancia;


    public static void iniciarSimulacion() {
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            productos.put(i, CANT_POR_PRODUCTO);
            productosRestantes.add(i);
            clientesPorProducto.put(i,new ArrayList<>());
        }

        for (int i = 0; i < NUM_CLIENTES; i++) {
            Cliente cliente = new Cliente(i);
            clientes.add(cliente);
            cliente.start();
        }
    }

    public static Almacen getInnstance() {
        if (instancia == null) {
            instancia = new Almacen();
        }
        return instancia;
    }

    public static HashMap<Integer, Integer> getProductos() {
        return productos;
    }

    public static void setProductos(HashMap<Integer, Integer> productos) {
        Almacen.productos = productos;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(List<Cliente> clientes) {
        Almacen.clientes = clientes;
    }

    public boolean isFinalizoSimulacion() {
        return finalizoSimulacion;
    }

    public void setFinalizoSimulacion(boolean finalizoSimulacion) {
        this.finalizoSimulacion = finalizoSimulacion;
    }

    public void bucarProducto(Cliente cliente) {

        synchronized (productosRestantes) {
            if (productos.isEmpty()) {
                finalizoSimulacion = true;
                return;
            }
            int producto =  productosRestantes.get((int) (Math.random() * productos.size()));

            if (!cliente.getArticulosComprados().keySet().contains(producto) ) {
                if (productos.get(producto) < NUM_PRODUCTOS / 2) {
                    comprar(cliente, producto, productos.get(producto));
                } else {
                    int numAleatorio = (int) (Math.random() * 100);
                    if (numAleatorio < PORCENTAJE_COMPRA) {
                        comprar(cliente, producto, productos.get(producto));
                    }
                }
            }
        }

    }

    public static void imprimirCompras() throws InterruptedException {
        for (Cliente cliente: clientes){
            cliente.join();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : clientesPorProducto.keySet()){
            stringBuilder.append(String.valueOf(integer) + " - ");
            for (String string : clientesPorProducto.get(integer)){
                stringBuilder.append(" " + string);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());

    }

    private void comprar(Cliente cliente, int producto, int numStock) {
        cliente.getArticulosComprados().put(producto, numStock);
        ArrayList<String> a = clientesPorProducto.get(producto);
        a.add(String.valueOf(cliente.getIDcliente()) + " - " + numStock);
        clientesPorProducto.put(producto,a);
        if (productos.get(producto) <= 1) {
            productos.remove(producto);
            productosRestantes.remove(Integer.valueOf(producto));
            System.out.println("El cliente: " + cliente.getIDcliente() + " ha comprado la ultima existencia");
        } else {
            productos.put(producto, productos.get(producto) - 1);
            System.out.println("El cliente: " + cliente.getIDcliente() + " ha comprado el producto " + producto + " y queda: " + productos.get(producto));
        }

    }
}
