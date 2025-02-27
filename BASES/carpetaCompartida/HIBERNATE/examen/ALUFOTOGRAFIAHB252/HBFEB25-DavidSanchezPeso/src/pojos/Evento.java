//David Sanchez peso 77465294Y

package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Evento  implements java.io.Serializable {

     private int idEvento;
     private String nombreEvento;
     private String ciudad;
     private Date fecha;
     private String tipoEvento;
     private Set<Fotografo> fotografos = new HashSet<>();
   

    public Evento() {
    }

	
    public Evento(int idEvento, String nombreEvento, String ciudad, Date fecha, String tipoEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.tipoEvento = tipoEvento;
    }
 
   
    public int getIdEvento() {
        return this.idEvento;
    }
    
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public String getNombreEvento() {
        return this.nombreEvento;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipoEvento() {
        return this.tipoEvento;
    }
    
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }


    public Set<Fotografo> getFotografos() {
        return fotografos;
    }

    public void setFotografos(Set<Fotografo> fotografos) {
        this.fotografos = fotografos;
    }
}


