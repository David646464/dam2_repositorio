package psp.concesionario;

public class Ateca extends Coche{

    public Ateca(Integer id) {
        super();
        setMarca("Ateca");
        setModelo("León");
        setId(id);
    }

    public void verDetalles(){
        System.out.println("Marca: "+getMarca());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Numero de visitas: "+getNumVisitas());
        System.out.println("Vendido: "+isVendido());
    }

    public void vender(){
        setVendido(true);
    }
}
