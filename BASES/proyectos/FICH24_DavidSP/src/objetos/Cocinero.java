//david sanchez peso
package objetos;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cocinero implements Serializable {
    //static final long serialUID = 100L;
    private int Codigo;
    private String Apodo;
    private String NombreCompleto;
    private LocalDate fechaNacimiento;
    ArrayList<String> recetas;

    public Cocinero(String apodo, String nombreCompleto, LocalDate fechaNacimiento, ArrayList<String> recetas) {
        Apodo = apodo;
        NombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.recetas = recetas;
    }

    public Cocinero(String apodo, String nombreCompleto, LocalDate fechaNacimiento) {
        Apodo = apodo;
        NombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;

    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getApodo() {
        return Apodo;
    }

    public void setApodo(String apodo) {
        Apodo = apodo;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<String> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<String> recetas) {
        this.recetas = recetas;
    }

    @Override
    public String toString() {
        String texto = "--------------------\n"+
                "Cocinero código: " + getCodigo() + "\n"+
                "--------------------\n"+
                "Nombre: " + getNombreCompleto() + " Apodo: " + getApodo() + "\n"+
                "Fecha nacimiento: " + fechaNacimiento.toString() + "\n"+
                "Recetas:[";
        for (String receta : recetas){
            texto+= receta + ",";
        }
        texto += "]";
        return texto;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cocinero && ((Cocinero) obj).getApodo().equals(this.getApodo());
    }

}


