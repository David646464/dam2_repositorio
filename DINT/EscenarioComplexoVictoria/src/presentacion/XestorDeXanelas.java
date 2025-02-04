/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

/**
 *
 * @author DAM 2 
 */
public class XestorDeXanelas {
    
    static boolean iFrmXestionVacinacionsAberto=false; 
    static boolean iFrmAltaPerrucariaAberto=false;
    static boolean iFrmBaixaListadoPerrucariaAberto=false;
    static boolean iFrmAltaOperacionsAberto=false;    
    static boolean iFrmBaixaListadoOperacionsAberto=false; 
    static boolean iFrmImprimirFacturasAberto=false;
    static boolean iFrmXestionPerruqueria =false; 
    static boolean iFrmListarCitasAberto = false;
    static boolean iFrmCitasPerruqueriaAberto = false;
    static boolean iFrmCitasListarAberto = false;
    
    public static boolean podeseAbrirIFrmBaixaListadoPerrucaria()
    {
        if(iFrmBaixaListadoPerrucariaAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }    
    public static boolean podeseAbrirIFrmBaixaListadoOperacions()
    {
        if(iFrmBaixaListadoOperacionsAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }        
    public static boolean podeseAbrirIFrmAltaOperacions()
    {
        if(iFrmAltaOperacionsAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }        
    public static boolean podeseAbrirIFrmXestionVacinacions()
    {
        if(iFrmXestionVacinacionsAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static boolean podeseAbrirIFrmAltaPerrucaria()
    {
        if(iFrmAltaPerrucariaAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }    
    
    public static void abrirIFrmXestionVacinacions()
    {
       iFrmXestionVacinacionsAberto=true; 
    }
    public static void abrirIFrmAltaOperacions()
    {
       iFrmAltaOperacionsAberto=true; 
    }    
    public static void abrirIFrmAltaPerrucaria()
    {
       iFrmAltaPerrucariaAberto=true; 
    }    
    public static void abrirIFrmBaixaListadoPerrucaria()
    {
       iFrmBaixaListadoPerrucariaAberto=true; 
    }        
    public static void abrirIFrmBaixaListadoOperacions()
    {
       iFrmBaixaListadoOperacionsAberto=true; 
    }            
    
    public static void pecharIFrmXestionVacinacions()
    {
       iFrmXestionVacinacionsAberto=false; 
    }        
    public static void pecharIFrmAltaOperacions()
    {
       iFrmAltaOperacionsAberto=false; 
    }            
    public static void pecharIFrmAltaPerrucaria()
    {
       iFrmAltaPerrucariaAberto=false; 
    }            
    public static void pecharIFrmBaixaListadoPerrucaria()
    {
       iFrmBaixaListadoPerrucariaAberto=false; 
    }                
    public static void pecharIFrmBaixaListadoOperacions()
    {
       iFrmBaixaListadoOperacionsAberto=false; 
    }    
    
    
     public static boolean podeseAbrirIFrmImprimirFacturas()
    {
        if(iFrmImprimirFacturasAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
     
    public static void abrirIFrmImprimirFacturas()
    {
       iFrmImprimirFacturasAberto=true; 
    }
    
    public static void pecharIFrmImprimirFacturas()
    {
       iFrmImprimirFacturasAberto=false; 
    } 
    
    public static boolean podeseAbrirIFrmXestionPerruqueria(){
        if(iFrmXestionPerruqueria)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void abrirIFrmXestionPerruqueria(){
        iFrmXestionPerruqueria = true;
    }
    
    public static boolean podeseAbrirIFrmListarCitas()
    {
        if(iFrmListarCitasAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void abrirIFrmListarCitas(){
        iFrmListarCitasAberto= true;
    }

    static boolean podeseAbrirIFrmCitas() {
        if(iFrmCitasPerruqueriaAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    static void abrirIFrmCitas() {
        iFrmCitasPerruqueriaAberto = true;
    }
    
    public static void pecharIFrmCitas()
    {
       iFrmCitasPerruqueriaAberto=false; 
    }

    static boolean podeseAbrirIFrmCitasListar() {
        if(iFrmCitasListarAberto)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    static void abrirIFrmCitasListar() {
       iFrmCitasListarAberto = true;
    }
    
    public static void pecharIFrmCitasListar()
    {
       iFrmCitasListarAberto=false; 
    }
}
