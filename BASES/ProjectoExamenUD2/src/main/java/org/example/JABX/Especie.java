// Especie.java
package org.example.JABX;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.io.Serializable;
import java.util.List;

public class Especie implements Serializable {
    private String nome;
    private String valor;
    private String habitat;
    private String nomeCientifico;
    private String outrosNomes;
    private String capturaMinima;
    private String unidade;
    private List<String> notas;
    private String descricion;

    @XmlAttribute
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlAttribute
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @XmlElement(name = "Habitat")
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @XmlElement(name = "NomeCientifico")
    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    @XmlElement(name = "OutrosNomes")
    public String getOutrosNomes() {
        return outrosNomes;
    }

    public void setOutrosNomes(String outrosNomes) {
        this.outrosNomes = outrosNomes;
    }

    @XmlElement(name = "CapturaMinima")
    public String getCapturaMinima() {
        return capturaMinima;
    }

    public void setCapturaMinima(String capturaMinima) {
        this.capturaMinima = capturaMinima;
    }

    @XmlAttribute(name = "unidade")
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @XmlElement(name = "Nota")
    public List<String> getNotas() {
        return notas;
    }

    public void setNotas(List<String> notas) {
        this.notas = notas;
    }

    @XmlElement
    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
}