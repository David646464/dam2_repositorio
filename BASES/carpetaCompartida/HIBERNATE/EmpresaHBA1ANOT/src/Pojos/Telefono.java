/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author usuario
 */
@Embeddable
public class Telefono {

    @Column(name = "Numero", length = 9, nullable = false)
    String numero;
    @Column(name = "Informacion", length = 15, nullable = true)
    String informacion;

    public Telefono(String numero, String informacion) {
        this.numero = numero;
        this.informacion = informacion;
    }

    public Telefono() {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

}
