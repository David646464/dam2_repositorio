package org.example.Pruebas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Biblioteca{

	@JsonProperty("campus")
	private String campus;

	@JsonProperty("secciones")
	private Secciones secciones;

	@JsonProperty("facultad")
	private String facultad;

	public void setCampus(String campus){
		this.campus = campus;
	}

	public String getCampus(){
		return campus;
	}

	public void setSecciones(Secciones secciones){
		this.secciones = secciones;
	}

	public Secciones getSecciones(){
		return secciones;
	}

	public void setFacultad(String facultad){
		this.facultad = facultad;
	}

	public String getFacultad(){
		return facultad;
	}

	@Override
 	public String toString(){
		return 
			"Biblioteca{" + 
			"campus = '" + campus + '\'' + 
			",secciones = '" + secciones + '\'' + 
			",facultad = '" + facultad + '\'' + 
			"}";
		}
}