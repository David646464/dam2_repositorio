package org.example.Pruebas;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Libros{

	@JsonProperty("libro")
	private List<LibroItem> libro;

	public void setLibro(List<LibroItem> libro){
		this.libro = libro;
	}

	public List<LibroItem> getLibro(){
		return libro;
	}

	@Override
 	public String toString(){
		return 
			"Libros{" + 
			"libro = '" + libro + '\'' + 
			"}";
		}
}