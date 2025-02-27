//David Sanchez peso 77465294Y

package pojos;

import java.util.*;

public class Fotografo implements java.io.Serializable {

    private int idFotografo;
    private String nombre;
    private String apellidos;
    private String seudonimo;
    private Contacto contacto;
    private Licencia licencia;
    private Collection<Fotografia> fotografias = new ArrayList<>();
    private List<Material> materiales = new ArrayList<>();
    private Set<Evento> eventos = new HashSet<>();
    private Map<String,String> idiomas = new HashMap<>();
    private Fotografo influencer ;
    private Set<Fotografo> influenciados;

    public Fotografo() {
    }

    public Fotografo(int idFotografo, String nombre, String apellidos, String seudonimo) {
        this.idFotografo = idFotografo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.seudonimo = seudonimo;

    }


    public Fotografo(int idFotografo, String nombre, String apellidos, String seudonimo, Fotografo influencer, Licencia licencia) {
        this.idFotografo = idFotografo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.seudonimo = seudonimo;


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


    public Collection<Fotografia> getFotografias() {
        return fotografias;
    }

    public void setFotografias(Collection<Fotografia> fotografias) {
        this.fotografias = fotografias;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public Map<String, String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Map<String, String> idiomas) {
        this.idiomas = idiomas;
    }

    public Fotografo getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Fotografo influencer) {
        this.influencer = influencer;
    }

    public Set<Fotografo> getInfluenciados() {
        return influenciados;
    }

    public void setInfluenciados(Set<Fotografo> influenciados) {
        this.influenciados = influenciados;
    }
}
