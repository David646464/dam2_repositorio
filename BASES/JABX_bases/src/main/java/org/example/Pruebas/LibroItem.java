package org.example.Pruebas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LibroItem{

	@JsonProperty("editorial")
	private String editorial;

	@JsonProperty("precio")
	private Object precio;

	@JsonProperty("fechaEdicion")
	private String fechaEdicion;

	@JsonProperty("isbn")
	private String isbn;

	@JsonProperty("copias")
	private Copias copias;

	@JsonProperty("titulo")
	private String titulo;

	@JsonProperty("id")
	private String id;

	@JsonProperty("autores")
	private Autores autores;

	@JsonProperty("numeroDePaginas")
	private int numeroDePaginas;

	public void setEditorial(String editorial){
		this.editorial = editorial;
	}

	public String getEditorial(){
		return editorial;
	}

	public void setPrecio(Object precio){
		this.precio = precio;
	}

	public Object getPrecio(){
		return precio;
	}

	public void setFechaEdicion(String fechaEdicion){
		this.fechaEdicion = fechaEdicion;
	}

	public String getFechaEdicion(){
		return fechaEdicion;
	}

	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

	public String getIsbn(){
		return isbn;
	}

	public void setCopias(Copias copias){
		this.copias = copias;
	}

	public Copias getCopias(){
		return copias;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAutores(Autores autores){
		this.autores = autores;
	}

	public Autores getAutores(){
		return autores;
	}

	public void setNumeroDePaginas(int numeroDePaginas){
		this.numeroDePaginas = numeroDePaginas;
	}

	public int getNumeroDePaginas(){
		return numeroDePaginas;
	}

	@Override
 	public String toString(){
		return 
			"LibroItem{" + 
			"editorial = '" + editorial + '\'' + 
			",precio = '" + precio + '\'' + 
			",fechaEdicion = '" + fechaEdicion + '\'' + 
			",isbn = '" + isbn + '\'' + 
			",copias = '" + copias + '\'' + 
			",titulo = '" + titulo + '\'' + 
			",id = '" + id + '\'' + 
			",autores = '" + autores + '\'' + 
			",numeroDePaginas = '" + numeroDePaginas + '\'' + 
			"}";
		}
}