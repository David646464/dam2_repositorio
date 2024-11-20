/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escenariocomplexo.Utils;

import escenariocomplexo.IFrmVacinacions;
import escenariocomplexo.IFrmXestionPerruqueria;
import escenariocomplexo.IFrmaltasPropietarios;
import escenariocomplexo.IFrmltasCansRazas;
import javax.swing.JDesktopPane;

/**
 *
 * @author Nitropc
 */
public class xestorXanelas {

    private static int numXanelasVacinacions = 0;
    private static int MAXXanelasVacinacions = 1;
    private static int numXanelasPropietarios;
    private static int MAXXanelasPropietarios = -1;
    private static int numXanelasCansRazas = 0;
    private static int MAXXanelasCansRazas = 1;
    private static int numXanelasPerruqueria = 0;
    private static int MAXXanelasPerruqueria = 1;

    public static void nuevaVacinacion(JDesktopPane desktopPane) {
        if (numXanelasVacinacions < MAXXanelasVacinacions || MAXXanelasVacinacions == -1) {
            IFrmVacinacions frmVacinacions = new IFrmVacinacions();
            desktopPane.add(frmVacinacions);
            frmVacinacions.setVisible(true);
            numXanelasVacinacions++;
        } else {
            ErrorClass.mostrarError(25, desktopPane);
        }
    }

    public static void nuevoPropietario(JDesktopPane desktopPane) {
        if (numXanelasPropietarios < MAXXanelasPropietarios || MAXXanelasPropietarios == -1) {
            IFrmaltasPropietarios frmaltasPropietarios = new IFrmaltasPropietarios();
            desktopPane.add(frmaltasPropietarios);
            frmaltasPropietarios.setVisible(true);
            numXanelasPropietarios++;
        } else {
            ErrorClass.mostrarError(24, desktopPane);
        }
    }

    public static void nuevaCansRazas(JDesktopPane desktopPane) {
        if (numXanelasCansRazas < MAXXanelasCansRazas || MAXXanelasCansRazas == -1) {
            IFrmltasCansRazas cansRazas = new IFrmltasCansRazas();
            desktopPane.add(cansRazas);
            cansRazas.setVisible(true);
            numXanelasCansRazas++;
        } else {
            ErrorClass.mostrarError(23, desktopPane);
        }
    }

    public static void nuevaPerruqueria(JDesktopPane desktopPane) {
        if (numXanelasPerruqueria < MAXXanelasPerruqueria || MAXXanelasPerruqueria == -1) {
            IFrmXestionPerruqueria frmXestionPerruqueria = new IFrmXestionPerruqueria();
            desktopPane.add(frmXestionPerruqueria);
            frmXestionPerruqueria.setVisible(true);
            numXanelasPerruqueria++;
        } else {
            ErrorClass.mostrarError(22, desktopPane);
        }
    }

    public static void cerrarPerruqueria() {
        numXanelasPerruqueria--;
    }

    public static void cerrarVacinacion() {
        numXanelasVacinacions--;
    }

    public static void cerrarCansRazas() {
        numXanelasCansRazas--;
    }

    public static void cerrarPropietario() {
        numXanelasPropietarios--;
    }

}
