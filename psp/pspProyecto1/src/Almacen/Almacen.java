package Almacen;

import java.util.HashMap;
import java.util.Map;

public class Almacen {
    private static Map<String, Integer> almacen = nuevoAlmacen();

    private static Map<String, Integer> nuevoAlmacen() {
        Map<String, Integer> almacen = new HashMap<>();
        almacen.put("papas", 100);
        almacen.put("zanahorias", 100);
        almacen.put("cebollas", 100);
        almacen.put("tomates", 100);
        almacen.put("lechugas", 100);
        return almacen;
    }



    public static synchronized String StringStock() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : almacen.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }


    public static String StringStock(String producto) {
        if (almacen.containsKey(producto)) {
            return producto + ": " + almacen.get(producto);
        } else {
            return "Producto no encontrado";
        }
    }

    public static synchronized String ObtenerProducto(String producto, int cantidad) {
        if (almacen.containsKey(producto)) {
            int stock = almacen.get(producto);
            if (stock >= cantidad) {
                almacen.put(producto, stock - cantidad);
                return "Producto obtenido";
            } else {
                return "No hay suficiente stock";
            }
        } else {
            return "Producto no encontrado";
        }
    }
}
