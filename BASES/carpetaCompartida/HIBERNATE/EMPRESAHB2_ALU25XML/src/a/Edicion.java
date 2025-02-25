package a;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EDICION")
public class Edicion {
    @EmbeddedId
    private EdicionId id;

    @MapsId("codigo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Codigo", nullable = false)
    private Curso codigo;

    @Column(name = "Data")
    private LocalDate data;

    @Column(name = "Lugar", length = 25)
    private String lugar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Profesor", nullable = false)
    private a.Empregadofixo profesor;

    public EdicionId getId() {
        return id;
    }

    public void setId(EdicionId id) {
        this.id = id;
    }

    public Curso getCodigo() {
        return codigo;
    }

    public void setCodigo(Curso codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public a.Empregadofixo getProfesor() {
        return profesor;
    }

    public void setProfesor(a.Empregadofixo profesor) {
        this.profesor = profesor;
    }

}