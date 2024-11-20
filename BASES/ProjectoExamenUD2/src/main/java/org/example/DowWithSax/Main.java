package org.example.DowWithSax;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //Modificar una biblioteca.xml con Acciiones DOM
        AccionesDOM accionesDOM = new AccionesDOM("src/main/resources/BibliotecaInformatica.xml");
        //meter un autor
        accionesDOM.anadirElementoHijoAListaPorIdentificacor("autor", "Juan Pérez", "libro", "ID", "A001", "autores", null);
        //meter una copia
        HashMap<String, String> atributos = new HashMap<>();
        atributos.put("numero", "4");
        atributos.put("estado", "Disponible");
        accionesDOM.anadirElementoHijoAListaPorIdentificacor("copia", null, "libro", "ID", "A001", "copias",atributos);
        //AnadirHijoDirecto
        accionesDOM.anadirElementoHijoAListaPorIdentificacor("libro", "ID", "A001", "prueba", "30",null);
        //Modificar elemento
        accionesDOM.modificarElementoPorIdentificacor("libro", "ID", "A001", "precio", "40",null);
        //Modificar valor elemento
        accionesDOM.modificarValorElementoPorIdentificacor("libro", "ID", "A001", "precio", "50");
        //Modificar atributo
        accionesDOM.modificarAtributoElementoPorIdentificacor("libro", "ID", "A001", "isbn", "666-1234567891");
        //Eliminar elemento
        accionesDOM.eliminarElementoPorIdentificacor("libro", "ID", "A001", "prueba");
        //Eliminar atributo
        accionesDOM.eliminarAtributoElementoPorIdentificacor("libro", "ID", "A001", "isbn");
        //guaradar
        accionesDOM.saveXmlChanges("BibliotecaInformatica3.xml");




    }
}
