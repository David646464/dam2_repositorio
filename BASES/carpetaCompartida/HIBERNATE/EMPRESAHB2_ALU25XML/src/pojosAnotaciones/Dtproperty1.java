package pojosAnotaciones;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dtproperties")
public class Dtproperty1 {
    @EmbeddedId
    private Dtproperty1Id id;

    @Column(name = "objectid")
    private Integer objectid;

    @Column(name = "\"value\"")
    private String value;

    @Nationalized
    @Column(name = "uvalue")
    private String uvalue;

    @Column(name = "lvalue")
    private byte[] lvalue;

    @Column(name = "version", nullable = false)
    private Integer version;

    public Dtproperty1Id getId() {
        return id;
    }

    public void setId(Dtproperty1Id id) {
        this.id = id;
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUvalue() {
        return uvalue;
    }

    public void setUvalue(String uvalue) {
        this.uvalue = uvalue;
    }

    public byte[] getLvalue() {
        return lvalue;
    }

    public void setLvalue(byte[] lvalue) {
        this.lvalue = lvalue;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}