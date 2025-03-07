package CLASESDATOS1;

import java.io.Serializable;

public class NotaModulo implements Serializable {

    String asignatura;
    Double nota;

    public NotaModulo() {
    }

    public NotaModulo(String asignatura, Double nota) {
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }


    @Override
    public String toString() {
        return "NotaModulo{" +
                "asignatura='" + asignatura + '\'' +
                ", nota=" + nota +
                '}';
    }
}
