package pojos;

import java.util.Collection;

public class Fotografo implements java.io.Serializable {

    private int idFotografo;
     private String nombre;
    private String apellidos;
    private String seudonimo;
    private String direccion;
    private String email;
    private String telefonoFijo;
    private String telefonoMovil;
    private Collection<Fotografia> fotografias;
  

    public Fotografo() {
    }

    public Fotografo(int idFotografo, String nombre, String apellidos, String seudonimo, String email) {
        this.idFotografo = idFotografo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.seudonimo = seudonimo;
        this.email = email;
    }
    

    public Fotografo(int idFotografo, String nombre, String apellidos, String seudonimo, String direccion, String email, String telefonoFijo, String telefonoMovil, Fotografo influencer, Licencia licencia) {
        this.idFotografo = idFotografo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.seudonimo = seudonimo;
        this.direccion = direccion;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
       
    }

   

    public int getIdFotografo() {
        return idFotografo;
    }

    public void setIdFotografo(int idFotografo) {
        this.idFotografo = idFotografo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public Collection<Fotografia> getFotografias() {
        return fotografias;
    }

    public void setFotografias(Collection<Fotografia> fotografias) {
        this.fotografias = fotografias;
    }
}
