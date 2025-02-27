//David Sanchez peso 77465294Y

package pojos;

public class Material {
    private  int tidFotografo;
    private String numeroSerie;
    private String material;
    private String marca;
    private String modelo;

    public Material() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getTidFotografo() {
        return tidFotografo;
    }

    public void setTidFotografo(int tidFotografo) {
        this.tidFotografo = tidFotografo;
    }
}
