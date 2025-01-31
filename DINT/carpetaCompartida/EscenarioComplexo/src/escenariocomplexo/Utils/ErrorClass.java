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
            case 1 :
                mensaje = "Se debe especificar el chip";
                break;
            case 2 :
                mensaje = "El chip existe. Introduzca uno que no exista";
                break;
            case 3 :
                mensaje = "Se debe especificar el nombre";
                break;
            case 4 :
                mensaje = "Se debe seleccionar una raza";
                break;
            case 5 :
                mensaje = "Se debe seleccionar un propietario";
                break;
            //Errores del panel razas
            case 6 :
                mensaje = "Se debe especificar el nombre de la raza";
                break;
            case 7 :
                mensaje = "Esa raza ya existe";
                break;
            //Errores del panel propietarios
            case 8 :
                mensaje = "Se debe especificar el DNI";
                break;
            case 9 :
                mensaje = "Ese DNI ya existe";
                break;
            case 10 :
                mensaje = "Se debe especificar el Nombre";
                break;
            case 11 :
                mensaje = "Se debe especificar el Apellido 1";
                break;
            case 12 :
                mensaje = "Se debe especificar el Telefono";
                break;
            case 13 :
                mensaje = "El numero de telefono no teien el formato (ej. 123456789)";
                break;
            case 14 :
                mensaje = "Se debe especificar el Email";
                break;
            case 15 :
                mensaje = "El Email no tiene el formato adecuado (ej. XXXXX@XXXX.XXX)";
                break;
            case 16 :
                mensaje = "El dni es incorrecto";
                break;
            //Errores en vacinacion
            case 17 :
                mensaje = "Para poder borrar esa dosis tienes que borrar las posteriores antes";
                break;
            case 18 :
                mensaje = "Hay que seleccionar el dueño y el perro y rrellenar todos los campos";
                break;
            case 19 :
                mensaje = "Ya se le administró todas las dosis de esa vacina";
                break;
            //Errores en perruqueria
            case 20 :
                mensaje = "No se ha elegido fecha";
                break;
            case 21 :
                mensaje = "No hay perro seleccionado";
                break;
            //Errores al abrir mas de las xanelas permitidas
            case 22 :
                mensaje = "No se pueden abrir mas ventanas de perruquerias";
                break;
            case 23 :
                mensaje = "No se pueden abrir mas ventanas de altas de cans/razas";
                break;
            case 24 :
                mensaje = "No se pueden abrir mas ventanas de propietarios";
                break;
            case 25 :
                mensaje = "No se pueden abrir mas ventanas de vacinacions";
                break;
            case 26 :
                mensaje = "No se puede abrir mas ventanas de xestion de citas";
                break;
            //Errores en editar propietario
            case 27 :
                mensaje = "No se puede borrar al propieratio porque ten cans";
                break;
            case 28 :
                mensaje = "El campo nome esta incorrecto";
                break;
            case 29 :
                mensaje = "El campo apelido1 esta incorrecto";
                break;
            case 30 :
                mensaje = "El campo apelido2 esta incorrecto";
                break;
            case 31 :
                mensaje = "El campo telefono esta incorrecto";
                break;
            case 32 :
                mensaje = "El campo Email esta incorrecto";
                break;
                //errores de xanelas
            case 33 :
                mensaje = "No se pueden abrir mas listas de propietarios";
                break;
            case 34 :
                mensaje = "No se pueden abrir mas ediciones de propietarios";
                break;
        }

        JOptionPane.showInternalMessageDialog(
                jDesktopPane, // JDesktopPane como parent para modal interno
                mensaje, // Mensaje de error
                "Error", // Título del diálogo
                JOptionPane.ERROR_MESSAGE // Tipo de mensaje
        );

    }

}
