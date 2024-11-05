package psp.Apuestas;

import java.util.Objects;

public class Apuesta {
    private int golesEquipo1;
    private int golesEquipo2;
    private int dineroApostado;

    public Apuesta(int golesEquipo1, int golesEquipo2, int dineroApostado) {
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.dineroApostado = dineroApostado;
    }

    public int getGolesEquipo1() {
        return this.golesEquipo1;
    }

    public int getGolesEquipo2() {
        return this.golesEquipo2;
    }

    public int getDineroApostado() {
        return this.dineroApostado;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Apuesta apuesta)) return false;
        return getGolesEquipo1() == apuesta.getGolesEquipo1() && getGolesEquipo2() == apuesta.getGolesEquipo2();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGolesEquipo1(), getGolesEquipo2());
    }
}
