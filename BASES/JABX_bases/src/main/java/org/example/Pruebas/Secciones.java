package org.example.Pruebas;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Secciones{

	@JsonProperty("seccion")
	private List<SeccionItem> seccion;

	public void setSeccion(List<SeccionItem> seccion){
		this.seccion = seccion;
	}

	public List<SeccionItem> getSeccion(){
		return seccion;
	}

	@Override
 	public String toString(){
		return 
			"Secciones{" + 
			"seccion = '" + seccion + '\'' + 
			"}";
		}
}