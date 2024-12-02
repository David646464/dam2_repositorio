package examen.ejercicio1;

public class Politico extends Thread{
    private int idPolitico ;
    private int retiradaAnterior = 1;
    private int numRetirada;

    public Politico(int i) {
        this.idPolitico = i;
    }

    @Override
    public void run() {
        while (numRetirada < 10){
            try {

                Banco.getInstance().sacar(retiradaAnterior + 1,this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            numRetirada++;
        }
        Banco.getPoliticos().remove(this);
        System.out.println("El politico:" + idPolitico + " deja el fondo tranquilo en el dia " + Banco.getInstance().getDia());
    }

    public int getIdPolitico() {
        return idPolitico;
    }

    public void setIdPolitico(int idPolitico) {
        this.idPolitico = idPolitico;
    }

    public int getRetiradaAnterior() {
        return retiradaAnterior;
    }

    public void setRetiradaAnterior(int retiradaAnterior) {
        this.retiradaAnterior = retiradaAnterior;
    }

    public int getNumRetirada() {
        return numRetirada;
    }

    public void setNumRetirada(int numRetirada) {
        this.numRetirada = numRetirada;
    }
}
