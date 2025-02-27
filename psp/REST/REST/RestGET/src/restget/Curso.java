package restget;

public class Curso {
    private int id;
    private String nombre;
    private int numHoras;

    // Constructor
    public Curso(int id, String nombre, int numHoras) {
        this.id = id;
        this.nombre = nombre;
        this.numHoras = numHoras;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumHoras() {
        return numHoras;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numHoras=" + numHoras +
                '}';
    }
}