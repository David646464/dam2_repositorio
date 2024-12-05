package org.example.tarea2.objects;

public class Proxecto {
    private int numProxecto;
    private String nomeProxecto;
    private String lugar;
    private int numDepartamento;

    public Proxecto(int numProxecto, String nomeProxecto, String lugar, int numDepartamento) {
        this.numProxecto = numProxecto;
        this.nomeProxecto = nomeProxecto;
        this.lugar = lugar;
        this.numDepartamento = numDepartamento;
    }

    public int getNumProxecto() {
        return numProxecto;
    }

    public void setNumProxecto(int numProxecto) {
        this.numProxecto = numProxecto;
    }

    public String getNomeProxecto() {
        return nomeProxecto;
    }

    public void setNomeProxecto(String nomeProxecto) {
        this.nomeProxecto = nomeProxecto;
    }

    public String getCidade() {
        return lugar;
    }

    public void setCidade(String cidade) {
        this.lugar = cidade;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    @Override
    public String toString() {
        return "Proxecto{" +
                "numProxecto=" + numProxecto +
                ", nomeProxecto='" + nomeProxecto + '\'' +
                ", lugar='" + lugar + '\'' +
                ", numDepartamento=" + numDepartamento +
                '}';
    }
}
