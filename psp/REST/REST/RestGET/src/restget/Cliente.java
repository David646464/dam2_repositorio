package restget;

public class Cliente {

    private int codCliente;
    private String nombre;
    private String apellidos;
    private String vip;
    private int codProvincia;

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean isVip() {
        return "1".equals(vip);
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public int getCodCliente() {
        return codCliente;
    }
}
