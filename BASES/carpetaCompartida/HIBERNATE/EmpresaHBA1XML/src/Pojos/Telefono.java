/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.util.Objects;

/**
 *
 * @author usuario
 */
public class Telefono {
    String numero;
    String informacion;

    public Telefono(String numero, String informacion) {
        this.numero = numero;
        this.informacion = informacion;
    }

    public Telefono() {
    }
    

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return numero.equals(telefono.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }
}
