package org.example.Pruebas;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Autores{

	@JsonProperty("autor")
	private List<String> autor;

	public void setAutor(List<String> autor){
		this.autor = autor;
	}

	public List<String> getAutor(){
		return autor;
	}

	@Override
 	public String toString(){
		return 
			"Autores{" + 
			"autor = '" + autor + '\'' + 
			"}";
		}
}