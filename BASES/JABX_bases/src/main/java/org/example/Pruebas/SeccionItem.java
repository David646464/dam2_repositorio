package org.example.Pruebas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeccionItem{

	@JsonProperty("libros")
	private Libros libros;

	@JsonProperty("nombre")
	private String nombre;

	public void setLibros(Libros libros){
		this.libros = libros;
	}

	public Libros getLibros(){
		return libros;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	@Override
 	public String toString(){
		return 
			"SeccionItem{" + 
			"libros = '" + libros + '\'' + 
			",nombre = '" + nombre + '\'' + 
			"}";
		}
}