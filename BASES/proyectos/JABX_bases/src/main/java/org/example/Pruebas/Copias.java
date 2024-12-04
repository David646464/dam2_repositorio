package org.example.Pruebas;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Copias{

	@JsonProperty("copia")
	private List<CopiaItem> copia;

	public void setCopia(List<CopiaItem> copia){
		this.copia = copia;
	}

	public List<CopiaItem> getCopia(){
		return copia;
	}

	@Override
 	public String toString(){
		return 
			"Copias{" + 
			"copia = '" + copia + '\'' + 
			"}";
		}
}