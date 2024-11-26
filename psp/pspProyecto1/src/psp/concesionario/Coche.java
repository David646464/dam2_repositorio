package psp.concesionario;

public class Coche {
    private Integer id = 0;
    private Integer numVisitas = 0;
    private boolean vendido = false;
    private boolean VerDetalles = false;
    private String marca = "";
    private String modelo = "";

    public void setNumVisitas(Integer numVisitas) {
        this.numVisitas = numVisitas;
    }

    public Integer getNumVisitas() {
        return numVisitas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVerDetalles(boolean VerDetalles) {
        this.VerDetalles = VerDetalles;
    }

    public boolean isVerDetalles() {
        return VerDetalles;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void visitar(){
        setNumVisitas(getNumVisitas()+1);
    }


}
