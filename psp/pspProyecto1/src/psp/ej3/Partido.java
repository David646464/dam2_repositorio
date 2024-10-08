package psp.ej3;

public class Partido implements Comparable{
    private Integer votos = 0;
    private String nombre;

    public synchronized void incrementarVotos(){
        Integer aux = votos;

        votos = aux + 1;
    }

    public Partido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public int compareTo(Object o) {
        Partido partido2 = (Partido) o;
        return Integer.compare(partido2.getVotos(), votos);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "votos=" + votos +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
