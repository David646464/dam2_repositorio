package psp.concesionario;

public class Ibiza extends Coche{

    public Ibiza(Integer id) {
        super();
        setMarca("Ibiza");
        setModelo("Ibiza");
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
