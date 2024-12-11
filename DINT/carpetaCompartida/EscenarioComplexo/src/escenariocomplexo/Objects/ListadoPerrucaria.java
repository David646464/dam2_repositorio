package escenariocomplexo.Objects;

import escenariocomplexo.Utils.*;

public class ListadoPerrucaria {
    int codCita;
    String propietario;
    String can;
    String data;
    String hora;

    public ListadoPerrucaria(int codCita, String nombrePropietario, String ap1Propietario, String ap2Propietario, 
            String can, String data, int hora) {
        this.codCita=codCita;
        this.propietario = nombrePropietario+ " "+ ap1Propietario+" "+ap2Propietario;
        this.can = can;
        this.data = escenariocomplexo.Utils.Datas.DataFormatoMySQLYYYY_GUION_MM_GUION_DDAFormatoDia_BARRA_Mes_BARRA_Anho(data);
        this.hora = hora+".00 h";
    }

    @Override
    public String toString() {      
        return propietario;
    }

    public String getCan() {
        return can;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public int getCodCita() {
        return codCita;
    }
    
    
    
}