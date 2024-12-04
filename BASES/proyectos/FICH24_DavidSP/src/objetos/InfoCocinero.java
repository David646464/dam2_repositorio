//david sanchez peso
package objetos;

import java.io.Serializable;

public class InfoCocinero implements Serializable {
    private int codigo;
    private String tipo;

    public InfoCocinero(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
