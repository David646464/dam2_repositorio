package psp.concesionario;

import java.util.List;

public class Concesonario {
    private final Integer NUM_CLIENTES = 50;
    private final Integer NUM_ATECA = 3;
    private final Integer NUM_IBIZA = 7;
    private final Integer NUM_VENDEDORES = 1;


    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private List<Coche>coches;

    public Concesonario() {
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes.add(new Cliente(this,i));
            clientes.get(i).start();
        }

        for (int i = 0; i < NUM_ATECA; i++) {
            coches.add(new Ateca(i));
        }

        for (int i = 0; i < NUM_IBIZA; i++) {
            coches.add(new Ibiza(i));
        }
        for (int i = 0; i < NUM_VENDEDORES; i++) {
            vendedores.add(new Vendedor(this,i));
            vendedores.get(i).start();
        }

    }

    public void vender(Vendedor vendedor) {

    }

    public void comprar(Cliente cliente) {
    }

    public void verCoche(Cliente cliente) {

    }
}
