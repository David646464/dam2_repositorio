package org.example.Pruebas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CopiaItem{

	@JsonProperty("estado")
	private String estado;

	@JsonProperty("numero")
	private int numero;

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getEstado(){
		return estado;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}

	public int getNumero(){
		return numero;
	}

	@Override
 	public String toString(){
		return 
			"CopiaItem{" + 
			"estado = '" + estado + '\'' + 
			",numero = '" + numero + '\'' + 
			"}";
		}
}