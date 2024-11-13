/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escenariocomplexo.Utils;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Nitropc
 */
public class ErrorClass {

    public static void mostrarError(int numError, JDesktopPane jDesktopPane) {
        String mensaje = "";

        // Configurar el mensaje según el tipo de error
        switch (numError) {
            //Errores del panel cans
            case 1 ->
                mensaje = "Se debe especificar el chip";
            case 2 ->
                mensaje = "El chip existe. Introduzca uno que no exista";
            case 3 ->
                mensaje = "Se debe especificar el nombre";
            case 4 ->
                mensaje = "Se debe seleccionar una raza";
            case 5 ->
                mensaje = "Se debe seleccionar un propietario";
            //Errores del panel razas
            case 6 ->
                mensaje = "Se debe especificar el nombre de la raza";
            case 7 ->
                mensaje = "Esa raza ya existe";
            //Errores del panel propietarios
            case 8 ->
                mensaje = "Se debe especificar el DNI";
            case 9 ->
                mensaje = "Ese DNI ya existe";
            case 10 ->
                mensaje = "Se debe especificar el Nombre";
            case 11 ->
                mensaje = "Se debe especificar el Apellido 1";
            case 12 ->
                mensaje = "Se debe especificar el Telefono";
            case 13 ->
                mensaje = "El numero de telefono no teien el formato (ej. 123456789)";
            case 14 ->
                mensaje = "Se debe especificar el Email";
            case 15 ->
                mensaje = "El Email no tiene el formato adecuado (ej. XXXXX@XXXX.XXX)";
            case 16 ->
                 mensaje = "El dni es incorrecto";
        }

        JOptionPane.showInternalMessageDialog(
                jDesktopPane, // JDesktopPane como parent para modal interno
                mensaje, // Mensaje de error
                "Error", // Título del diálogo
                JOptionPane.ERROR_MESSAGE // Tipo de mensaje
        );

    }

}
